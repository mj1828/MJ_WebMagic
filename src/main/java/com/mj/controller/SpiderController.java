package com.mj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.spider.pageprocesser.MJPageProcesser;

import us.codecraft.webmagic.Spider;

@RestController
public class SpiderController {



	@GetMapping
	public String test() {
		Spider.create(new MJPageProcesser())
				.addUrl("http://www.peoplerail.com/rmtd2016/content/2018-09/20/node_2.htm").thread(3).run();
		return "";
	}
}
