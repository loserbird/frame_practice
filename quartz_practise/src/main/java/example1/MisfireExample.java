/**
 * 
 */
package example1;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bingqin
 * @date 2017年6月27日
 */
public class MisfireExample {
	 public void run() throws Exception {
		    Logger log = LoggerFactory.getLogger(MisfireExample.class);


		    SchedulerFactory sf = new StdSchedulerFactory();
		    Scheduler sched = sf.getScheduler();




		    Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

		    // statefulJob1 will run every three seconds
		    // (but it will delay for ten seconds)
		    JobDetail job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("statefulJob1", "group1")
		        .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		    SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(startTime)
		        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();

		    Date ft = sched.scheduleJob(job, trigger);
		    log.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
		             + trigger.getRepeatInterval() / 1000 + " seconds");

		    // statefulJob2 will run every three seconds
		    // (but it will delay for ten seconds - and therefore purposely misfire after a few iterations)
		    job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("statefulJob2", "group1")
		        .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		    trigger = TriggerBuilder.newTrigger()
		        .withIdentity("trigger2", "group1")
		        .startAt(startTime)
		        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()
		                          .withMisfireHandlingInstructionNowWithExistingCount()) // set misfire instructions
		        .build();

		    ft = sched.scheduleJob(job, trigger);
		    log.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
		             + trigger.getRepeatInterval() / 1000 + " seconds");

		    log.info("------- Starting Scheduler ----------------");

		    // jobs don't start firing until start() has been called...
		    sched.start();

		    log.info("------- Started Scheduler -----------------");

		    try {
		      // sleep for ten minutes for triggers to file....
		      Thread.sleep(600L * 1000L);
		    } catch (Exception e) {
		      //
		    }

		    log.info("------- Shutting Down ---------------------");

		    sched.shutdown(true);

		    log.info("------- Shutdown Complete -----------------");

		    SchedulerMetaData metaData = sched.getMetaData();
		    log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
		  }

		  public static void main(String[] args) throws Exception {

		    MisfireExample example = new MisfireExample();
		    example.run();
		  }
}
