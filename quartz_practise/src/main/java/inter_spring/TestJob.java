/**
 * 
 */
package inter_spring;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author bingqin
 * @date 2017年6月27日
 */
public class TestJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("current time is:"+new Date());
		ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");
		System.out.println("获取到的容器定义数量:"+applicationContext.getBeanDefinitionCount());
	}

}
