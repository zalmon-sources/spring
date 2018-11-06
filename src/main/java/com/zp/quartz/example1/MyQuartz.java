package com.zp.quartz.example1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class MyQuartz {

    public static void main(String[] args) throws SchedulerException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();

        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow().build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        try {
            // wait 65 seconds to show job
            Thread.sleep(5L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        scheduler.shutdown(true);

    }
}
