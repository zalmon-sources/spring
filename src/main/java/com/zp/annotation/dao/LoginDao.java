package com.zp.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by peng.zhang
 * Time: 2018/7/5-16:22.
 */
@Repository
public class LoginDao {

    public void save(){
        System.out.println("dao save...");
    }
}
