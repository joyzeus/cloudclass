package com.igeek.crm.controller;

import com.igeek.common.util.R;
import com.igeek.crm.model.entity.Classes;
import com.igeek.crm.service.base.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/22 14:53
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public R list(@RequestParam(required = false, defaultValue = "0") Integer parentId) {
//        return R.success();
        Classes classes = classesService.queryByPrimaryKey(parentId);
        List<Classes> classesList = classesService.queryByParentId(parentId);
        return R.ok().put("classes", classes).put("childList", classesList);
    }

    @PostMapping("/save")
    public R saveClasses(@RequestBody Classes classes) {
        Integer integer = classesService.saveClasses(classes);
        return integer == 1 ? R.ok() : R.error("添加或者修改失败");
    }
}
