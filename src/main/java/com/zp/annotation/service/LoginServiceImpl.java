package com.zp.annotation.service;

import com.zp.annotation.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-16:22.
 */
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginDao loginDao;

    public void save(){
        System.out.println("service save...");
        loginDao.save();
    }
}
