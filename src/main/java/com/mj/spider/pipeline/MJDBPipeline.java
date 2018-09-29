package com.mj.spider.pipeline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 管道，数据处理
 * 
 * @author MJ
 * @mail mj_java@.com
 * @date 2018年9月29日
 */
public class MJDBPipeline implements Pipeline {

	@Override
	public void process(ResultItems resultItems, Task task) {
		if (resultItems != null) {
			System.out.println(resultItems.getAll());
		}
	}

}
