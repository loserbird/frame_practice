/**
 * 
 */
package com.topview.model;

import java.sql.Date;

/**
 * @author bingqin
 * @date 2017年6月2日
 */
public class Role {
	private Integer id;
	private String roleName;
	private Date createDate;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Role(){}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", createDate=" + createDate + ", note=" + note + "]";
	}
	
	
}
