package com.soft1851.springboot.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke
 * @ClassName UserController
 * @Description TOOD
 * @Date 2020/9/23
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @GetMapping(value = "/hello")
    public String getHello() {
        log.info("我被调用");
        return "Hello, this is user-center";
    }
}
