/**
 * 
 */
package com.topview.manager;

import com.topview.crawl.ICrawl;
import com.topview.crawl.impl.HttpUrlConnectionCrawl;
import com.topview.crawl.impl.SocketCrawl;
import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 */
public class CrawlManager {
	public ICrawl crawl;
	public CrawlManager(boolean isSocket){
		if(isSocket){
			this.crawl = new SocketCrawl();
		}else{
			this.crawl = new HttpUrlConnectionCrawl();
		}
	}
	
	public CrawlResult crawl(UrlPojo urlPojo){
		return this.crawl.crawl(urlPojo);
	}
}
