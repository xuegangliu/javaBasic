package org.lxg.basic.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @author: xuegangliu
 * @date: 8/22/2018 6:15 PM
 * @DES:
 * @version: v1.0
 */
public class BasicTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        System.out.println("getName");
        return "BasicTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("triggerFired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("vetoJobExecution");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        System.out.println("triggerComplete");
    }
}
