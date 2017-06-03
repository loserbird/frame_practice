/**
 * 
 */
package com.topview.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topview.dao.UserDao;
import com.topview.model.User;

/**
 * @author bingqin
 * @date 2017年5月20日
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUser(User User) {
		return userDao.insertUser(User);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateUser(User User) {
		return userDao.updateUser(User);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}


	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> findUsers(String userName, int start, int limit) {
		return userDao.findUsers(userName, new RowBounds(start,limit));
	}
	
	
}
