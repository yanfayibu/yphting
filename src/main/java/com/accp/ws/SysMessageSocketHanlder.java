package com.accp.ws;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.accp.biz.lz.UserBiz;
import com.accp.pojo.User;
import com.accp.ws.cfg.HttpSessionConfigurator;

@ServerEndpoint(value = "/ws/sys", configurator =HttpSessionConfigurator.class )
@Component
public class SysMessageSocketHanlder {

	private final static Map<Object, Session> usersMap = new ConcurrentHashMap<Object, Session>();

	public static ApplicationContext ac;// 非常重要

	private int userid;

	@OnOpen
	public void onopen(Session session, EndpointConfig config) {
		UserBiz biz=(UserBiz) ac.getBean("userbiz");
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		final int userid =((User) httpSession.getAttribute("userinfo")).getUserid();
		this.userid = userid;
		usersMap.put(this.userid, session);// 存入会话信息
		// 最新消息推送功能
		new Thread() {
			public void run() {
				//初始数量
				int countInit =biz.QueryLotteryrecord().size();
				while (true) {
					try {
						session.getBasicRemote().sendText("pong");
						Thread.sleep(1000);
						int count = biz.QueryLotteryrecord().size();
						if (count > countInit) {
							session.getBasicRemote().sendText("reload");
							countInit = count;
						}
					} catch (Exception e) {
						System.out.println("任务推送失败");
						break;
					}
				}
			}
		}.start();
	}

	/**
	 * 
	 * @title: sendAllUsers
	 * @description: Map模式群发
	 * @param msg
	 */
	private void sendAllUsers(String msg) throws Exception {
		for (Object key : usersMap.keySet()) {
			try {
				usersMap.get(key).getBasicRemote().sendText(msg);
			} catch (IOException e) {
				continue;
			}
		}
	}

	@OnClose
	public void onclose(Session session) {
		usersMap.remove(this.userid);
	}

	@OnError
	public void onerror(Session session, Throwable ex) {
		usersMap.remove(this.userid);
	}

	@OnMessage
	public void onmessage(String msg, Session session) {

	}
}
