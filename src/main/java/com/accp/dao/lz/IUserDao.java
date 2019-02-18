
package com.accp.dao.lz;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.User;

/**
* @Title: IUserDao.java
* @Package com.accp.dao.lz
* @Description: 用户数据访问
* @author 荔枝
* @date 2019年2月18日
* @version V1.0
*/

public interface IUserDao {

	//Modify user information
	public  int updateUser(@Param("userid") Integer userid,@Param("user") User user );
	//change password
	public  int updatePwd(@Param("userid") Integer userid,@Param("userPwd") String userPwd);
	
}
