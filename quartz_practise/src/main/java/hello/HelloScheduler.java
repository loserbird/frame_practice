/**
 * 
 */
package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author bingqin
 * @date 2017年6月23日
 */
public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException{
		//创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("myjob","group1")
				.usingJobData("message", "hello myjob1")
				.usingJobData("floatjobvalue",3.14F).build();
		
		//创建一个Trigger实例，定义该job立即执行，并且每隔两秒重复执行一次
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger","group1")
				.usingJobData("message","hello mytrigger1")
				.usingJobData("doubletriggervalue",2.0D)
				.startNow()
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
				.build();
		
		//创建Scheduler实例，通过factory模式创建
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		//打印当前时间
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current  time is:"+sFormat.format(date));
		
		
		scheduler.scheduleJob(jobDetail, trigger);
		
	}
}
