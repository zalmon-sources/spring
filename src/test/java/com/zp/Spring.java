package com.zp;

import com.zp.entity.Person;
import com.zp.entity.StudentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2019/8/12-15:39.
 */
// 测试开始时自动创建spring应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
/*
    加载 StudentConfig中的配置,改用locations = {"classpath*:/*.xml"} 加载xml
        classpath ：只会到你的class路径中查找找文件。
        classpath*：不仅包含class路径，还包括jar文件中（class路径）进行查找
 */
@ContextConfiguration(classes = StudentConfig.class)
public class Spring {

    @Autowired
    private Person person;

    @Test
    public void personShouldNotBeNull(){
        assertNotNull(person);
        System.out.println(person);
        person.print();
        System.out.println(person.getStudent().getNumber());
    }

}
