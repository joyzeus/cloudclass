package com.igeek.book.service.base;

import com.igeek.book.model.entity.DoubanBook;
import com.igeek.book.model.entity.DoubanBookType;
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
     * @param doubanBookType 图书类型信息
     * @return
     */
    Integer insertOrUpdateBookType(DoubanBookType doubanBookType);


    /**
     * 根据图书类型查询
     *
     * @param typeName 图书类型名称
     * @return
     */
    DoubanBookType selectByTypeName(String typeName);

    /**
     * 根据图书id获取图书信息
     *
     * @param id 图书id
     * @return
     */
    DoubanBook queryById(Integer id);

    /**
     * 新增或者修改图书信息
     *
     * @param doubanBook 图书信息
     * @return
     */
    Integer insertOrUpdateBook(DoubanBook doubanBook);

    /**
     * 通过主键Id删除图书
     *
     * @param tableId 图书tableId
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
     * @param keyword    关键字
     * @param pageNum    查询页码
     * @param pageSize   每页显示数据量
     * @param sortAction 排序字段
     * @return
     */
    Page<DoubanBook> list(String keyword, Integer pageNum, Integer pageSize, Integer sortAction);


}