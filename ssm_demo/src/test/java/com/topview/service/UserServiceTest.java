/**
 * 
 */
package com.topview.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topview.model.User;

/**
 * @author bingqin
 * @date 2017年5月20日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
	@Autowired
	public UserServiceImpl userServiceImpl;
	
	@Test
	public void testInsert(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("3231@qq.com");
		user.setMobile("13435647654");
		user.setSex("男");
		user.setNote("suia");
		user.setUserName("haha");
		userServiceImpl.insertUser(user);
	}
	@Test
	public void testQueryOne(){
		User user = userServiceImpl.getUser(1);
		System.out.println(user);
	}
}
