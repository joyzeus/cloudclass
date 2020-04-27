package com.igeek.crm.dao;

import com.igeek.crm.model.entity.Classes;

import java.util.List;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> selectByParentId(Integer parentId);
}