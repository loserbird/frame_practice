/**
 * 
 */
package inter_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bingqin
 * @date 2017年6月27日
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("inter_spring/applicationContext.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("inter_spring/applicationContext2.xml");
	}
}
