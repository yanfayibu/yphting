package com.accp.biz.zrb;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zrb.IPrestigeDao;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
@SuppressWarnings("all")
public class PrestigeBiz {
	
	@Autowired 
	private IPrestigeDao dao;
	
	/**
	 * 查询订单信誉分
	 * @param userId
	 * @return
	 */
	public int selectOrderScore(Integer userId) {
		return dao.selectOrderScore(userId);
	}
	
	/**
	 * 查询销售额信誉分
	 * @param userId
	 * @return
	 */
	public int selectMoneyScore(Integer userId) {
		return dao.selectMoneyScore(userId);
	}
	
	/**
	 * 查询服务收藏数信誉分
	 * @param userId
	 * @return
	 */
	public int selectCollectCountScore(Integer userId) {
		return dao.selectCollectCountScore(userId);
	}
	
	/**
	 * 查询商家的服务的好评数信誉分
	 * @param userId
	 * @return
	 */
	public int selectGoodScore(Integer userId) {
		return dao.selectGoodScore(userId);
	}
	
	/**
	 * 查询店铺星级
	 * @param userId
	 * @return
	 */
	public int selectMerchantLevelScore(Integer userId) {
		return dao.selectMerchantLevelScore(userId);
	}
	
	
	
} 
