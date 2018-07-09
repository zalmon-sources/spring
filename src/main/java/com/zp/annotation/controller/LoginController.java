package com.zp.annotation.controller;

import com.zp.annotation.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-16:21.
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    public void save(){
        System.out.println("controller save...");
        loginService.save();
    }

}
