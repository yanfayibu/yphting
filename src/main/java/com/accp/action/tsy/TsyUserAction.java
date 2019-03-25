package com.accp.action.tsy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.tsy.TsyUserBiz;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.util.MD5Signature;
import com.accp.util.code.VerifyCode;
import com.accp.util.email.Email;
import com.accp.util.email.EmailBoard;
import com.accp.util.file.Upload;
import com.accp.util.rsaKey.RSAUtils;
import com.accp.vo.tsy.ListVo;
import com.accp.vo.tsy.TimeOutEmailDateVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/tsy")
public class TsyUserAction {
	
	@Autowired
	private TsyUserBiz biz;
	
	@GetMapping("gologin")
	public String gologin() {
		return "/tsy/szy-login";
	}
	
	@GetMapping("gozuce")
	public String gozuce() {
		return "/tsy/szy-zuce";
	}
	
	/**
	 * 验证账号
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/user/yzEmail",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> queryEmail(String email){
		Map<String,String> map=new HashMap<>();
		System.out.println("执行邮箱验证");
		try {
			if(biz.queryEmail(email)) {
				map.put("code", "200");
			}else {
				map.put("code", "500");
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		}
		return map;
	}
	/**
	 * 邮箱注册
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/user/gotoLogin",method=RequestMethod.POST)
	public String gotoLogin(Model model,String email,String username) {
		System.out.println(email+"-----"+username+"----");
		try {
			//生成安全码
			String codeId=VerifyCode.createVerifyCode(8);
			if(ListVo.emailList.get(email)==null) {
				ListVo.emailList.put(email,new TimeOutEmailDateVo(email, codeId, new Date()));
			}else {
				ListVo.emailList.get(email).setTime(new Date());
				ListVo.emailList.get(email).setCodeId(codeId);
			}
			
			System.out.println("执行Email新增=========");
			Email.sendSimpleMail(email, "用户注册", EmailBoard.register(username, "http://127.0.0.1:1001/c/tsy/user/emailYanz?email="+email+"&nickName="+username+"&codeId="+codeId));
			System.out.println("====================\n发送成功\n====================\n");
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
			System.out.println("====================\n发送失败\n====================\n");
		}
		model.addAttribute("EMAIL",email.substring(email.indexOf("@")));
		return "/tsy/MSG";
	}
	/**
	 * 激活邮箱
	 * @param model
	 * @param email
	 * @param nickName
	 * @param codeId
	 * @return
	 */
	@RequestMapping(value="/user/emailYanz",method=RequestMethod.GET)
	public String emailYanz(Model model,String email,String nickName,String codeId) {
		if(ListVo.emailList.get(email)==null) {
			return "/tsy/szy-yz-no.html";
		}else {
			if(ListVo.emailList.get(email).getCodeId().trim().equals(codeId.trim())) {
				model.addAttribute("user", new TimeOutEmailDateVo(email,nickName));
				return "/tsy/szy-zuce-yz.html";
			}else {
				return "/tsy/szy-yz-no.html";
			}
		}
	}
	/**
	 * 新增邮箱登陆用户
	 * @param tqedv
	 * @return
	 */
	@RequestMapping(value="/user/saveEmail",method=RequestMethod.POST)
	public String saveEmail(TimeOutEmailDateVo tqedv) {
		
		try {
			tqedv.setPassword(MD5Signature.md5(tqedv.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(biz.saveEmailUser(tqedv)) {
			return "/tsy/szy-login";
		}else{
			return "/tsy/szy-zuce-yz.html";
		}
	}
	/**
	 * 获取公钥
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/user/rsaKey",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> generateRSAKey(String email){
				// 将公钥传到前端
	            Map<String,String> map = new HashMap<String,String>();
		 try {
				// 获取公钥和私钥
				HashMap<String, Object> keys = RSAUtils.getKeys();
	            RSAPublicKey publicKey = (RSAPublicKey) keys.get("public");
	            RSAPrivateKey privateKey = (RSAPrivateKey) keys.get("private");
	            // 保存私钥到 redis，也可以保存到数据库
	            try {
					ListVo.emailService.put(email, privateKey);
				} catch (Exception e) {
					System.out.println("私钥存储失败");
				}
	            // 注意返回modulus和exponent以16为基数的BigInteger的字符串表示形式
	            map.put("modulus", publicKey.getModulus().toString(16));
	            map.put("exponent", publicKey.getPublicExponent().toString(16));
	        } catch (Exception e) {
	        	map.put("msg", e.getMessage());
	        } 
		 return map;
	}
	/**
	 * 解密 登陆方法
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/user/checkRSAKey",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> checkRSAKey(HttpSession session,String email,String password) {
	        Object object = ListVo.emailService.get(email);
	        Map<String,String> map = new HashMap<String,String>();
	        try {
	            // 解密
	        	System.out.println(password);
	            String decryptByPrivateKey = RSAUtils.decryptByPrivateKey(password, (RSAPrivateKey) object);
	            
	            System.out.println(decryptByPrivateKey);
	            User u=biz.login(email,MD5Signature.md5(decryptByPrivateKey));
	    		if(u!=null) {
	    			session.setAttribute("userinfo", u);
	    			session.setAttribute("Email", email);
	    			map.put("code", "200");
	    		}else {
	    			map.put("code", "500");
	    		}
	        } catch (Exception e) {
	            map.put("msg", e.getMessage());
	        }
	        return map;
	 }
	
	/**
	 * 获取当前用户session
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/queryAUser")
	@ResponseBody
	public User queryAUser(HttpSession session) {
		if(session.getAttribute("userinfo")==null) {
			return null;
		}else {
			Integer userID=((User)session.getAttribute("userinfo")).getUserid();
			User u=biz.queryUser(userID);
			session.setAttribute("userinfo", u);
			return u;
		}
	}
		
}
