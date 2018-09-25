package com.mj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.scheduler.RedisPriorityScheduler;

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

	@Bean
	public RedisPriorityScheduler getRedisPriorityScheduler() {
		return new RedisPriorityScheduler(jedisPool);
	}
}
