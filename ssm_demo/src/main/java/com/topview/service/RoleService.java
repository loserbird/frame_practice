/**
 * 
 */
package com.topview.service;

import java.util.List;


import com.topview.model.Role;

/**
 * @author bingqin
 * @date 2017年6月3日
 */
public interface RoleService {
public int insertRole(Role role);
	
	public int updateRole(Role role);
	
	public int deleteRole(Integer id);
	
	public Role getRole(Integer id);
	
	public List<Role> findRoles(String roleName,int start,int limit); 
}
