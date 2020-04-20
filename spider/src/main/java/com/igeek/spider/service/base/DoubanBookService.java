package com.igeek.spider.service.base;

import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.model.entity.DoubanBookType;
import org.springframework.data.domain.Page;

public interface DoubanBookService {

    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);

    Integer insertOrUpdateBook(DoubanBook doubanBook);

    DoubanBookType selectByName(String name);

    Page<DoubanBook> list(Integer pageNum, Integer pageSize);
}