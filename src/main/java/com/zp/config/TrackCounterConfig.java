package com.zp.config;

import com.zp.entity.Person;
import com.zp.pointcut.StudyAround;
import com.zp.pointcut.TrackClassCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by peng.zhang
 * Description:
 * Time: 2019/8/19-15:43.
 */
@Configuration
@EnableAspectJAutoProxy // 启动AspectJ自动代理
public class TrackCounterConfig {

    @Bean
    public Person personStudy(){
        return new Person("duqing","female",21);
    }

    @Bean
    public TrackClassCounter trackClassCounter(){
        return new TrackClassCounter();
    }

    @Bean
    public StudyAround studyAround() {
        return new StudyAround();
    }
}
