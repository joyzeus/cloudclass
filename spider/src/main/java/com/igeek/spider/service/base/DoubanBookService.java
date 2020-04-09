package com.igeek.spider.service.base;

import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.model.entity.DoubanBookType;

public interface DoubanBookService {

    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);

    Integer insertOrUpdateBook(DoubanBook doubanBook);
}