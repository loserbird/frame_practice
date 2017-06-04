/**
 * 
 */
package com.topview.crawl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.topview.crawl.ICrawl;
import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class HttpUrlConnectionCrawl implements ICrawl{

	@Override
	public CrawlResult crawl(UrlPojo urlPojo) {
		CrawlResult result = new CrawlResult();
		if(urlPojo == null || urlPojo.getUrl() == null){
			result.setSuccess(false);
			result.setContent(null);
			return result;
		}
		HttpURLConnection connection = urlPojo.getConnection();
		if(connection == null){
			result.setSuccess(false);
			result.setContent(null);
			return result;
		}
		
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			 	StringBuilder sb = new StringBuilder();
				String line = null;
				while((line = br.readLine()) != null){
					//System.out.println(line);
					sb.append(line+"\n");
				}
				result.setSuccess(true);
				result.setContent(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		//UrlPojo urlPojo = new UrlPojo("http://www.qq.com");
		UrlPojo urlPojo = new UrlPojo("http://www.baidu.com");
		HttpUrlConnectionCrawl crawl = new HttpUrlConnectionCrawl();
		CrawlResult result = crawl.crawl(urlPojo);
		System.out.println(result.getContent());
		System.out.println("done");
	}
}
