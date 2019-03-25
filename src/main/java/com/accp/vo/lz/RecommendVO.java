
package com.accp.vo.lz;

import com.accp.pojo.Services;
import com.accp.pojo.User;

//服务推荐
public class RecommendVO {

	
	private User user;//推荐商家
	private Services  services;//推荐服务
	/**  
	 * @Title:  getUser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getUser() {
		return user;
	}
	/**  
	 * @Title:  setUser <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**  
	 * @Title:  getServices <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public Services getServices() {
		return services;
	}
	/**  
	 * @Title:  setServices <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public void setServices(Services services) {
		this.services = services;
	}
	/**   
	 * @Title:  RecommendVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public RecommendVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
