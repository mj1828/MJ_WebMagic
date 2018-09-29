package com.mj.spider.scheduler;

import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.scheduler.RedisPriorityScheduler;

/**
 * 任务调度
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月29日
 */
public class MJScheduler extends RedisPriorityScheduler {

	public MJScheduler(JedisPool pool) {
		super(pool);
	}
}
