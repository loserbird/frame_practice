/**
 * 
 */
package com.topview.crawl.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


import com.topview.crawl.ICrawl;
import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class SocketCrawl implements ICrawl{

	
	@Override
	public CrawlResult crawl(UrlPojo urlPojo) {
		CrawlResult result = new CrawlResult();
		if(urlPojo == null || urlPojo.getUrl() == null){
			result.setSuccess(false);
			result.setContent(null);
			return result;
		}
		String host = urlPojo.getHost();
		if(host == null){
			result.setSuccess(false);
			result.setContent(null);
			return result;
		}
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			Socket socket = new Socket(host, 80);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("GET "+urlPojo.getUrl()+" HTTP/1.0\r\n");
			bw.write("HOST:"+host+"\r\n");
			bw.write("\r\n");
			bw.flush();
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null){
				//System.out.println(line);
				sb.append(line+"\n");
			}
			result.setSuccess(true);
			result.setContent(sb.toString());
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("关闭流失败");
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		//UrlPojo urlPojo = new UrlPojo("http://www.qq.com");
		UrlPojo urlPojo = new UrlPojo("http://www.baidu.com");
		SocketCrawl crawl = new SocketCrawl();
		CrawlResult result = crawl.crawl(urlPojo);
		System.out.println(result.getContent());
		System.out.println("done");
	}
}
