
package com.accp.action.lz;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accp.biz.lz.OrderBiz;
import com.accp.biz.lz.UserBiz;
import com.accp.pojo.Login;
import com.accp.pojo.News;
import com.accp.pojo.User;
import com.accp.vo.lz.OrderVO;

/**   
 * @ClassName:  Forward_view   
 * @Description:用于视图跳转  
 * @author: litchi
 * @date:   2019年2月20日 上午7:51:15   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Controller
@RequestMapping("/api/Forward_view")
public class Forward_view {
	@Autowired
	private UserBiz biz;
	@Autowired
	private OrderBiz bizs;
	
	//修改密码
	@RequestMapping(value="/user/updatePwd")
	public String changePasswordView(Model model) {
		//获取邮箱账号
	    Login login=new Login();
		login.setUserid(26);
		model.addAttribute("logininfo",biz.queryLoginInfo(login));
		return "/lz/Html/UpdatePwd";
	}
	
	//修改用户资料
	@RequestMapping(value="/user/Modifydata")
	public String ModifyUserInformation(Model model ,HttpSession session) {
		
		System.out.println("提示："+session.getAttribute("msg"));
		//获取用户信息
		session.setAttribute("userinfo",biz.queryUserInfo(26));
	
		//站内未读
		session.setAttribute("instationunread",biz.Queryunreadinformation(new News(24,2)));
		//系统未读
		session.setAttribute("systemunread",biz.Queryunreadinformation(new News(24,1)));
		//获取邮箱账号
		Login login=new Login();
		login.setUserid(26);
		model.addAttribute("logininfo",biz.queryLoginInfo(login));
		return "/lz/Html/Account_Setting";
	}
	
	//站内信息
	@RequestMapping(value="/user/Stationinfo")
	public String Stationinformation(HttpSession session) {
		//站内未读
		session.setAttribute("instationunread",biz.Queryunreadinformation(new News(24,2)));
		
		return "/lz/Html/Instation_Message";
	}
	//站外信息
	@RequestMapping(value="/user/Offsiteinfo")
	public String Offsiteinformation(HttpSession session) {
		//系统未读
		session.setAttribute("systemunread",biz.Queryunreadinformation(new News(24,1)));
		return "/lz/Html/System_Message";
	}
	
	//站内详细
	@RequestMapping(value="/user/Stationdetails")
	public String Stationdetails(HttpSession session) {
		//站内未读
		session.setAttribute("instationunread",biz.Queryunreadinformation(new News(24,2)));
			return "/lz/Html/MessageInfo";
		}
	
	//个人中心
	@RequestMapping(value="/user/center")
	public String Personalcenter(Model model) {
		
	
		//读取登录用户
		int userid=25;
		model.addAttribute("pageOrderList", bizs.queryMyreservationservice(1,5,new OrderVO(null, userid, null, null)));
		//待付款
		model.addAttribute("prepayment", bizs.querystuats(new OrderVO(null, userid, 1, null)));
		//待接单
		model.addAttribute("Waitingorder", bizs.querystuats(new OrderVO(null, userid, 3, null)));
		//待确认
		model.addAttribute("confirmed", bizs.querystuats(new OrderVO(null, userid, 4, null)));
		//待评价
	    model.addAttribute("comment", bizs.querystuats(new OrderVO(null, userid, 5,1)));
		return "/lz/Html/Member_Center";
	}
	
	//商家店铺信息
	@RequestMapping(value="/user/Shop")
	public String StoreInformation(Model model,HttpSession session) {
		
			User user=(User) session.getAttribute("userinfo");
		//专业
		model.addAttribute("major", biz.queryprofession());
		
		//语言
		model.addAttribute("language", biz.queryLanguage());
		
		//所在城市
		model.addAttribute("Koreacity", biz.queryKorean());
		
		//第一个服务类名称
		model.addAttribute("FirstName", biz.querySerType(user.getFirstserviceid()));
		//第二个服务类名称
		model.addAttribute("secondName", biz.querySerType(user.getSecondserviceid()));
		
		return "/lz/Html/Shop_Manage";
	}
	//账号管理
		@RequestMapping(value="/user/Accountmanage")
		public String Accountmanage() {
			
			return "/lz/Html/Account_Manage";
		}
		
		//发送评价
		@RequestMapping(value="/user/evaluation")
		public String evaluation(Model model,String orderid) {
			model.addAttribute("orderdetail", bizs.queryBookingdetails(new OrderVO(orderid, 25, null, null)));
			return "/lz/Html/publish_evaluate";
		}
		
		//消息提示
		@RequestMapping(value="/user/notification")
		public String notification(HttpSession session,Model model) {
			return "/lz/Html/MSG";
		}
		
		
		//支付金币
		@RequestMapping(value="/user/payGold")
		public String payGold(HttpSession session,Model model,@RequestParam(required = true) String orderid) {
			
			
			//读取登录用户
			model.addAttribute("orderdetail", bizs.queryBookingdetails(new OrderVO(orderid, 25, null, null)));
			return "/lz/Html/pay";
		}
		
		//用户金币记录
		@RequestMapping(value="/user/goldcoinrecord")
		public String Goldcoinrecord() {
			return "/lz/Html/My_gold";
		}
		
		//用户积分记录
		@RequestMapping(value="/user/pointrecord")
		public String Pointrecord() {
		return "/lz/Html/My_integral";
		}
		
		
		//我的评价
		@RequestMapping(value="/user/myreview")
		public String myreview() {
		return "/lz/Html/My_evaluate";
		}
		
		//我的退款
		@RequestMapping(value="/user/myrefund")
		public String myrefunddetailed() {
			return "/lz/Html/My_refund";
		}
		
		//我的退款详细
		@RequestMapping(value="/user/fundDetailed")
		public String myrefund() {
		return "/lz/Html/refund_info";
					}
		//积分抽奖
		@RequestMapping(value="/user/Pointsdraw")
		public String Pointsdraw() {
			return "/lz/Html/integral_draw";
			}
			
		//我的收藏
		@RequestMapping(value="/user/mycollection")
		public String mycollection() {
			return "/lz/Html/My_collect";
			}
		
		//申请退款
		@RequestMapping(value="/user/Requestrefund")
		public String Requestrefund() {
			return "/lz/Html/Requestrefund";
			}
		
		//账号提现
		@RequestMapping(value="/user/withdrawal")
		public String Accountwithdrawal(Model model ) {
			//银行类别表
			model.addAttribute("Banktype", bizs.queryBanktype());
			return "/lz/Html/drawings";
			}
		
		//账号充值
		@RequestMapping(value="/user/recharge")
		public String Accountrecharge() {
			return "/lz/Html/Artificial_Recharge_platform";
			}
}
