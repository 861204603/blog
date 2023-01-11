package com.feiyu.blog.service;

import com.feiyu.blog.dao.pojo.SysUser;
import com.feiyu.blog.vo.Result;
import com.feiyu.blog.vo.params.LoginParams;

public interface LoginService {

    /**
     * 登录功能
     * @param loginParams
     * @return
     */
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);

    /**
     * 注册功能
     * @param loginParams
     * @return
     */
    Result register(LoginParams loginParams);
}
