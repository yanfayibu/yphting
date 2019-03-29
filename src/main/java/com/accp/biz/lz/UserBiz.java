
package com.accp.biz.lz;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.accp.dao.lz.IUserDao;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Languagetype;
import com.accp.pojo.Login;
import com.accp.pojo.Lotteryrecord;
import com.accp.pojo.Majortype;
import com.accp.pojo.News;
import com.accp.pojo.Prize;
import com.accp.pojo.Services;
import com.accp.pojo.Sharea;
import com.accp.pojo.System;
import com.accp.pojo.User;
import com.accp.util.RedisBaseOps;
import com.accp.vo.lz.BottomAdVO;
import com.accp.vo.lz.EvaluationVO;
import com.accp.vo.lz.FavoriteProductVO;
import com.accp.vo.lz.NewVO;
import com.accp.vo.lz.RecommendVO;
import com.accp.vo.lz.ServiceTypeVO;
import com.accp.vo.lz.TotalRetrieveVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**   
 * @ClassName:  UserBiz   
 * @Description:User business layer
 * @author: litchi
 * @date:   2019年2月18日 下午10:44:29   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */

@Service("userbiz")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
@SuppressWarnings("all")
public class UserBiz {

	@Autowired
	private IUserDao userdao;
	
	@Autowired
	private RedisBaseOps rbo;
	//change Password
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int  updatePwd(String userEmail,String userPwd) throws Exception {
		return userdao.updatePwd(userEmail, userPwd);
	}
	
	//queryLoginInfo
	public  Login queryLoginInfo(Login login) {
		return userdao.queryLoginInfo(login);
	}
	//查询用户信息
	public  User queryUserInfo(Integer userID) {
		return userdao.queryUserInfo(userID);
	}
	
	//修改用户信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int updateUser(User user)throws Exception {
		return userdao.updateUser(user);
	}
	
	//查询地区
	public List<Sharea> Queryarea(){
		return userdao.Queryarea();
	}
	//修改登录邮箱账号
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  int updateLoginEmail(Login login)throws Exception {
		return userdao.updateLoginEmail(login);
	}
	//查询站内外消息
	public PageInfo<NewVO> searchNew(Integer type,Integer addRessee,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<NewVO>(userdao.searchNew(type, addRessee));
	}
	//删除消息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int delmeassge(Integer newsID)throws Exception {
		return userdao.delmessages(newsID);
	}
	//置为已读
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updatemessages(NewVO news) {
		return userdao.updatemessages(news);
	}
	//查询站内详情消息
		public PageInfo<NewVO> Queryzndetails(Integer messageGroup,Integer pageNum,Integer pageSize){
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<NewVO>(userdao.Queryzndetails(messageGroup));
		}
		//新增站内信
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public boolean Addnews(News news){
			return userdao.Addnews(news)>0;
		}
		
		
		//服务语言表
		public List<Languagetype> queryLanguage(){
			return userdao.queryLanguage();
		}
		
		//专业表
		public List<Majortype> queryprofession(){
			return userdao.queryprofession();
		}
		
		//韩国城市
		public List<Sharea> queryKorean(){
			return userdao.queryKorean();
		}
		//查询服务类型名称
		public String querySerType(Integer id) {
			return userdao.querySerType(id);
		}
		
		//修改店铺信息
		public  boolean updateUserShop(User u) {
			return userdao.updateUserShop(u)>0;
		}
		//查询未读信息数量
		public int Queryunreadinformation( News news) {
			int i=0;
			if(!userdao.Queryunreadinformation(news).equals("")&& !userdao.Queryunreadinformation(news).equals(null)) {
				i=Integer.parseInt(userdao.Queryunreadinformation(news));
			}
			return i;
		}
		
		
		//修改用户积分和金币
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public  boolean UpdateAmountofpoints(User u) {
		return userdao.UpdateAmountofpoints(u)>0;
		}
		
		//查询用户金币记录
		public PageInfo<Goldnotes> QueryGold(int userid,int acquisitionmode,String start ,String end,Integer pageNum,Integer pageSize){
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<Goldnotes>(userdao.QueryGold(userid,acquisitionmode,start,end));
		}
		
		//查询用户积分记录
		public PageInfo<Integralrecord> QueryIntegral(int userid,String start ,String end,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Integralrecord>(userdao.QueryIntegral(userid, start, end));
				}
		
		//查询我的评价以及商家回复评价
		public PageInfo<EvaluationVO> Querymyreview(int userid,Integer pageNum,Integer pageSize){
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<EvaluationVO>(userdao.Querymyreview(userid));
		}
		
		//查询签到记录
		public  Date Querysignin(int userid) {
			return userdao.Querysignin(userid);
		}
		
		//新增用户积分记录
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public  boolean addIntegralRecording(Integralrecord integra) {
		return userdao.addIntegralRecording(integra)>0;
		}
				
		//新增用户金币记录
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public  boolean addGoldRecording(Goldnotes gold) {
		return userdao.addGoldRecording(gold)>0;
				}
		
		
		
		//奖品列表
		public  List<Prize> QueryPrizeList(){
			return userdao.QueryPrizeList();
		}
		
		//查询奖品名称 
		public String QueryPrizeName(int prizeid) {
			return userdao.QueryPrizeName(prizeid);
		}
		
		//新增抽奖记录
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public  boolean addPrizerecord(Lotteryrecord lotter) {
		return userdao.addPrizerecord(lotter)>0;
		}
		//查询中奖记录
		public List<Lotteryrecord> QueryLotteryrecord(){
			return userdao.QueryLotteryrecord();
		}
		
		//查询一条最新中奖记录
		public  Lotteryrecord  QueryOneLotteryrecord() {
			return userdao.QueryOneLotteryrecord();
		}
		
		
		//查询收藏商品服务类别
		public List<ServiceTypeVO> QueryServiceType(Integer userid){
			return userdao.QueryServiceType(userid);
		}
		
		//查询收藏商品
		public PageInfo<FavoriteProductVO> QueryFavoriteProductpage(Integer pageNum,Integer pageSize,String name,Integer userid,Integer stid){
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<FavoriteProductVO>(userdao.QueryFavoriteProduct(name, userid, stid));
		}	
		
		//查询商品星数
		public String  QueryProductstar( int serviceID) {
			return userdao.QueryProductstar(serviceID)!=null?userdao.QueryProductstar(serviceID):"0";
		}
		
		//删除服务收藏
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public void delteservicecollection(Integer sercolleid)throws Exception {
			userdao.delteservicecollection(sercolleid);
		}
		
		//查询服务推荐
		public  List<RecommendVO> Queryrecommend() {
			return userdao.Queryrecommend();

		}
		
		//查询底部加入我们上方广告
		public BottomAdVO QueryBottomAdVO() {
			return userdao.QueryBottomAdVO();
		}
		
		//查询系统配置信息
		public System Querysysteminfo() {
			return userdao.Querysysteminfo();
		}
		
		
		//查询10条服务推荐
		public  List<Services> QueryrecommendList(){
			return userdao.QueryrecommendList();
		}
		
		//全站搜索全部
		public  List<TotalRetrieveVo>  SelectServiceAll(){
			return userdao.SelectTotalRetrieveVo();
		}
		
		
		
		//修改第一个二个服务金额
		@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public void updateOneANDtwosum(User u,int stid) {
		 userdao.updateOneANDtwosum(u, stid);
		}
		
			
}
