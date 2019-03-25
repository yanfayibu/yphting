package com.accp.biz.tsy;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.tsy.TsyUserDao;
import com.accp.pojo.News;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.vo.tsy.TimeOutEmailDateVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class TsyUserBiz {
	@Autowired
	private TsyUserDao dao;
	
	public boolean queryEmail(String email) {
		/**
		 * 查询的数字返回0代表可新增
		 */
		return dao.queryEmail(email)==0;
	}
	/**
	 * 邮箱用户注册
	 * @param emailDate
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean saveEmailUser(TimeOutEmailDateVo emailDate) {
		return dao.saveEmailUser(emailDate)>=0;
	}
	/**
	 * 邮箱登陆
	 * @param emailDate
	 * @return
	 */
	public User login(String email,String password) {
		return dao.login(email, password);
	}
	/**
	 * 修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean updatePwd(String email,String password){
		return dao.updatePwd(email, password)>0;
	}
	
	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(Integer userID){
		return dao.queryUser(userID);
	}
	
}
