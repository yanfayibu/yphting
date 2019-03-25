package com.accp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.accp.ws.NewsSocketHander;
import com.accp.ws.SysMessageSocketHanlder;

@SpringBootApplication
public class YphtingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(YphtingApplication.class, args);
		SpringApplication springApplication = new SpringApplication(YphtingApplication.class);  
		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);        
		SysMessageSocketHanlder.ac=configurableApplicationContext;//非常重要
		NewsSocketHander.ac=configurableApplicationContext;//非常重要
	}

}

