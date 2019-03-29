package com.accp.cfg.lz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.accp.biz.lz.UserBiz;
import com.accp.pojo.Services;
import com.accp.util.RedisBaseOps;
import com.accp.vo.lz.TotalRetrieveVo;


@Configuration
@EnableScheduling
public class TaskConfig {

	@Autowired
	private UserBiz biz;

	@Autowired
	private RedisBaseOps rbo;

	// 实现【定时从mysql中查询所有消息信息，然后循环插入redis（Hashes）中，完成读写分离同步】
	@Scheduled(cron = "0 0 5 * * ?")
	public void doSynRedis() {
		System.out.println("同步推荐redis");
	
	rbo.del("list:recommendList");
	rbo.del("set:recommendList");
	
	//同步推荐10条
	List<Services> list=biz.QueryrecommendList();
	for (Services services : list) {	
		rbo.getRedisTemplate().opsForList().leftPush("list:recommendList",services);
		
	}
	
	//查询全部服务记录
	List<TotalRetrieveVo> data=biz.SelectServiceAll();
	for (TotalRetrieveVo totalRetrieveVo : data) {
		rbo.getRedisTemplate().opsForSet().add("set:recommendList",totalRetrieveVo);
	}
	

}
}
