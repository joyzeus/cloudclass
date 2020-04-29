package com.igeek.spider.service.base;

import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.model.entity.DoubanBookType;
import org.springframework.data.domain.Page;

/**
 * @author zhouxu
 * @date 2020/04/27
 * @email 1419982188@qq.com
 */
public interface DoubanBookService {

    /**
     * 新增或者修改图书类型
     *
     * @param doubanBookType
     * @return
     */
    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);


    /**
     * 根据图书类型查询
     *
     * @param typeName
     * @return
     */
    DoubanBookType selectByTypeName(String typeName);

    /**
     * 新增或者修改图书信息
     *
     * @param doubanBook
     * @return
     */
    Integer insertOrUpdateBook(DoubanBook doubanBook);

    /**
     * 通过主键Id删除图书
     *
     * @param tableId
     * @return
     */
    Integer deleteByPrimaryKey(Integer tableId);


    /**
     * 删除es全部数据
     *
     * @return
     */
    void deleteESAll();

    /**
     * 查询图书
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @param sortAction
     * @return
     */
    Page<DoubanBook> list(String keyword, Integer pageNum, Integer pageSize, Integer sortAction);
}