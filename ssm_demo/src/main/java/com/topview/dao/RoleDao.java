/**
 * 
 */
package com.topview.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.topview.model.Role;

/**
 * @author bingqin
 * @date 2017年6月2日
 */
@Repository
public interface RoleDao {
	public int insertRole(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Integer id);
	
	public Role getRole(Integer id);
	
	public List<Role> findRoles(String roleName,RowBounds rowBounds); 
}
