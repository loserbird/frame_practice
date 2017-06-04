/**
 * 
 */
package com.topview.pojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class CrawlResult {
	public boolean success;
	
	public String content;
	
	public int responseStatus;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
}
