package com.accp.action.zrb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.zrb.PrestigeBiz;

@Controller
@RequestMapping("/c/prestige")
public class PrestigeAction {
	
	@Autowired
	private PrestigeBiz biz;

	

}
