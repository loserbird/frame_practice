/**
 * 
 */
package com.topview.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.topview.model.User;

/**
 * @author bingqin
 * @date 2017年5月20日
 */
@Repository
public interface UserDao{
	public int insertUser(User User);
	
	public int updateUser(User User);
	
	public int deleteUser(Integer id);
	
	public User getUser(Integer id);
	
	public List<User> findUsers(String userName,RowBounds rowBounds); 
}
