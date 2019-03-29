package com.accp.dao.smy;



import com.accp.pojo.Advertisement;
import com.accp.pojo.Star;
import com.accp.pojo.StarApply;
import com.accp.vo.smy.AppraisalApply;
import com.accp.vo.smy.EvaluationVo;
import com.accp.vo.smy.Goldnotes;
import com.accp.vo.smy.LanguageType;
import com.accp.vo.smy.Level;
import com.accp.vo.smy.MajorType;
import com.accp.vo.smy.Order;
import com.accp.vo.smy.OrderInfoVo;
import com.accp.vo.smy.Orders;
import com.accp.vo.smy.RefundVO;
import com.accp.vo.smy.Services;
import com.accp.vo.smy.ServicesLevel;
import com.accp.vo.smy.ServiceType;
import com.accp.vo.smy.ShArea;
import com.accp.vo.smy.User;
import com.accp.vo.smy.UserAppVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ServicesDao {
	//发布服务
	public int addService(@Param("services")Services services);
	//商家入驻获取服务类型
	public List<ServiceType> queryServiceType(@Param("stpid")Integer stpid,@Param("selectNum")Integer selectNum);
	//商家入驻获取服务语言
	public List<LanguageType> queryLanguagetype();
	//商家入驻获取专业
	public List<MajorType> queryMajortype();
	//商家入驻获取行政地区
	public List<ShArea> querySharea(@Param("pid")Integer pid,@Param("flag")boolean flag);
	//商家入驻保证金
	public float queryBond();
	//获取当前用户
	public User queryUser(@Param("userID") Integer userID);
	//商家入驻
	public int merchantMove(@Param("obj")User user,@Param("bond")float bond);
	//查询商家用户收到的预定信息
	public List<OrderInfoVo> queryUserOrder(@Param("userID")Integer userID,@Param("orderStatus")Integer orderStatus,@Param("refundstatus")Integer refundstatus,@Param("orderID")String orderID);
	//查询商家中心服务类别
	public ServiceType querySerType(@Param("stid")Integer stid);
	//查询商家订单
	public List<Orders> queryCountOrder(@Param("userID")Integer userID);
	//订单查看详情
	public OrderInfoVo queryAOrder(@Param("orderID")String orderID);
	//修改订单状态
	public int updateOrdersStatus(@Param("orderStatus")Integer orderStatus,@Param("orderID")String orderID);
	//商家中心我发布的服务
	public List<Services> queryServiceAndByTitle(@Param("userID")Integer userID,@Param("serviceTitle")String serviceTitle);
	//获取发布服务类别
	public Services queryService(@Param("serviceID")Integer serviceID);
	//
	public User queryUserById(Integer userid);
	//商家中心编辑我发布的服务
	public int updateService(@Param("services")Services services);
	//商家中心删除我发布的服务
	public int deleteService(@Param("serviceID")Integer serviceID);
	//商家中心查询我提交的鉴定
	public List<UserAppVo> queryAppraisalapply(@Param("userID")Integer userID,@Param("oneid")Integer oneid,@Param("twoid")Integer twoid);
	//商家中心提交鉴定
	public int addAppraisalapply(@Param("app")AppraisalApply app);
	//商家中心我收到的评价
	public List<EvaluationVo> queryEvaluation(@Param("userID")Integer userID);
	//商家中心回复评价
	public int addMerchantsEvaluation(@Param("serviceID") Integer serviceID,@Param("userID") Integer userID,@Param("PID") Integer PID,@Param("serviceContent") String serviceContent);
	//获取鉴定服务类别
	public AppraisalApply queryAppraisal(@Param("applyID")Integer applyID);
	//重新提交鉴定
	public int updateAppraisalApply(@Param("app")AppraisalApply app);
	
	//查询订单列表
	//public List<Order> queryOrderList(@Param("order")Order order);
	
	//根据编号获取订单信息
	public Order queryOrderById(@Param("orderid")String orderid);
	//获取退款详细信息
	public RefundVO queryRefundByOrderId(@Param("orderid")String orderID);
	//商家中心我收到的退款
	public List<RefundVO> queryRefundList(@Param("userid")Integer userid);
	
	
	//User queryUserById(int userid);
	
	
	//金币流向记录
	public int saveGoldNotes(@Param("userID")Integer userID,@Param("acquisitionMode")Integer acquisitionMode,@Param("recordDescribe")String recordDescribe,@Param("recordInAndOut")float recordInAndOut,@Param("auditStatus")Integer auditStatus);
	//新增系统消息
	public int saveSystemMSG(@Param("userID")Integer userID,@Param("content")String content);
	//修改订单
	public boolean updateOrder(@Param("order")Orders order);
	//修改退款
	public boolean updateRefund(@Param("refund")RefundVO refund);
	//添加用户金币收入和支出记录
	public int addGoldnotes(@Param("goldnotes")Goldnotes goldnotes);
	//修改用户余额
	public boolean updateUserMoney(@Param("userMoney")float userMoney,@Param("userID")Integer userID);
	//查询商家头衔
	public List<ServicesLevel> querySerlevelName(@Param("userID")Integer userID);
	//
	public Level queryLevel(@Param("userID")Integer userID);
	//查询可申请的星级推荐位
	public List<Star> queryStar(@Param("stid")Integer stid);
	//商家申请星级服务推荐
	public int addStarApply(@Param("starApply")StarApply starApply);
	public Star queryPrice(@Param("sid")Integer sid);
	
	
	//查询订单信誉积分
	public Integer selectOrderScore(@Param("userId")Integer userId);
	//查询销售额信誉分
	public Integer selectMoneyScore(@Param("userId")Integer userId);
	//查询服务收藏数信誉分
	public Integer selectCollectCountScore(@Param("userId")Integer userId);
	//查询商家服务受到好评数信誉分
	public Integer selectGoodScore(@Param("userId")Integer userId);
	//查询店铺星级
	public Integer selectMerchantLevelScore(@Param("userId")Integer userId);
	public Advertisement queryAimgpath();
}
