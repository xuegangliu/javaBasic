package org.lxg.basic.quartz;

import org.quartz.*;


//@DisallowConcurrentExecution //Quartz不要并发地执行同一个job定义（这里指特定的job类）的多个实例
//@PersistJobDataAfterExecution //将该注解加在job类上，告诉Quartz在成功执行了job类的execute方法后（没有发生任何异常），
// 更新JobDetail中JobDataMap的数据，使得该job（即JobDetail）在下一次执行的时候，JobDataMap中是更新后的数据，而不是更新前的旧数据。
/**
 * @author xuegangliu
 * @date: 8/22/2018 5:04 PM
 * @DES:
 * @version: v1.0
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.isRecovering());
        System.out.println("This is HelloJob.....");
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }
}
