package com.igeek.crm.service.impl;

import com.igeek.crm.dao.ClassesMapper;
import com.igeek.crm.model.entity.Classes;
import com.igeek.crm.service.base.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/22 15:41
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public Classes queryByPrimaryKey(Integer primaryKey) {
        return classesMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public List<Classes> queryByParentId(Integer parentId) {
        return classesMapper.selectByParentId(parentId);
    }

    @Override
    public Integer saveClasses(Classes classes) {
        Integer tableId = classes.getTableId();
        if (tableId == null) {
            return classesMapper.updateByPrimaryKeySelective(classes);
        } else {
            return classesMapper.insertSelective(classes);
        }
    }
}
