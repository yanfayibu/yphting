
package com.accp.action.lz;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.lz.OrderBiz;
import com.accp.biz.lz.UserBiz;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Login;
import com.accp.pojo.News;
import com.accp.pojo.Orders;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.util.MD5Signature;
import com.accp.util.file.Upload;
import com.accp.vo.lz.EvaluationVO;
import com.accp.vo.lz.NewVO;
import com.github.pagehelper.PageInfo;

/**   
 * @ClassName:  UserAction   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: litchi
 * @date:   2019年2月19日 下午6:54:55   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */

@Controller
@RequestMapping("/c/lz")
public class UserAction {

	
	@Autowired
	private UserBiz biz;
	@Autowired
	private OrderBiz bizs;
	
	
	
	
	//change Password
	@PutMapping(value="/user/update/{oldpwd}/{password}")
	@ResponseBody
	public  Map<String, String> updatePwd(@PathVariable String oldpwd, @PathVariable String password){
		Map<String, String> message=new HashMap<String,String>();
		//获取登录的邮箱账号
		try {
			
			if(oldpwd.equals("undefined")) {
				//MD5密码加密
				biz.updatePwd("1154044031@qq.com",MD5Signature.md5(password));
				message.put("code", "200");
				message.put("msg", "ok");
			}
			else {
				
				Login login=new Login();
				//读取登录用户邮箱
				login.setUseremail("1154044031@qq.com");
				login.setUserpwd(MD5Signature.md5(oldpwd));
				System.out.println("旧密码"+oldpwd);
				if(biz.queryLoginInfo(login)==null)
				{
					message.put("code", "202");
					message.put("msg", "no");
				}
				else {
					//MD5密码加密
					biz.updatePwd("1154044031@qq.com",MD5Signature.md5(password));
					message.put("code", "200");
					message.put("msg", "ok");
				}
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.put("code", "500");
			message.put("msg", "on");
		}
		return message;
	}
	
	//查询地址
	@RequestMapping(value="/user/querySharea",method=RequestMethod.GET)
	@ResponseBody
	public List<Sharea> querySharea(){
		return biz.Queryarea();
	}
	
	//查询邮箱是否注册过
	@RequestMapping(value="/user/queryvftemail/{email}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> verificationEmail(@PathVariable String email){
		Map<String, String> message=new HashMap<String,String>();
		
		Login login=new Login(email);
		Login lg=biz.queryLoginInfo(login);
		if(lg==null) {
			message.put("code", "200");
			message.put("msg", "ok");
		}
		else {
			message.put("code", "500");
			message.put("msg", "no");
		}
		return message;
	}
	
	
	
	//修改账户信息
	@RequestMapping(value="/user/updateUserInfo",method=RequestMethod.POST)
	public String updateUserInfo(HttpSession session,User u,Login login,Model model){
			
		try {
			
			System.out.println("邮箱："+login.getUseremail());
			if(login.getUseremail()!=null) {
				
				//修改邮箱信息
				login.setUserid(26);
				biz.updateLoginEmail(login);
			}
			//读取Seesion
			u.setUserid(26);
			//修改用户信息
			biz.updateUser(u);
			
			
			session.setAttribute("msg", "个人资料修改成功");
			
			//刷新用户信息
			session.setAttribute("userinfo",biz.queryUserInfo(26));
			return "redirect:/api/Forward_view/user/notification";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//修改用户图片
	@RequestMapping(value="/user/updateUserImg",method=RequestMethod.POST)
	public String updateUserImg(HttpSession session,@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
					
				try {
					
					//获取文件
					String url = Upload.uploadFile(file);
					//读取session
					User user=new User();
					user.setUserid(26);
					user.setUserimgpath(url);
					try {
						//执行
						biz.updateUser(user);
						//刷新图片数据
						session.setAttribute("userinfo",biz.queryUserInfo(26));
						
						//等待项目图片上传延迟
						Thread.sleep(500);
						
						return "redirect:/api/Forward_view/user/Modifydata";
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		return  null;
	}
	
	//查询站内外消息
	@ResponseBody
	@RequestMapping(value="user/searchNewpage/{type}/{pageNum}/{pageSize}",method=RequestMethod.GET)
	public PageInfo<NewVO> searchNewPage(@PathVariable Integer type,@PathVariable Integer pageNum,@PathVariable Integer pageSize ) {
		
		//读取已登录的用户id
		
		return biz.searchNew(type,24, pageNum, pageSize);
	}
	
	
	//删除消息
	@DeleteMapping(value="/user/meassage/del/{id}")
	@ResponseBody
	public  Map<String, String> delmeassge(@PathVariable String id){
		Map<String, String> message=new HashMap<String,String>();
		try {
			String arr[]=id.split(",");
			for (int i = 0; i < arr.length; i++) {
			biz.delmeassge(Integer.parseInt(arr[i]));
				System.out.println("id"+arr[i]);
			}	

			message.put("code", "200");
			message.put("msg", "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message.put("code", "500");
			message.put("msg", "on");
			e.printStackTrace();
		}
		
		return message;
	}
	
	
	//置为已读消息
		@PutMapping(value="/user/meassage/read/{id}")
		@ResponseBody
		public  Map<String, String> updatemessages(@PathVariable String id){
			Map<String, String> message=new HashMap<String,String>();
			try {
				String arr[]=id.split(",");
				for (int i = 0; i < arr.length; i++) {
					biz.updatemessages(new NewVO(Integer.parseInt(arr[i])));
					System.out.println("id"+arr[i]);
				}			
				message.put("code", "200");
				message.put("msg", "on");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				message.put("code", "500");
				message.put("msg", "on");
				e.printStackTrace();
			}
			
			return message;
		}
	
		//查询站内外消息
		@ResponseBody
		@RequestMapping(value="user/Queryzndetails/{messageGroup}/{pageNum}/{pageSize}",method=RequestMethod.GET)
		public PageInfo<NewVO> Queryzndetails(@PathVariable Integer messageGroup,@PathVariable Integer pageNum,@PathVariable Integer pageSize ) {
			return biz.Queryzndetails(messageGroup, pageNum, pageSize);
		}
		
		
		
		//新增站内信
		@RequestMapping(value="/user/Addnews",method=RequestMethod.POST)
		@ResponseBody
		public Map<String, String> Addnews(HttpSession session,@RequestBody News news) {
			Map<String, String> message=new HashMap<String,String>();
			
			//站内未读
			session.setAttribute("instationunread",biz.Queryunreadinformation(new News(24,2)));
			//读取登录用户
			news.setThesender(24);
			news.setReadstate(false);
				if(biz.Addnews(news)) {
					message.put("code", "200");
					message.put("msg", "ok");
				}
				else {
					message.put("code", "500");
					message.put("msg", "on");
				}
					
				
				return message;
			
		}
		
		
		//修改店铺信息
		@RequestMapping(value="/user/updateshop",method=RequestMethod.POST)
		@ResponseBody
		public Map<String, String> updateshop(HttpSession session,@RequestBody User u) {
			Map<String, String> message=new HashMap<String,String>();
			//读取登录用户
			User user=(User) session.getAttribute("userinfo");
			Integer userid=user.getUserid();
			u.setUserid(userid);
				if(biz.updateUserShop(u)) {
					message.put("code", "200");
					message.put("msg", "ok");
					session.setAttribute("userinfo",biz.queryUserInfo(userid));
				}
				else {
					message.put("code", "500");
					message.put("msg", "on");
				}
					
				
				return message;
			
		}
		
		
		
		//预定支付
		@RequestMapping(value="/user/updateamount",method=RequestMethod.PUT)
		@ResponseBody
		public Map<String, String> UpdateAmountofpoints(HttpSession session,@RequestBody User u) {
			Map<String, String> message=new HashMap<String,String>();
		System.out.println("订单编号："+u.getReason());
					
		//读取登录用户
		User user=(User) session.getAttribute("userinfo");
		
		if(user.getUsermoney()>=u.getUsermoney())
		{
			//计算价格
			Float money=user.getUsermoney()-u.getUsermoney();
			u.setUsermoney(money);//重新计算
			//用户id
			Integer userid=user.getUserid();
			u.setUserid(userid);
			if(biz.UpdateAmountofpoints(u)) {
				
				Goldnotes gold=new Goldnotes();
				gold.setUserid(userid);//用户编号
				gold.setAcquisitionmode(1);//(1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)
				gold.setRecorddescribe("支付订单，订单号："+u.getReason());//记录描述
				gold.setRecordinandout(-u.getUsermoney());//	记录收入，支出
				gold.setAuditstatus(2);//审核状态(1待审核2审核成功3未通过)
				//新增金币支付记录
				if(biz.addGoldRecording(gold)) {
					//重新赋值
					session.setAttribute("userinfo",biz.queryUserInfo(userid));
					
					//修改订单状态o
					Orders o=new Orders();
					//获取订单编号
					o.setOrderid(u.getReason());
					//待接单
					o.setOrderstatus(2);
					bizs.updateOrderstatus(o);
					
					
					message.put("code", "200");
					message.put("msg", "ok");
					
				}
				else {
					message.put("code", "500");
					message.put("msg", "on");
				}
			}
			else {
				message.put("code", "500");
				message.put("msg", "on");
			}
			
		}
		else {
			message.put("code", "501");
			message.put("msg", "on");
		}
		
				return message;
			
		}
		
		//查询用户金币记录
		@RequestMapping(value="/user/querygoldpage/{acquisitionmode}/{start}/{end}/{pageNum}",method=RequestMethod.GET)
		@ResponseBody
		public PageInfo<Goldnotes> QueryGoldPage (@PathVariable int acquisitionmode,@PathVariable String start ,@PathVariable String end,@PathVariable Integer pageNum) {
			//读取登录用户
			return  biz.QueryGold(25, acquisitionmode, start, end, pageNum, 5);
		}
	
		//查询用户积分记录
		@RequestMapping(value="/user/queryintegralpage/{start}/{end}/{pageNum}",method=RequestMethod.GET)
		@ResponseBody
		public PageInfo<Integralrecord> QueryIntegral (@PathVariable String start ,@PathVariable String end,@PathVariable Integer pageNum) {
			//读取登录用户
			return  biz.QueryIntegral(25, start, end, pageNum, 5);
				}
		
		//查询我的评价以及商家回复评价
		@RequestMapping(value="/user/Querymyreview/{pageNum}",method=RequestMethod.GET)
		@ResponseBody
		public PageInfo<EvaluationVO> Querymyreview (@PathVariable Integer pageNum) {
		//读取登录用户
		return  biz.Querymyreview(25, pageNum, 3);
		}
		
		
		//查询是否签到过
		@GetMapping("/user/Querysignin")
		@ResponseBody
		public  Map<String, String> Querysignin(HttpSession session){
		Map<String, String> msg=new HashMap<String, String>(); 
		
		//读取登录用户
		User user=(User) session.getAttribute("userinfo");
		Date date=biz.Querysignin(user.getUserid());
		if(date==null) {
			msg.put("code", "200");
			msg.put("msg", "ok");
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//读取数据库的日期
			String sqldate = sdf.format(date);
			System.out.println("数据库最新的签到日期："+sqldate);
		
			//当前系统时间
			Date thistime=new Date();
			System.out.println("当前日期："+sdf.format(thistime));
			
			//如果两个日期相等说明已经签到过了
			if(sqldate.equals(sdf.format(thistime))) {
				msg.put("code", "500");
				msg.put("msg", "no");
			}
			else {
				msg.put("code", "200");
				msg.put("msg", "ok");
			}
			
			
		}
		return msg;
		}
		
		//签到
		@PostMapping("/user/addsignin")
		@ResponseBody
		public  Map<String, String> Addsignin(HttpSession session){
		Map<String, String> msg=new HashMap<String, String>(); 
		//读取登录用户
		User user=(User) session.getAttribute("userinfo");
		//可以签到添加积分记录
		Integralrecord integra=new Integralrecord();
		integra.setUserid(user.getUserid());
		integra.setIrdescribe("签到");
		integra.setAuditstatus(2);//	审核状态(1待审核2审核成功3未通过)
		integra.setRecordinandout(+10);//签到加多少积分根据系统的配置我先写死的默认+10
		if(biz.addIntegralRecording(integra)) {
			//修改用户的账户积分
			User u =new User();
			u.setUserid(user.getUserid());
			u.setUserintegral(user.getUserintegral()+10);//登录用户+10积分
			if(biz.UpdateAmountofpoints(u)) {
				//重新赋值
				session.setAttribute("userinfo",biz.queryUserInfo(user.getUserid()));
				msg.put("code", "200");
				msg.put("msg", "ok");
			}
			else {
				msg.put("code", "500");
				msg.put("msg", "on");
			}
		}
		else {
			msg.put("code", "500");
			msg.put("msg", "no");
		}
		return msg;
		}
}
