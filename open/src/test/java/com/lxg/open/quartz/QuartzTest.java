package com.lxg.open.quartz;

import com.lxg.open.quartz.listeners.BasicJobListener;
import com.lxg.open.quartz.listeners.BasicTriggerListener;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;

/**
 * @author xuegangliu
 *  8/22/2018 5:03 PM
 *
 * @version: v1.0
 */
public class QuartzTest {

//    @Test
    public void helloJobTest() throws SchedulerException, InterruptedException {
        HolidayCalendar cal = new HolidayCalendar();
        cal.addExcludedDate( new Date(2018,8,25) );

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();


        // define the job and tie it to our HelloJob class
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .modifiedByCalendar("myHolidays") // but not on holidays
                .build();

        SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .startAt(new Date())        // 指定时间开始触发
//                .startAt(futureDate(5, DateBuilder.IntervalUnit.MINUTE)) // 5分钟以后开始触发，仅执行一次
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(10)   // 每隔10秒执行一次，重复10次
                        .withMisfireHandlingInstructionNextWithExistingCount()) // 智能策略
//                .endAt(dateOf(22, 0, 0))// 到22:00结束
//                .forJob("job1", "group1")                 // identify job with name, group strings
                .build();

        Trigger trigger3 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(cronSchedule("0/5 * * * * ?")
                        .withMisfireHandlingInstructionFireAndProceed()) // 智能策略
//                .forJob(job)
                .build();

        // Tell quartz to schedule the job using our trigger
//        scheduler.scheduleJob(job, trigger);
//        scheduler.scheduleJob(job, simpleTrigger);
        scheduler.scheduleJob(job, trigger3);
        // Calendar用于从trigger的调度计划中排除时间段
        scheduler.addCalendar("myHolidays", cal, false,false);

        Thread.sleep(60000);
        scheduler.shutdown();
    }

//    @Test
    public void listenerTest() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();
        Trigger trigger3 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(cronSchedule("0/5 * * * * ?")
                        .withMisfireHandlingInstructionFireAndProceed()) // 智能策略
//                .forJob(job)
                .build();
        scheduler.scheduleJob(job, trigger3);
        BasicJobListener basicJobListener = new BasicJobListener();
        BasicTriggerListener basicTriggerListener = new BasicTriggerListener();
        scheduler.getListenerManager().addJobListener( basicJobListener, jobGroupEquals("group1"));
        scheduler.getListenerManager().addTriggerListener(basicTriggerListener);
        Thread.sleep(60000);
        scheduler.shutdown();
    }
}
