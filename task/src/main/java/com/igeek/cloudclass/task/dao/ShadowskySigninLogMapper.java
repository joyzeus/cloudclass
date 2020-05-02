package com.igeek.cloudclass.task.dao;

import com.igeek.cloudclass.task.model.entity.ShadowskySigninLog;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
public interface ShadowskySigninLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShadowskySigninLog record);

    int insertSelective(ShadowskySigninLog record);

    ShadowskySigninLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShadowskySigninLog record);

    int updateByPrimaryKey(ShadowskySigninLog record);
}