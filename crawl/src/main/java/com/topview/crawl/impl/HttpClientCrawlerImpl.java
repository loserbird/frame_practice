package com.topview.crawl.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.topview.crawl.ICrawl;
import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

public class HttpClientCrawlerImpl implements ICrawl{
	public CloseableHttpClient httpclient = HttpClients.custom().build();

	@Override
	public CrawlResult crawl(UrlPojo urlPojo) {
		if (urlPojo == null) {
			return null;
		}
		CrawlResult crawlResult = new CrawlResult();
		CloseableHttpResponse response = null;
		BufferedReader br = null;
		try{
			HttpGet httpGet = new HttpGet(urlPojo.getUrl());
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStreamReader isr = new InputStreamReader(entity.getContent());
			br = new BufferedReader(isr);
			String line = null;
			StringBuilder sBuilder = new StringBuilder();
			while((line = br.readLine())!=null){
				sBuilder.append(line+"\n");
			}
			crawlResult.setSuccess(true);
			crawlResult.setContent(sBuilder.toString());
		}catch(Exception e){
			e.printStackTrace();
			crawlResult.setSuccess(false);
		}finally{
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return crawlResult;
		
	}
	/*
	 * 有参数的post请求
	 */
	public CrawlResult crawlpost(UrlPojo urlPojo) {
		if (urlPojo == null) {
			return null;
		}
		CrawlResult crawlResult = new CrawlResult();
		CloseableHttpResponse response = null;
		BufferedReader br = null;
		try{
			RequestBuilder requestBuilder = RequestBuilder.post().setUri(urlPojo.getUrl());
			Map<String, Object> parasMap = urlPojo.getParasMap();
			if (parasMap != null) {
				for (Entry<String, Object> entry : parasMap.entrySet()) {
					requestBuilder.addParameter(entry.getKey(), entry.getValue()
									.toString());
				}
			}
			HttpUriRequest httpUriRequest = requestBuilder.build();
			response = httpclient.execute(httpUriRequest);
			HttpEntity entity = response.getEntity();
			InputStreamReader isr = new InputStreamReader(entity.getContent(),"utf-8");
			br = new BufferedReader(isr);
			String line = null;
			StringBuilder sBuilder = new StringBuilder();
			while((line = br.readLine())!=null){
				sBuilder.append(line+"\n");
			}
			crawlResult.setSuccess(true);
			crawlResult.setContent(sBuilder.toString());
		}catch(Exception e){
			e.printStackTrace();
			crawlResult.setSuccess(false);
		}finally{
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return crawlResult;
	}
	public static void main(String[] args) {
		HttpClientCrawlerImpl httpClientCrawlerImpl = new HttpClientCrawlerImpl();
		String url = "http://www.wangdaizhijia.com/front_select-plat";
		UrlPojo urlPojo = new UrlPojo(url);
		CrawlResult resultPojo = httpClientCrawlerImpl.crawl(urlPojo);

		if (resultPojo != null) {
			System.out.println(resultPojo.getContent());
		}
	}
}
