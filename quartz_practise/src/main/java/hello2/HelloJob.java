/**
 * 
 */
package hello2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/**
 * @author bingqin
 * @date 2017年6月23日
 */
public class HelloJob implements Job{
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current exec time is:"+sFormat.format(date));
		System.out.println("helloworld");
		/*Trigger currentTrigger = context.getTrigger();
		System.out.println("trigger start time is:"+currentTrigger.getStartTime());
		System.out.println("trigger end time is:"+currentTrigger.getEndTime());
		JobKey jobKey = currentTrigger.getJobKey();
		System.out.println("jobkey name---"+jobKey.getName()+" jobkey group:"+jobKey.getGroup());*/
}
}
