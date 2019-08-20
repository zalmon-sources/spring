package com.zp.pointcut;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng.zhang
 * Description: 跟踪计算上课次数
 * Time: 2019/8/19-14:31.
 */
@Aspect
public class TrackClassCounter {

    private Map<String, Integer> trackMap = new HashMap<>();

    /**
     * 定义提取公共切点 args：方法中的参数名称
     * 切点定义中的参数与切点方法中的参数名称是一样的，这样就完成了从命名切点到通知方法的参数转移。
     * @param className 切点中的参数
     */
    @Pointcut("execution(* com.zp.entity.Person.studying(String)) && args(className)")
    public void trackClass(String className) {
    }

    /**
     * 后置通知 每次执行方法后统计次数
     * @param className 切点中的参数
     */
    @AfterReturning(value = "trackClass(className)", argNames = "className")
    public void trackCounter(String className) {
        int currentCount = getClassCount(className);
        trackMap.put(className, currentCount + 1);
    }

    /**
     * 在统计map中获取现有的上课次数
     * @param className 课程名称
     * @return 上课次数
     */
    public Integer getClassCount(String className) {
        return trackMap.containsKey(className) ? trackMap.get(className) : 0;
    }
}
