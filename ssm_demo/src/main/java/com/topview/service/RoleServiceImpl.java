package com.topview.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topview.dao.RoleDao;
import com.topview.model.Role;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;
	@Override
	public int insertRole(Role role) {
		return roleDao.insertRole(role);
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.updateRole(role);
	}

	@Override
	public int deleteRole(Integer id) {
		return roleDao.deleteRole(id);
	}

	@Override
	public Role getRole(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.getRole(id);
	}

	@Override
	public List<Role> findRoles(String roleName, int start, int limit) {
		// TODO Auto-generated method stub
		return roleDao.findRoles(roleName, new RowBounds(start,limit));
	}

}
