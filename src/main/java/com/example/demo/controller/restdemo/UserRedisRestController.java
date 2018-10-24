package com.example.demo.controller.restdemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest支持
 * @author Arthur
 * @date 2018-10-15
 */

@RestController
public class UserRedisRestController {
    @RequestMapping(value = "/user/{id}")
    public Integer getCreditLevel(@PathVariable Integer id) {
        //模拟用户信用等级
        if (id < 100) {
            return 1;
        } else {
            return 2;
        }
    }
}
