package com.accp.action.smy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewAction {
	
	/*@GetMapping("fbfw")
	public String goToLogin() {
		return "/smy/Html/sjzx-fbfw.html";//模板文件名
	}*/

	//商家入驻
	@GetMapping("sjrz")
	public String MerchantsEnter() {
		return "/smy/Html/sjrz-xz.html";
	}
	
	//提交鉴定
	@GetMapping("tjhyfy")
	public String authfy() {
		return "/smy/Html/sjzx-hyfyjd.html";
	}
	
	@GetMapping("tjzjy")
	public String authzjy() {
		return "/smy/Html/sjzx-zjyjd.html";
	}
	
	@GetMapping("tjwzx")
	public String authwzx() {
		return "/smy/Html/sjzx-wzxjd.html";
	}
	
	@GetMapping("tjlxzj")
	public String authlxzj() {
		return "/smy/Html/sjzx-lxzjjd.html";
	}
	
	@GetMapping("tjxxzy")
	public String authxxzy() {
		return "/smy/Html/sjzx-xxzyjd.html";
	}
	
	//发布服务
	@GetMapping("fbzjy")
	public String fbzjy() {
		return "/smy/Html/sjzx-zjyfbfw.html";
	}
	
	@GetMapping("fbwzx")
	public String fbwzx() {
		return "/smy/Html/sjzx-wzxfb.html";
	}
	
	@GetMapping("fblxzj")
	public String fblxzj() {
		return "/smy/Html/sjzx-fbfw.html";
	}
	
	@GetMapping("fbhyfy")
	public String fbhyfy() {
		return "/smy/Html/sjzx-hwfyfb.html";
	}
	
	@GetMapping("fbxxzy")
	public String fbxxzy() {
		return "/smy/Html/sjzx-xxzyfb.html";
	}
	@GetMapping("shzl")
	public String shzl() {
		return "/smy/Html/sjrz-shzl.html";
	}
	@GetMapping("guangao")
	public String guangao() {
		return "/smy/Html/addAdvert.html";
	}
}
