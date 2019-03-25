package com.accp.biz.hzj;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.hzj.IAdvertisementDao;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Post;
import com.accp.vo.hzj.AdvertisementVO;
import com.accp.vo.hzj.HomePostVO;
import com.accp.vo.hzj.ImageWidthAndHeightVO;
import com.accp.vo.hzj.SerRecommendVO;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class AdvertisementBiz {
	
	@Autowired
	private IAdvertisementDao dao;
	
	/**
	 * 首页社区服务广告位查询
	 * @param flag
	 * @return
	 */
	public List<AdvertisementVO> queryHomeAdvertising(Integer atid) {
		return dao.queryHomeAdvertising(atid);
	}
	
	/**
	 * 首页社区服务星级服务推荐商家
	 * @param stid
	 * @return
	 */
	public List<SerRecommendVO> querySerRecommendVO(Integer stid){
		return dao.querySerRecommendVO(stid);
	}
	
	/**
	 * 查询首页社区服务最新帖子
	 * @return
	 */
	public List<HomePostVO> queryHomePostVO(){
		return dao.queryHomePostVO();
	}
	
	/**
	 * 查询首页社区服务美妆天地板块帖子
	 * @return
	 */
	public List<Post> queryHomePostByMakeup(){
		return dao.queryHomePostByMakeup();
	}
	
	
}
