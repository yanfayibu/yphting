
package com.accp.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**   
 * @ClassName:  Lotteryrecord   
 * @Description 奖品记录  
 * @author: litchi
 * @date:   2019年3月11日 下午2:08:28   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public class Lotteryrecord {
	
	private  int iotteryrecord;//编号
	private  Date time;//抽奖日期
	private String content;//中奖内容
	private int userid;//抽奖者
	/**  
	 * @Title:  getIotteryrecord <BR>  
	 * @Description: please write your description <BR>  
	 * @return: int <BR>  
	 */
	public int getIotteryrecord() {
		return iotteryrecord;
	}
	/**  
	 * @Title:  setIotteryrecord <BR>  
	 * @Description: please write your description <BR>  
	 * @return: int <BR>  
	 */
	public void setIotteryrecord(int iotteryrecord) {
		this.iotteryrecord = iotteryrecord;
	}
	/**  
	 * @Title:  getTime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getTime() {
		return time;
	}
	/**  
	 * @Title:  setTime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**  
	 * @Title:  getContent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getContent() {
		return content;
	}
	/**  
	 * @Title:  setContent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**  
	 * @Title:  getUserid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: int <BR>  
	 */
	public int getUserid() {
		return userid;
	}
	/**  
	 * @Title:  setUserid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: int <BR>  
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**   
	 * @Title:  Lotteryrecord   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public Lotteryrecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
