package com.igeek.book.controller;

import com.igeek.common.util.R;
import com.igeek.book.dao.DoubanBookMapper;
import com.igeek.book.dao.RedisDao;
import com.igeek.book.model.entity.DoubanBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/30 10:16
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private DoubanBookMapper doubanBookMapper;

    @GetMapping("/set")
    public R setValue(@RequestParam(required = true, name = "key") String key,
                      @RequestParam(required = true, name = "value") String value) {
        return R.success(redisDao.set(key, value));
    }

    @GetMapping("/get")
    public R getValue(@RequestParam(required = true, name = "key") String key) {
        return R.success(redisDao.get(key));
    }

    @GetMapping("/syncBooks")
    public R syncBooks() {
        List<DoubanBook> doubanBooks = doubanBookMapper.find(null);
        doubanBooks.forEach(d -> {
            redisDao.addZSet("sys:books:rank", d.getTableId(), d.getScore().doubleValue());
        });
        return R.ok();
    }

    @GetMapping("/booksRank")
    public R syncBooksRank() {
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet = redisDao.reverseRangeWithScores("sys:books:rank", 0, 9);
        return R.success(typedTupleSet);
    }

    @GetMapping("/pubMessage")
    public R pubMessage() {
        List<DoubanBook> doubanBooks = doubanBookMapper.find(null);
        doubanBooks.forEach(d -> {
            redisDao.rightPush("sys:books:list", d);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return R.ok();
    }

    @GetMapping("/subMessage")
    public void subMessage() {
        while (true) {
            Object o = redisDao.leftPop("sys:books:list");
            if (o == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                log.error(o.toString());
            }
        }
//        return R.ok();
    }

    @GetMapping("/subBLPopMessage")
    public void subBlpopMessage() {
        while (true) {
            Object o = redisDao.bLeftPop("sys:books:list");
            log.error(o.toString());
        }
    }
}
