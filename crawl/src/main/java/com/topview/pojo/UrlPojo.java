/**
 * 
 */
package com.topview.pojo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.topview.common.constants.TaskLevel;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class UrlPojo {
	public String url;
	private Map<String, Object> parasMap;
	public TaskLevel taskLevel = TaskLevel.MIDDLE;
	
	public UrlPojo(String url) {
		super();
		this.url = url;
	}
	public UrlPojo(String url, TaskLevel taskLevel) {
		super();
		this.url = url;
		this.taskLevel = taskLevel;
	}
	
	public UrlPojo(String url, Map<String, Object> parasMap) {
		super();
		this.url = url;
		this.parasMap = parasMap;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Map<String, Object> getParasMap() {
		return parasMap;
	}
	public void setParasMap(Map<String, Object> parasMap) {
		this.parasMap = parasMap;
	}
	public TaskLevel getTaskLevel() {
		return taskLevel;
	}
	public void setTaskLevel(TaskLevel taskLevel) {
		this.taskLevel = taskLevel;
	}
	
	public HttpURLConnection getConnection(){
		URL url = null;
		try {
			url = new URL(this.url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			return httpURLConnection;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return null;
	}
	
	public String getHost(){
		URL url = null;
		try {
			url = new URL(this.url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.getHost();
	}
	@Override
	public String toString() {
		return "UrlPojo [url=" + url + ", taskLevel=" + taskLevel + "]";
	}
	
	
}
