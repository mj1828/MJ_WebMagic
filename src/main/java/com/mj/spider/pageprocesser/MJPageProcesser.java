package com.mj.spider.pageprocesser;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 爬虫
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月20日
 */
public class MJPageProcesser implements PageProcessor {

	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		System.out.println(page.getUrl());
		System.out.println(page.getHtml().xpath("//div[@class='sku-name']/text()"));
		System.out.println(page.getHtml().xpath("//span[@class='price J-p-714875']/text()"));
		List<String> urls = page.getHtml().xpath("//li[@class='gl-item']/div/div/a/@href").all();
		final List<String> newUrls = new ArrayList<>();
		if (urls != null) {
			urls.forEach(url -> {
				if (url.contains("item.jd.com")) {
					newUrls.add(url.substring(2));
				}
			});
		}
		page.addTargetRequests(newUrls);
	}

	public static void main(String[] args) {
		Spider.create(new MJPageProcesser()).addUrl(
				"http://list.jd.com/list.html?cat=12259,12260,9435")
				.thread(3).run();
	}

}
