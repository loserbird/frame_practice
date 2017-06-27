/**
 * 
 */
package listener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * @author bingqin
 * @date 2017年6月24日
 */
public class ListenerTest {
	 public static void main( String[] args ) throws Exception
	    {
	 
		JobKey jobKey = new JobKey("dummyJobName", "group1");
	    	JobDetail job = JobBuilder.newJob(MyJob.class)
			.withIdentity(jobKey).build();
	 
	    	Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("dummyTriggerName", "group1")
			.withSchedule(
				CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
			.build();
	 
	    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	 
	    	//Listener attached to jobKey
	    	scheduler.getListenerManager().addJobListener(
	    		new MyJobListener(), KeyMatcher.keyEquals(jobKey)
	    	);
	 
	    	//Listener attached to group named "group 1" only.
	    	//scheduler.getListenerManager().addJobListener(
	    	//	new HelloJobListener(), GroupMatcher.jobGroupEquals("group1")
	    	//);
	 
	    	scheduler.start();
	    	scheduler.scheduleJob(job, trigger);
	 
	    }
}
