/**
 * 
 */
package hello2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author bingqin
 * @date 2017年6月23日
 */
public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException{
		//打印当前时间
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current  time is:"+sFormat.format(date));
		
		
		
		
		//创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob","group1")
				.build();
		//距离当前时间3秒
		date.setTime(date.getTime()+3000);
		Date enDate = new Date();
		enDate.setTime(enDate.getTime()+6000);
		//创建一个Trigger实例，定义该job立即执行，并且每隔两秒重复执行一次
		/*Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger","group1")
				.startAt(date)
				.endAt(enDate)
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();*/
		
		
		SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
				.withIdentity("myTrigger","group1")
				.startAt(enDate)
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3))
				.build();
		
		//创建Scheduler实例，通过factory模式创建
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
	
		
		scheduler.scheduleJob(jobDetail, trigger);
		
	}
}
