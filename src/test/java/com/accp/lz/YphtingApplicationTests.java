package com.accp.lz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accp.biz.lz.UserBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YphtingApplicationTests {

	@Autowired
	private UserBiz biz;
	
	@Test
	public void contextLoads() {
	
		try {
			biz.updatePwd("976906309@qq.com", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

