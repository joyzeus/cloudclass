package com.igeek.spider.service.impl;

import com.igeek.spider.dao.DoubanBookMapper;
import com.igeek.spider.dao.DoubanBookTypeMapper;
import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.model.entity.DoubanBookType;
import com.igeek.spider.repository.EsBookRepository;
import com.igeek.spider.service.base.DoubanBookService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Integer insertOrUpdateBook(DoubanBook doubanBook) {
        if (doubanBook == null || doubanBook.getBookId() == null) {
            return 0;
        }

        DoubanBook book = doubanBookMapper.find(DoubanBook.builder()
                .bookId(doubanBook.getBookId())
                .build());
        int result = 0;
        if (book == null) {
            result = doubanBookMapper.insertSelective(doubanBook);
        } else {
            if (!book.equals(doubanBook)) {
                doubanBook.setTableId(book.getTableId());
                result = doubanBookMapper.updateByPrimaryKeySelective(doubanBook);
            }
        }
        return result;
    }

    @Override
    public DoubanBookType selectByName(String name) {
        return doubanBookTypeMapper.selectByType(name);
    }

    @Override
    public Page<DoubanBook> list(Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withPageable(pageRequest);
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        return bookRepository.search(nativeSearchQuery);
    }
}
