package com.accp.action.asp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.action.config.AlipayConfig;
import com.accp.biz.lz.UserBiz;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.User;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

@Controller
@RequestMapping("/api")
public class AlipayAction {// response
	@Autowired
	private UserBiz biz;
	@RequestMapping("viewOrder")
	public void viewOrder(HttpSession session,HttpServletRequest req, Model mod, HttpServletResponse rep,Goldnotes goldnotes) throws AlipayApiException, IOException {
		User user=(User) session.getAttribute("userinfo");
	
		/*//获得初始化的AlipayClient
		goldnotes.setAuditstatus(4);//	审核状态(1待审核2审核成功3未通过4代付款)
		goldnotes.setUserid(user.getUserid());
		goldnotes.setRecorddate(new Date());
		goldnotes.setAcquisitionmode(5);//(1预定服务2服务收益3取消物流订单4其他5充值6线下充值7退款8提现)
		goldnotes.setRecorddescribe("充值金币");
		biz.addGoldRecording(goldnotes);*/
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		
	//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no ="201905020219996";
		//付款金额，必填
		String total_amount =goldnotes.getRecordinandout().toString();
		//订单名称，必填
	    String subject ="韩汀金币充值";
		//商品描述，可空
		String body ="";
		
		
		
		System.out.println("充值金额"+goldnotes.getRecordinandout());
		
		

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		String result = alipayClient.pageExecute(alipayRequest).getBody();
		rep.setContentType("text/html;charset=" + AlipayConfig.charset);
		rep.getWriter().write(result);// 直接将完整的表单html输出到页面
		rep.getWriter().flush();
		rep.getWriter().close();
		//输出
	}
	
	
	@RequestMapping("return_url")
	public String returnUrl( HttpSession session,HttpServletRequest request, HttpServletResponse response)
			throws AlipayApiException, UnsupportedEncodingException {
		User user=(User) session.getAttribute("userinfo");
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no =new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
		
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//			request.setAttribute("out_trade_no", out_trade_no);
//			request.setAttribute("trade_no", trade_no);
//			request.setAttribute("total_amount", total_amount);
//            Float mount=Float.parseFloat(total_amount);
//			//biz.updateUserToGoldnotes(mount,out_trade_no,userId,4);
		}else {
			request.setAttribute("reason", "验签失败");
		}
		request.setAttribute("signVerified", signVerified);
		return "redirect:/api/Forward_view/user/goldcoinrecord";
	}
	
	
	

	@RequestMapping("notify_url")
	public String notifyUrl(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws AlipayApiException, UnsupportedEncodingException {
		User user=(User) session.getAttribute("userinfo");
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr =  new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			
			
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			request.setAttribute("out_trade_no", out_trade_no);
			request.setAttribute("trade_no", trade_no);
			request.setAttribute("total_amount", total_amount);
			
			System.out.println("充值金额："+total_amount);
			//修改用户金币
			User u=new User();
			u.setUserid(user.getUserid());
			u.setUsermoney(user.getUsermoney()+Float.parseFloat(total_amount));
			biz.UpdateAmountofpoints(u);
			
		}else {//验证失败
			request.setAttribute("reason", "验签失败");
		}
		return "notify_url";
	}
}
