package com.mj.spider.pageprocesser;

import java.util.HashMap;
import java.util.Map;

import com.mj.util.SpringBeenUtils;

import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 获取页面解析
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月20日
 */
public class MJProcesser {

	private static Map<String, PageProcessor> pageProcessorMap = new HashMap<String, PageProcessor>();

	/**
	 * 获取
	 * 
	 * @Description:   
	 * @return: PageProcessor      
	 * @throws
	 */
	public static PageProcessor getPageProcessor(String name) {
		if (pageProcessorMap.containsKey(name)) {
			return pageProcessorMap.get(name);
		}
		Object o = SpringBeenUtils.getBean(name);
		if (o != null) {
			pageProcessorMap.put(name, (PageProcessor) o);
			return (PageProcessor) o;
		}
		return null;
	}

}
