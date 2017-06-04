/**
 * 
 */
package com.topview.controller;

import java.util.ArrayList;
import java.util.List;

import com.topview.manager.CrawlManager;
import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class CrawlController {
	public static void main(String[] args) {
		List<UrlPojo> urlPojoList=new ArrayList<UrlPojo>();
		
		UrlPojo urlPojo1 = new UrlPojo("http://www.qq.com");
		UrlPojo urlPojo2 = new UrlPojo("http://www.baidu.com");
		
		urlPojoList.add(urlPojo1);
		urlPojoList.add(urlPojo2);
		
		CrawlManager crawlerManager = new CrawlManager(false);
		
		for(UrlPojo pojo:urlPojoList){
			CrawlResult crawlResultPojo = crawlerManager.crawl(pojo);

			
			System.out.println("抓取任务为  "+pojo.toString());
			System.out.println("抓取结果为  "+crawlResultPojo.isSuccess());
			System.out.println(crawlResultPojo.content);
		}
	}
	
}
