package com.igeek.spider.repository;

import com.igeek.spider.model.entity.DoubanBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:57
 */
public interface EsBookRepository extends ElasticsearchRepository<DoubanBook, Integer> {
}
