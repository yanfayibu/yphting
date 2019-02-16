package com.accp.action.lz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/c")
@Controller
public class LZ {

	
	//测试页面
	@RequestMapping("hello")
	public  String  view() {
		return  "/ydk/Html/login";
	}
}
