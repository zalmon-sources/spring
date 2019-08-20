package com.zp.pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by peng.zhang
 * Description: 环绕通知demo，在TrackCounterTest中使用
 * Time: 2019/8/20-11:09.
 */
@Aspect
public class StudyAround {

    @Pointcut("execution(* com.zp.entity.Person.studying(String))")
    private void studying(){}

    @Around("studying()")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("(around)before study...");
            joinPoint.proceed();
            System.out.println("(around)after study...");
        } catch (Throwable throwable) {
            System.out.println("(around)study error...");
        }
    }
}
