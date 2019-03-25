package com.accp.dao.tsy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.News;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.vo.tsy.TimeOutEmailDateVo;

public interface TsyUserDao {
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return
	 */
	public Integer queryEmail(@Param("email")String email);
	/**
	 * 使用邮箱注册
	 * @return
	 */
	public int saveEmailUser(@Param("emailDate")TimeOutEmailDateVo emailDate);
	/**
	 * 使用邮箱登陆
	 * @param emailDate
	 * @return
	 */
	public User login(@Param("email")String email,@Param("password")String password);
	/**
	 * 修改邮件登陆密码
	 * @param email
	 * @param password
	 * @return
	 */
	public int updatePwd(@Param("email")String email,@Param("password")String password);
	/**
	 * 查询当前用户
	 * @param userID
	 * @return
	 */
	public User queryUser(@Param("userID")Integer  userID);
	
}
