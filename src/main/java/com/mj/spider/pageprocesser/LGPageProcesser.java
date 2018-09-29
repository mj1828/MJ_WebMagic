package com.mj.spider.pageprocesser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mj.spider.utils.AgentUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 拉钩网数据爬取
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月20日
 */
public class LGPageProcesser implements PageProcessor {

	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private static Site site = Site.me();
	static {
		site.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		site.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		site.addHeader("Cookie", "");
		site.addHeader("Host", "www.lagou.com");
		site.addHeader("Origin", "https://www.lagou.com");
		site.addHeader("Referer",
				"https://www.lagou.com/jobs/list_java?city=%E5%8C%97%E4%BA%AC&cl=false&fromSearch=true&labelWords=&suginput=");
		site.addHeader("User-Agent", AgentUtils.randomAgent());
	}

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		List<String> results = page.getJson().all();
		JSONArray array = JSONArray.parseArray(results.toString());
		if (array != null) {
			JSONObject result = (JSONObject) array.get(0);
			if (result.getBoolean("success")) {
				page.putField("content", result.getJSONObject("content"));

			}
		}
	}
}
