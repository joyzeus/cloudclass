package com.igeek.cloudclass.task.dao;

import com.igeek.cloudclass.task.model.entity.ShadowskyAccount;

import java.util.List;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
public interface ShadowskyAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShadowskyAccount record);

    int insertSelective(ShadowskyAccount record);

    ShadowskyAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShadowskyAccount record);

    int updateByPrimaryKey(ShadowskyAccount record);

    List<ShadowskyAccount> selectList(ShadowskyAccount record);
}