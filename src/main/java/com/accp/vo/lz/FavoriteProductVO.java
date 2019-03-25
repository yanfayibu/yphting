
package com.accp.vo.lz;

import com.accp.pojo.Servicecollection;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.User;

public class FavoriteProductVO {

	private Servicecollection servicecollection;//收藏
	private Services services;//商品服务
	private User user;//收藏用户
	private Servicetype servicetype;//服务类别
	
	
	/**  
	 * @Title:  getServicecollection <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicecollection <BR>  
	 */
	public Servicecollection getServicecollection() {
		return servicecollection;
	}










	/**  
	 * @Title:  setServicecollection <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicecollection <BR>  
	 */
	public void setServicecollection(Servicecollection servicecollection) {
		this.servicecollection = servicecollection;
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
	 * @Title:  getServicetype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicetype <BR>  
	 */
	public Servicetype getServicetype() {
		return servicetype;
	}










	/**  
	 * @Title:  setServicetype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Servicetype <BR>  
	 */
	public void setServicetype(Servicetype servicetype) {
		this.servicetype = servicetype;
	}










	public FavoriteProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
