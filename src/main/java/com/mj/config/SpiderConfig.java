package com.mj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mj.spider.downloader.MJDownloader;
import com.mj.spider.pageprocesser.MJProcesser;
import com.mj.spider.pipeline.MJDBPipeline;
import com.mj.spider.scheduler.MJScheduler;

import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Spider;

/**
 * 爬虫配置
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月20日
 */
@Configuration
public class SpiderConfig {

	@Autowired
	private JedisPool jedisPool;

	private MJScheduler getScheduler() {
		return new MJScheduler(jedisPool);
	}

	@Bean
	public Spider getSpider() {
		return Spider.create(MJProcesser.getPageProcessor("")).setDownloader(new MJDownloader())
				.setScheduler(getScheduler())
				.addPipeline(new MJDBPipeline())
				.addUrl("")
				.thread(3);
	}
}
