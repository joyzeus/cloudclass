package com.jay.book.service.base;

import com.jay.book.admin.module.book.entity.DoubanBook;
import com.jay.book.admin.module.book.entity.DoubanBookType;

public interface DoubanBookService {

    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);

    Integer insertOrUpdateBook(DoubanBook doubanBook);
}