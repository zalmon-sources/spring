package com.zp.quartz.example1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.DateFormat;
import java.util.Date;

public class MyJob implements Job {

    public MyJob(){}

    public void execute(JobExecutionContext jobExecutionContext) {

        System.out.println("Hello World! - " + DateFormat.getDateTimeInstance().format(new Date()));
    }
}
