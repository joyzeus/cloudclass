package com.jay.book.admin.module.user.service.base;

import com.jay.book.admin.module.user.entity.DoubanBook;
import com.jay.book.admin.module.user.entity.DoubanBookType;

public interface DoubanBookService {

    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);

    Integer insertOrUpdateBook(DoubanBook doubanBook);
}