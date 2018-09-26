package com.mj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.spider.pageprocesser.MJPageProcesser;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisPriorityScheduler;

@RestController
public class SpiderController {

	@Autowired
	private RedisPriorityScheduler redisPriorityScheduler;


	@GetMapping
	public String test() {
		Spider.create(new MJPageProcesser()).setScheduler(redisPriorityScheduler)
				.addUrl("http://www.peoplerail.com/rmtd2016/content/2018-09/20/node_2.htm").thread(3).run();
		return "";
	}
}
