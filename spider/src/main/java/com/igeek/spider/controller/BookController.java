package com.igeek.spider.controller;

import com.igeek.common.util.R;
import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.service.base.DoubanBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/20 10:23
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private DoubanBookService doubanBookService;

    @GetMapping("/test")
    public R test() {
        return R.ok();
    }

    @PostMapping("/add")
    public R addBook(@RequestBody DoubanBook doubanBook) {
        return R.success(doubanBookService.insertOrUpdateBook(doubanBook));
    }

    @PostMapping("/update")
    public R updateBook(@RequestBody DoubanBook doubanBook) {
        return R.success(doubanBookService.insertOrUpdateBook(doubanBook));
    }

    @DeleteMapping("/delete")
    public R addBook(@RequestParam Integer id) {
        return R.success(doubanBookService.deleteByPrimaryKey(id));
    }

    @DeleteMapping("/deleteESAll")
    public R addBook() {
        doubanBookService.deleteESAll();
        return R.ok();
    }

    @GetMapping("/list")
    public R getList(@RequestParam(required = false) String keyword,
                     @RequestParam(required = false, defaultValue = "0") Integer sortAction,
                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return R.success(doubanBookService.list(keyword, pageNum, pageSize, sortAction));
    }
}
