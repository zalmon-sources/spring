package com.springmvc.controller;

import com.zp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2019/8/26-16:21.
 */
@Controller
public class HomeController {

    @Autowired
    Student student;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        System.out.println(student);
        return "home";
    }
}
