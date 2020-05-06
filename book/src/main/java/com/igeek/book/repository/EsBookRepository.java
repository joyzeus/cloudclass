package com.igeek.book.repository;

import com.igeek.book.model.entity.DoubanBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:57
 */
public interface EsBookRepository extends ElasticsearchRepository<DoubanBook, Integer> {
}
