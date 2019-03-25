package com.accp.dao.hzj;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Advertisement;
import com.accp.pojo.Post;
import com.accp.vo.hzj.AdvertisementVO;
import com.accp.vo.hzj.HomePostVO;
import com.accp.vo.hzj.ImageWidthAndHeightVO;
import com.accp.vo.hzj.SerRecommendVO;

public interface IAdvertisementDao {

	
	/**
	 * 首页社区服务广告位查询
	 * @param flag
	 * @return
	 */
	public List<AdvertisementVO> queryHomeAdvertising(@Param("atid")Integer atid);
	
	
	/**
	 * 首页社区服务星级服务推荐商家
	 * @param stid
	 * @return
	 */
	public List<SerRecommendVO> querySerRecommendVO(@Param("stid")Integer stid);
	
	
	/**
	 * 查询首页社区服务最新帖子 
	 * @return
	 */
	public List<HomePostVO> queryHomePostVO();
	
	
	/**
	 * 查询首页社区服务美妆天地板块帖子
	 * @return
	 */
	public List<Post> queryHomePostByMakeup();
	
	
	

}
