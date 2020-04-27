package com.igeek.crm.service.base;

import com.igeek.crm.model.entity.Classes;

import java.util.List;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/22 15:41
 */
public interface ClassesService {

    /**
     * 根据主键查询信息
     *
     * @param primaryKey 主键Id
     * @return 年级信息
     */
    Classes queryByPrimaryKey(Integer primaryKey);

    /**
     * 根据主键Id查询年纪信息
     *
     * @param parentId 父级Id
     * @return 年级信息
     */
    List<Classes> queryByParentId(Integer parentId);

    /**
     * 修改或者新增年级信息
     *
     * @param classes 年级信息
     * @return
     */
    Integer saveClasses(Classes classes);
}
