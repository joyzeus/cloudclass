package com.igeek.crm.dao;

import com.igeek.crm.model.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer tableId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer tableId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}