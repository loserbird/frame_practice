/**
 * 
 */
package listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author bingqin
 * @date 2017年6月24日
 */
public class MyJob implements Job{
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		 
				System.out.println("Hello Quartz! - by yiibai.com");	
		 
				//Throw exception for testing
				throw new JobExecutionException("Testing Exception");
			}
}
