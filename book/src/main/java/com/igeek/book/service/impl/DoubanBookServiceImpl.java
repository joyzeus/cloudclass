package com.igeek.book.service.impl;

import com.igeek.book.dao.DoubanBookMapper;
import com.igeek.book.dao.DoubanBookTypeMapper;
import com.igeek.book.model.entity.DoubanBook;
import com.igeek.book.model.entity.DoubanBookType;
import com.igeek.book.repository.EsBookRepository;
import com.igeek.book.service.base.DoubanBookService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxu
 * @date 2020/04/20
 * @email 1419982188@qq.com
 */
@Service
@Transactional
public class DoubanBookServiceImpl implements DoubanBookService {

    @Autowired(required = false)
    private DoubanBookTypeMapper doubanBookTypeMapper;

    @Autowired(required = false)
    private DoubanBookMapper doubanBookMapper;

    @Autowired
    private EsBookRepository bookRepository;

    @Override
    public Integer insertOrUpdateBookType(DoubanBookType doubanBookType) {
        if (doubanBookType == null) {
            return 0;
        }
        if (StringUtils.isBlank(doubanBookType.getType())) {
            return 0;
        }

        List<DoubanBookType> doubanBookTypes = doubanBookTypeMapper.find(
                DoubanBookType.builder()
                        .type(doubanBookType.getType())
                        .build());
        int result = 0;
        if (CollectionUtils.isEmpty(doubanBookTypes)) {
            result = doubanBookTypeMapper.insertSelective(doubanBookType);
        } else {
            DoubanBookType bookType = doubanBookTypes.get(0);
            if (!bookType.equals(doubanBookType)) {
                doubanBookType.setTableId(bookType.getTableId());
                result = doubanBookTypeMapper.updateByPrimaryKeySelective(doubanBookType);
            }
        }
        return result;
    }

    @Override
    public DoubanBookType selectByTypeName(String name) {
        return doubanBookTypeMapper.selectByType(name);
    }

    @Override
    public DoubanBook queryById(Integer id) {
        return doubanBookMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertOrUpdateBook(DoubanBook doubanBook) {
        if (doubanBook == null || doubanBook.getBookId() == null) {
            return 0;
        }

        List<DoubanBook> doubanBooks = doubanBookMapper.find(DoubanBook.builder()
                .bookId(doubanBook.getBookId())
                .build());
        int result = 0;
        if (CollectionUtils.isEmpty(doubanBooks)) {
            result = doubanBookMapper.insertSelective(doubanBook);
        } else {
            DoubanBook book = doubanBooks.get(0);
            if (!book.equals(doubanBook)) {
                doubanBook.setTableId(book.getTableId());
                result = doubanBookMapper.updateByPrimaryKeySelective(doubanBook);
            }
        }

        bookRepository.save(doubanBook);

        return result;
    }

    @Override
    public Integer deleteByPrimaryKey(Integer tableId) {
        int count = doubanBookMapper.deleteByPrimaryKey(tableId);
        bookRepository.deleteById(tableId);
        return count;
    }

    @Override
    public void deleteESAll() {
        bookRepository.deleteAll();
    }

    @Override
    public Page<DoubanBook> list(String keyword, Integer pageNum, Integer pageSize, Integer sortAction) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withPageable(pageRequest);

        if (StringUtils.isBlank(keyword)) {
            nativeSearchQueryBuilder.withFilter(QueryBuilders.matchAllQuery());
        } else {
            List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("bookName", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(10)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("author", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(5)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("publishingHouse", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(3)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("translator", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(2)));
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
            filterFunctionBuilders.toArray(builders);
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2);
            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
        }

        //排序
        if (sortAction == 1) {
            //发行时间
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("publishTime").order(SortOrder.DESC));
        } else if (sortAction == 2) {
            //评分
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("score").order(SortOrder.DESC));
        } else {
            //按相关度
            nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        }

        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        return bookRepository.search(nativeSearchQuery);
    }
}
