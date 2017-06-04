/**
 * 
 */
package com.topview.crawl;

import com.topview.pojo.CrawlResult;
import com.topview.pojo.UrlPojo;

/**
 * @author bingqin
 * @date 2017年5月22日
 * 爬虫捉取的接口
 */
public interface ICrawl {
	public CrawlResult crawl(UrlPojo urlPojo);
}
