package com.mj.spider.pageprocesser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
	private static Site site = Site.me();
	static {
		site.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		site.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		site.addHeader("Cookie",
				"JSESSIONID=ABAAABAAADEAAFI80D6ECEA383D6F4DB28CF019922089D3; _ga=GA1.2.1549829072.1537951689; LGUID=20180926164809-e4d5e321-c168-11e8-a6d3-525400f775ce; _gid=GA1.2.1450767239.1537951689; _putrc=C130EF3EF45E712D; login=true; unick=%E5%BC%A0%E6%98%8C%E6%98%8C; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=166; index_location_city=%E5%8C%97%E4%BA%AC; user_trace_token=20180926164949-205add47-c169-11e8-bb60-5254005c3644; WEBTJ-ID=20180926165608-1661517bbbc3e-0fbd54e89da509-346a7809-1296000-1661517bbbe786; _gat=1; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1537951643,1537952169,1537952780,1537956305; LGSID=20180926180504-a3d0c37a-c173-11e8-a6dc-525400f775ce; PRE_UTM=m_cf_cpt_baidu_pc; PRE_HOST=www.baidu.com; PRE_SITE=https%3A%2F%2Fwww.baidu.com%2Fs%3Fie%3Dutf-8%26f%3D8%26rsv_bp%3D0%26rsv_idx%3D1%26tn%3Dbaidu%26wd%3D%25E6%258B%2589%25E5%258B%25BE%25E7%25BD%2591%26rsv_pq%3Df60e1f94000737cb%26rsv_t%3D9eb2RVboXaC1XHTVOC5K%252BDtEt0F8lo%252BJxZrHKLbIgIGCNrpnb6sGN3Xd37M%26rqlang%3Dcn%26rsv_enter%3D1%26rsv_sug3%3D10%26rsv_sug1%3D10%26rsv_sug7%3D101; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2Flp%2Fhtml%2Fcommon.html%3Futm_source%3Dm_cf_cpt_baidu_pc; gate_login_token=e3dddfdde1dac42dc9f22b5d14c82119008d95fcc3f0fa71; TG-TRACK-CODE=index_search; LGRID=20180926180513-a8c9bb1f-c173-11e8-bb60-5254005c3644; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1537956313; SEARCH_ID=30976e6cd29d4c21aedaec6466c211f5");
		site.addHeader("Host", "www.lagou.com");
		site.addHeader("Origin", "https://www.lagou.com");
		site.addHeader("Referer",
				"https://www.lagou.com/jobs/list_java?city=%E5%8C%97%E4%BA%AC&cl=false&fromSearch=true&labelWords=&suginput=");
		site.addHeader("User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
	}

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		List<String> results = page.getJson().all();
		System.out.println("开始处理结果");
		JSONArray array = JSONArray.parseArray(results.toString());
		if (array != null) {
			JSONObject result = (JSONObject) array.get(0);
			if (result.getBoolean("success")) {
				JSONObject content = result.getJSONObject("content");
				JSONObject hrInfo = content.getJSONObject("hrInfoMap");
				System.out.println(hrInfo.toJSONString());
				JSONObject positionResult = content.getJSONObject("positionResult");
				System.out.println(positionResult.toJSONString());

				JSONObject locationInfo = positionResult.getJSONObject("locationInfo");
				System.out.println(locationInfo.toJSONString());

				JSONObject queryAnalysisInfo = positionResult.getJSONObject("queryAnalysisInfo");
				System.out.println(queryAnalysisInfo.toJSONString());

				JSONObject strategyProperty = positionResult.getJSONObject("strategyProperty");
				System.out.println(strategyProperty.toJSONString());

				JSONArray searchResult = positionResult.getJSONArray("result");
				System.out.println(searchResult.toJSONString());

			}
		}
		System.out.println("结果处理完成");
	}

	public static void main(String[] args) {
		Spider.create(new MJPageProcesser()).addUrl(
				"https://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC&needAddtionalResult=false")
				.thread(3).run();
	}
}
