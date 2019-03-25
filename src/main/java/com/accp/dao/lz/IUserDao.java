
package com.accp.dao.lz;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Languagetype;
import com.accp.pojo.Login;
import com.accp.pojo.Lotteryrecord;
import com.accp.pojo.Majortype;
import com.accp.pojo.News;
import com.accp.pojo.Prize;
import com.accp.pojo.Sharea;
import com.accp.pojo.System;
import com.accp.pojo.User;
import com.accp.vo.lz.BottomAdVO;
import com.accp.vo.lz.EvaluationVO;
import com.accp.vo.lz.FavoriteProductVO;
/**
 * 
 * @ClassName:  IUserDao   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: litchi
 * @date:   2019年2月18日 下午10:04:04   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
import com.accp.vo.lz.NewVO;
import com.accp.vo.lz.RecommendVO;
import com.accp.vo.lz.ServiceTypeVO;
public interface IUserDao {


	
	//Query user information
	public User  queryUserInfo(@Param("userID") Integer userID);
	//Modify user information
	public  int updateUser(@Param("user") User user);
	//change password
	public  int updatePwd(@Param("userEmail") String userEmail,@Param("userPwd") String userPwd);
	//Query login information
	public  Login  queryLoginInfo(@Param("login") Login login);
	
	//updateLoginEmail
	public int updateLoginEmail(@Param("login") Login login);
	
	//Query area
	public List<Sharea> Queryarea();
	
	//Query inside and outside the station
	public List<NewVO> searchNew(@Param("type") Integer type,@Param("addRessee") Integer addRessee);
	
	//Delete messages
	public  int delmessages(@Param("newsID")Integer newsID);
	
	//update messages
	public  int updatemessages(@Param("news") NewVO news);
	
	//Station details
	public  List<NewVO> Queryzndetails(@Param("messageGroup") Integer messageGroup);
	
	//Add a station letter
	public  int  Addnews(@Param("news") News news);
	
	
	//Query service language
	public List<Languagetype> queryLanguage();

	//Query profession
	public List<Majortype> queryprofession();
	
	//Check the Korean region
	public List<Sharea> queryKorean();
	
	//Query service name
	public String querySerType( @Param("id") Integer id);
	
	//Modify store information
	public int updateUserShop(@Param("u") User u);
	
	
	//Query unread information
	public  String Queryunreadinformation(@Param("news") News news); 
	
	
	//Modify user amount points
	public  int UpdateAmountofpoints(@Param("u") User u);
	
	//Gold coin record inquiry
	public List<Goldnotes> QueryGold(@Param("userid")int userid,@Param("acquisitionmode")int acquisitionmode,@Param("start")String start ,@Param("end")String end);
	
	//Query score record
	public List<Integralrecord> QueryIntegral(@Param("userid")int userid,@Param("start")String start ,@Param("end")String end);
	
	//Query my review
	public  List<EvaluationVO> Querymyreview(@Param("userid")int userid);
	
	
	//Check if you check in
	public Date Querysignin(@Param("userid") int userid);
	
	
	//Add user credit history
	public  int addIntegralRecording(@Param("integra") Integralrecord integra);
	
	//Add user gold coin record
	public  int addGoldRecording(@Param("gold") Goldnotes gold);
	
	
	//Query prize list
	public  List<Prize> QueryPrizeList();
	
	
	//Query prize name
	public String QueryPrizeName(@Param("prizeid") int prizeid);
	
	//Add winning record
	public int addPrizerecord(@Param("lotter") Lotteryrecord lotter);
	
	
	//查询中奖记录
	public  List<Lotteryrecord>  QueryLotteryrecord();
	
	//查询最新一条中奖记录
	public  Lotteryrecord QueryOneLotteryrecord();
	
	//查询商品星数
	public String  QueryProductstar(@Param("serviceID") int serviceID);
	
	//查询收藏商品
	public List<FavoriteProductVO> QueryFavoriteProduct(@Param("name") String name,@Param("userid") int userid,@Param("stid")int stid);
	
	//查询收藏商品服务类别
	public List<ServiceTypeVO> QueryServiceType(@Param("userid") int userid);
	
	//删除服务收藏
	public  void delteservicecollection(@Param("sercolleid") int sercolleid);
	
	//查询推荐服务
	public List<RecommendVO> Queryrecommend();
	
	//查询底部加入我们上方广告
	public BottomAdVO QueryBottomAdVO();
	
	//查询系统配置信息
	public System Querysysteminfo();
}
