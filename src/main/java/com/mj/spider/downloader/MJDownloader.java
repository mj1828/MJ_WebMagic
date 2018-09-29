package com.mj.spider.downloader;

import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

/**
 * 下载，配置代理
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月29日
 */
public class MJDownloader extends HttpClientDownloader {

	public MJDownloader() {
		this.setProxyProvider(SimpleProxyProvider.from(new Proxy("101.101.101.101", 8888, "username", "password")));
	}
}
