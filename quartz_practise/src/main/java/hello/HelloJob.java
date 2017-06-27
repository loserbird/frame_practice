/**
 * 
 */
package hello;

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
		//System.out.println("helloworld");
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("my job name and group are:"+jobKey.getName()+":"+jobKey.getGroup());
		
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println("my trigger name and group are:"+triggerKey.getName()+":"+triggerKey.getGroup());
		
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		JobDataMap tDataMap = context.getTrigger().getJobDataMap();
		
		String jobMsg = jobDataMap.getString("message");
		Float jobFloatValue = jobDataMap.getFloat("floatjobvalue");
		
		String triggerMsg = tDataMap.getString("message");
		Double triggerDoubleValue = tDataMap.getDouble("doubletriggervalue");
		
		System.out.println(jobMsg);
		System.out.println(jobFloatValue);
		System.out.println(triggerMsg);
		System.out.println(triggerDoubleValue);
		
		//取得合并后的dataMap,但是如果jobdetail和trigger里的key有相同的key，trigger的会覆盖jobdetail的。
		JobDataMap mergeDataMap = context.getMergedJobDataMap();
	
}
}
