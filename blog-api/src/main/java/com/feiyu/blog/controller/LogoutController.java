package com.feiyu.blog.controller;

import com.feiyu.blog.service.impl.LoginServiceImpl;
import com.feiyu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logout")
public class LogoutController {

    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization") String token){
        return loginService.logout(token);
    }
}
