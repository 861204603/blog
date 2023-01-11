package com.feiyu.blog.controller;

import com.feiyu.blog.service.LoginService;
import com.feiyu.blog.vo.Result;
import com.feiyu.blog.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {


    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams){
        //都发生了快放假了
        return loginService.register(loginParams);
    }
}
