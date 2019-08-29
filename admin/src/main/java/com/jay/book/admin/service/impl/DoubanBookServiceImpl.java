package com.jay.book.admin.service.impl;

import com.jay.book.admin.service.base.DoubanBookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoubanBookServiceImpl implements DoubanBookService {

    private final DoubanBookTypeMapper doubanBookTypeMapper;

    private final DoubanBookMapper doubanBookMapper;

    @Autowired(required = false)
    public DoubanBookServiceImpl(DoubanBookTypeMapper doubanBookTypeMapper, DoubanBookMapper doubanBookMapper) {
        this.doubanBookTypeMapper = doubanBookTypeMapper;
        this.doubanBookMapper = doubanBookMapper;
    }

    @Override
    public Integer insertOrUpdateBookType(DoubanBookType doubanBookType) {
        if (doubanBookType == null) {
            return 0;
        }
        if (StringUtils.isBlank(doubanBookType.getType())) {
            return 0;
        }
        DoubanBookType select = doubanBookTypeMapper.find(DoubanBookType.Builder.aDoubanBookType()
                .withType(doubanBookType.getType())
                .build());
        int result = 0;
        if (select == null) {
            result = doubanBookTypeMapper.insertSelective(doubanBookType);
        } else {
            if (!select.equals(doubanBookType)) {
                doubanBookType.setTableId(select.getTableId());
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

        DoubanBook book = doubanBookMapper.find(DoubanBook.Builder.aDoubanBook()
                .withBookId(doubanBook.getBookId())
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
}
