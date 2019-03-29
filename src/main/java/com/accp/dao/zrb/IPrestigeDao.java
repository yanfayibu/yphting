package com.accp.dao.zrb;

import org.apache.ibatis.annotations.Param;

public interface IPrestigeDao {
	
	/**
	 * 查询订单信誉分
	 * @param userId
	 * @return
	 */
	public Integer selectOrderScore(@Param("userId")Integer userId);
	
	/**
	 * 查询销售额信誉分
	 * @param userId
	 * @return
	 */
	public Integer selectMoneyScore(@Param("userId")Integer userId);
	
	/**
	 * 查询服务收藏数信誉分
	 * @param userId
	 * @return
	 */
	public Integer selectCollectCountScore(@Param("userId")Integer userId);
	
	/**
	 * 查询商家的服务的好评数信誉分
	 * @param userId
	 * @return
	 */
	public Integer selectGoodScore(@Param("userId")Integer userId);
	
	/**
	 * 查询店铺星级
	 * @param userId
	 * @return
	 */
	public Integer selectMerchantLevelScore(@Param("userId")Integer userId);
	
}
