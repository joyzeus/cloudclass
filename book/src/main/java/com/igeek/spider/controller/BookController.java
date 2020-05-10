package com.igeek.spider.controller;

import com.igeek.common.util.R;
import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.service.base.DoubanBookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:23
 */
@Api(tags = {"book"})
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private DoubanBookService doubanBookService;

    @ApiOperation("查询图书信息图书")
    @GetMapping("/{id}")
    public R addBook(@ApiParam(name = "id", value = "图书tableId", required = true) @PathVariable Integer id) {
        return R.success(doubanBookService.queryById(id));
    }

    @ApiOperation("添加图书")
    @PutMapping("/")
    public R addBook(@RequestBody DoubanBook doubanBook) {
        return R.success(doubanBookService.insertOrUpdateBook(doubanBook));
    }

    @ApiOperation("修改图书")
    @PostMapping("/{id}")
    public R updateBook(@ApiParam(name = "id", value = "图书tableId", required = true) @PathVariable Integer id,
                        @RequestBody DoubanBook doubanBook) {
        doubanBook.setTableId(id);
        return R.success(doubanBookService.insertOrUpdateBook(doubanBook));
    }

    @ApiOperation("删除图书")
    @DeleteMapping("/{id}")
    public R deleteBook(@ApiParam(name = "id", value = "图书tableId", required = true) @PathVariable Integer id) {
        return R.success(doubanBookService.deleteByPrimaryKey(id));
    }

    @ApiOperation("删除elasticsearch所有图书")
    @DeleteMapping("/deleteESAll")
    public R deleteElasticSearchAllBooks() {
        doubanBookService.deleteESAll();
        return R.ok();
    }

    @GetMapping("/list")
    @ApiOperation("获取图书列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "keyword", value = "根据关键字搜索图书", required = false, defaultValue = ""),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "sortAction", value = "排序条件, 0:分数;1:publishTime; 3:score", required = false, defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "页码", required = false, defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "分页条数", required = false, defaultValue = "10"),
    })
    public R getList(@RequestParam(required = false) String keyword,
                     @RequestParam(required = false, defaultValue = "0") Integer sortAction,
                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return R.success(doubanBookService.list(keyword, pageNum, pageSize, sortAction));
    }
}
