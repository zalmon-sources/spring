package com.zp;

import com.zp.entity.Person;
import com.zp.pointcut.TrackClassCounter;
import com.zp.config.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by peng.zhang
 * Description:AOP获取上课次数测试
 * Time: 2019/8/20-10:25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class trackCounterTest {

    @Autowired
    private Person personStudy;

    @Autowired
    private TrackClassCounter trackClassCounter;

    /**
     * 通过AOP自动计算每个科目上课的次数
     */
    @Test
    public void trackCounter(){
        personStudy.studying("Chinese");
        personStudy.studying("Math");
        personStudy.studying("Math");
        personStudy.studying("English");
        personStudy.studying("Chinese");
        personStudy.studying("Chinese");

        System.out.println("Chinese: " + trackClassCounter.getClassCount("Chinese"));
        System.out.println("Math: " + trackClassCounter.getClassCount("Math"));
        System.out.println("English: " + trackClassCounter.getClassCount("English"));
    }
}
