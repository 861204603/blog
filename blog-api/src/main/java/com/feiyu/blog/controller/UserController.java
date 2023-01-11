package com.feiyu.blog.controller;

import com.feiyu.blog.service.SysUserService;
import com.feiyu.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        log.info("收到请求：/users/currentUser");
        return sysUserService.findUserByToken(token);
    }
}
