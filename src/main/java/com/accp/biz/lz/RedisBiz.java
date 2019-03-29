package com.accp.biz.lz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import com.accp.pojo.Services;
import com.accp.util.Pager;
import com.accp.util.RedisBaseOps;
import com.accp.vo.lz.TotalRetrieveVo;
import com.alibaba.fastjson.JSON;

@Service
public class RedisBiz {

	@Autowired
	private RedisBaseOps rbo;

	
	
	//读取redis缓存的推荐前10条数据
	public List<Services> QueryrecommendList(){
				
	 List<Services> data=new ArrayList<Services>(); 
	List<Object> list=rbo.getRedisTemplate().opsForList().range("list:recommendList", 0, -1);
	for (Object object : list) {
					data.add(JSON.parseObject(object.toString(), Services.class));
	}	
	return  data;
	}
	
	
	//查询全部服务
	public List<TotalRetrieveVo> ServicesAll(String service){
		Cursor<Object> iter = rbo.getRedisTemplate().opsForSet().scan("set:recommendList", ScanOptions.scanOptions().match("*"+service+"*").build());
		List<TotalRetrieveVo> list=new ArrayList<TotalRetrieveVo>();
		while (iter.hasNext()) {
			String data = iter.next().toString();
			list.add(JSON.parseObject(data,TotalRetrieveVo.class));//反序列化
		}
		return list;
	}
	
	
	
	
	//读取redis的like查询
	public Pager<TotalRetrieveVo> selectServices(String service,Integer pageIndex,Integer pageSize,Integer index,Integer Pop_Pice){
		Cursor<Object> iter = rbo.getRedisTemplate().opsForSet().scan("set:recommendList", ScanOptions.scanOptions().match("*"+service+"*").build());
		List<TotalRetrieveVo> list=new ArrayList<TotalRetrieveVo>();
		while (iter.hasNext()) {
			String data = iter.next().toString();
			list.add(JSON.parseObject(data,TotalRetrieveVo.class));//反序列化
		}
			List<TotalRetrieveVo> pageList;
			int max = pageIndex*pageSize;
			if(max<list.size()) {
				pageList = list.subList((pageIndex-1)*pageSize, max);
			}else {
				pageList = list.subList((pageIndex-1)*pageSize, list.size());
			}
			if(pageList.size()>0) {
				pageList.sort(new Comparator<TotalRetrieveVo>() {
					@Override
					public int compare(TotalRetrieveVo o1, TotalRetrieveVo o2) {
						// TODO Auto-generated method stub
						if(Pop_Pice==1) {
							return (int)(o1.getBrowseNumber()-o2.getBrowseNumber());
						}else if(Pop_Pice==2){
							return (o2.getBrowseNumber()-o1.getBrowseNumber());
						}else if(Pop_Pice ==3) {
							return (int)(o2.getServicePrice()-o1.getServicePrice());
						}else {
							return (int)(o1.getServicePrice()-o2.getServicePrice());
						}
					}});
			}
			// 定义一个分页类对象
			Pager<TotalRetrieveVo> pager = new Pager<TotalRetrieveVo>(pageIndex, pageSize, list.size(),pageList);
			return pager;
}
	
	
}
