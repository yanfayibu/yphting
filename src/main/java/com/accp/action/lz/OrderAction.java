
package com.accp.action.lz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.lz.OrderBiz;
import com.accp.biz.lz.UserBiz;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Orders;
import com.accp.pojo.Putforward;
import com.accp.pojo.Putforwardrecord;
import com.accp.pojo.Refund;
import com.accp.pojo.User;
import com.accp.vo.lz.OrderVO;
import com.accp.vo.lz.RefundVO;
import com.github.pagehelper.PageInfo;

/**   
 * @ClassName:  OrderAction   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: litchi
 * @date:   2019年2月26日 下午2:26:36   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Controller
@RequestMapping("/c/lz/dsd")
public class OrderAction {

	
	
	@Autowired
	private OrderBiz biz;
	@Autowired
	private UserBiz bizs;
	
	//查询我的预定服务
	@RequestMapping(value="user/queryMyreservationservice",method=RequestMethod.GET)
	public String queryMyreservationservice(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "") String orderid, @RequestParam(defaultValue = "") Integer status,@RequestParam(required = false) Integer commentstatus,HttpSession session,Model model ) {
		User us=(User) session.getAttribute("userinfo");
		
		
		//待付款
		model.addAttribute("prepayment", biz.querystuats(new OrderVO(null, us.getUserid(), 1, null)));
		//待接单
		model.addAttribute("Waitingorder", biz.querystuats(new OrderVO(null, us.getUserid(), 3, null)));
		//待确认
		model.addAttribute("confirmed", biz.querystuats(new OrderVO(null, us.getUserid(), 4, null)));
		//待评价
		model.addAttribute("comment", biz.querystuats(new OrderVO(null, us.getUserid(), 5, 1)));
		OrderVO ordervo=new OrderVO();
		ordervo.setUserid(us.getUserid());
		ordervo.setOrderid(orderid);
		ordervo.setOrderstatus(status);
		ordervo.setCommentstatus(commentstatus);
		model.addAttribute("pageOrderList", biz.queryMyreservationservice(pageNum, 3, ordervo));
		model.addAttribute("statusID", status);
		return "/lz/Html/My_reservation";
	}
	
	//查看我的预定详细信息
	@RequestMapping(value="user/order/query/detail",method=RequestMethod.GET)
	public String queryOrderDetail(@RequestParam(required = true) String orderid, Model model,HttpSession session) {
		//读取登录用户
		User us=(User) session.getAttribute("userinfo");
		model.addAttribute("orderdetail", biz.queryBookingdetails(new OrderVO(orderid, us.getUserid(), null, null)));
		return "lz/Html/detail";
	}
	
	//发表评价
	@RequestMapping(value="user/Postevaluation",method=RequestMethod.POST)
	public String addds(HttpSession session,Evaluationservice evalua, Model model,@RequestParam(required = true) String orderid) {
		
		System.out.println("订单编号："+orderid);
		//获取登录用户编号
		User us=(User) session.getAttribute("userinfo");
		
		
		evalua.setUserid(us.getUserid());
		if(biz.addEvaluation(evalua)) {
			session.setAttribute("msg", "发表评价成功");
			
			//修改订单状态
			Orders  order=new Orders();
			order.setOrderid(orderid);
			order.setCommentstatus(2);
			biz.updateOrderstatus(order);
			
			return "redirect:/api/Forward_view/user/notification";
		}
		else {
			session.setAttribute("msg", "发表评价失败");
			return "redirect:/api/Forward_view/user/notification";
		}
	}
	

	//取消服务
	@PutMapping(value="user/order/serve")
	@ResponseBody
	public  Map<String,String> Updateservice(@RequestBody Orders order){
		Map<String,String> msg=new HashMap<String, String>();
		if(biz.updateOrderstatus(order)) {
			msg.put("code", "200");
			msg.put("msg", "ok");
		}
		else {
			msg.put("code", "500");
			msg.put("msg", "no");
		}
		
		return  msg;
	}
	
	//确认完成
	@PostMapping(value="user/order/Confirm/{orderid}")
	@ResponseBody
	public  Map<String,String> Confirmcompleted(@PathVariable String orderid,HttpSession session){
		Map<String,String> msg=new HashMap<String, String>();
		//读取登录用户
		User us=(User) session.getAttribute("userinfo");
		Orders order=new  Orders();
		order.setCommentstatus(1);//评论状态(1待评价2用户已评3双方已评)
		order.setOrderstatus(5);//订单状态(1待付款2待接单3待提供服务4已提供服务5服务完成6服务取消7未接单8已退款)
		order.setOrderid(orderid);
		if(biz.updateOrderstatus(order)) {
			
			//确认完成给商家加金币
			List<OrderVO> data=biz.queryBookingdetails(new OrderVO(orderid, us.getUserid(), null, null));;
			
			//获得商家用户信息
			User u= bizs.queryUserInfo(data.get(0).getUser().getUserid());
			//修改用户金币
			User uu=new User();
			uu.setUserid(u.getUserid());
			uu.setUsermoney(u.getUsermoney()+data.get(0).getSmallplan());
			bizs.UpdateAmountofpoints(uu);
			//刷新用户信息
			session.setAttribute("userinfo",bizs.queryUserInfo(us.getUserid()));
			//添加金币记录
			Goldnotes gold =new Goldnotes();
			gold.setUserid(u.getUserid());
			gold.setAcquisitionmode(2);//	(1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)
			gold.setRecorddescribe("用户：'"+us.getUsername()+"' 确认完成订单，订单号："+data.get(0).getOrderid());
			gold.setAuditstatus(2);//审核状态(1待审核2审核成功3未通过)
			gold.setRecordinandout(+data.get(0).getSmallplan());
			bizs.addGoldRecording(gold);
			
		
			
			msg.put("code", "200");
			msg.put("msg", "ok");
		}
		else {
			msg.put("code", "500");
			msg.put("msg", "no");
		}
		
		return  msg;
	}
	
	//查询我的退款
	@RequestMapping(value="/user/queryMyrefund/{pageNum}/{orderid}/{start}/{end}",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<RefundVO> queryMyrefund (@PathVariable Integer pageNum, @PathVariable String orderid,@PathVariable String start,@PathVariable String end,HttpSession session) {
	//读取登录用户
	User us=(User) session.getAttribute("userinfo");
	return  biz.queryMyrefund(pageNum, 3, us.getUserid(), orderid, start, end);
	}
	
	
	//查询我的退款详细
	@RequestMapping(value="/user/queryMyrefundDetailed/{orderid}",method=RequestMethod.GET)
	@ResponseBody
	public List<RefundVO> queryMyrefundDetailed(@PathVariable String orderid) {
	return  biz.queryMyrefundDetailed(0, orderid, null, null);
	}
	
	
	
	//申请退款
	@RequestMapping(value="/user/addRefund",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addRefund(@RequestBody Refund refund,HttpSession session) {
	//读取登录用户
	User user=(User) session.getAttribute("userinfo");
	refund.setUserid(user.getUserid());
	refund.setPoint(1);//退款申请指向，1：商家，2：管理员
	refund.setAuditstatus(1);//商家审核状态(1待审核2审核成功3未通过)
	refund.setApplicationtime(new Date());
	//修改订单状态
	Orders  order =new Orders();
	order.setRefundstatus(1);//	退款状态(1退款申请中2不同意3申请管理员介入4管理员拒绝5退款完成6退款取消)
	order.setOrderid(refund.getOrderid());
	biz.updateOrderstatus(order);
	Map<String,String> MSG=new HashMap<String,String>();
	if( biz.addRefund(refund)) {
		MSG.put("code","200");
		MSG.put("msg","ok");
	}
	else {
		MSG.put("code","500");
		MSG.put("msg","no");
	}
	return MSG;
	}
	
	
	//申请提现
		@RequestMapping(value="/user/addwithdraw",method=RequestMethod.POST)
		@ResponseBody
		public Map<String,String> addwithdraw(@RequestBody Putforward put,HttpSession session) {
			Map<String,String> MSG=new HashMap<String,String>();
			
			//前台提现金币
			Float m=put.getMoney();
			//读取登录用户
			User user=(User) session.getAttribute("userinfo");
			//查询系统配置收费比例
			com.accp.pojo.System system= bizs.Querysysteminfo();
			//计算提扣除手续
			Float moeny=m-put.getMoney()*(system.getCharge()*0.01f);
			//计算账户的总金额扣除手续费后的金币
			Float usermoeny=user.getUsermoney()-user.getUsermoney()*(system.getCharge()*0.01f);
			
			System.out.println("提现金额"+m+put.getMoney()*(system.getCharge()*0.01f));
			System.out.println("用户金额"+usermoeny);
			//判断余额
			if(m+(put.getMoney()*(system.getCharge()*0.01f))>usermoeny) {
				MSG.put("code","300");
				MSG.put("msg","no");
			}
			else {
				
				//添加提现记录
				Putforwardrecord pt=new Putforwardrecord();
				pt.setUserid(user.getUserid());
				pt.setBankaccount(put.getBankaccount());
				pt.setBankid(put.getBankid());
				pt.setSubmittime(new Date());
				pt.setMoney(moeny);
				try {
					biz.addwithdrawrecord(pt);
					
					put.setMoney(moeny);
					put.setUserid(user.getUserid());
					put.setSubmittime(new Date());
					put.setAuditstatus(1);//审核状态(1待审核2审核成功3未通过)
					if(biz.addwithdraw(put)) {
				
					//修改用户金币
					User u=new User();
					u.setUserid(user.getUserid());
					u.setUsermoney(user.getUsermoney()-(m+put.getMoney()*(system.getCharge()*0.01f)));
					if(bizs.UpdateAmountofpoints(u)) {
						
						//新增金币记录
						Goldnotes gold=new Goldnotes();
						gold.setUserid(user.getUserid());//用户编号
						gold.setAcquisitionmode(8);//(1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)
						gold.setRecorddescribe("申请提现");//记录描述
						gold.setRecordinandout(-(m+put.getMoney()*(system.getCharge()*0.01f)));//	记录收入，支出
						gold.setAuditstatus(1);//审核状态(1待审核2审核成功3未通过)
						if(bizs.addGoldRecording(gold)) {
							//重新赋值
							session.setAttribute("userinfo",bizs.queryUserInfo(user.getUserid()));
							MSG.put("code","200");
							MSG.put("msg","ok");
						}
						else {
							MSG.put("code","500");
							MSG.put("msg","no");
						}
					}
					else {
						MSG.put("code","500");
						MSG.put("msg","no");
					}
				}
				else {
					MSG.put("code","500");
					MSG.put("msg","no");
				}
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					MSG.put("code","500");
					MSG.put("msg","no");
					e.printStackTrace();
				}
				
			}
			
		return MSG;
		}

		
	//申请管理员介入
	@PutMapping(value="user/admingetinvolved/{orderid}")
	@ResponseBody
	public  Map<String,String>  admingetinvolved(@PathVariable String orderid){
		Map<String,String> MSG=new HashMap<String,String>();
		
		//修改订单状态
		Orders order=new Orders();
		order.setOrderid(orderid);
		order.setRefundstatus(3);//	退款状态(1退款申请中2不同意3申请管理员介入4管理员拒绝5退款完成6退款取消)
		if(biz.updateOrderstatus(order)) {
			
			//修改退款状态
			Refund refund=new Refund();
			refund.setOrderid(orderid);
			refund.setPoint(2);//1：商家，2：管理员
			refund.setAdminstatus(1);//管理员审核状态(1待审核2审核成功3未通过)
			biz.updateRefund(refund);
			MSG.put("code","200");
			MSG.put("msg","ok");
		}
		else {
			MSG.put("code","500");
			MSG.put("msg","no");
		}
		return MSG;
	}
}
