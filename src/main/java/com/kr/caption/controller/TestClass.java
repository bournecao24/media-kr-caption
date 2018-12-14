package com.kr.caption.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestClass {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        System.out.println("hello word hello world");
        return "success";
    }
}
