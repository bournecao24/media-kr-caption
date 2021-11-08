package com.kr.caption.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestClass {

    @RequestMapping("test")
    @ResponseBody
    public String test(){

        log.info("测试线程id走起");
        System.out.println("hello word hello world");
        return "success";
    }
}
