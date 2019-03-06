
package com.accp.vo.lz;

import java.util.Date;

import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Services;
import com.accp.pojo.User;
import com.alibaba.fastjson.annotation.JSONField;


@SuppressWarnings("all")
public class EvaluationVO {
	
	private Integer serviceappraiseid;           //服务评价编号

	private String serviceappraisecontent;       //内容

	private Date serviceappraisedate;            //评价时间

	private Integer serviceappraiselevel;        //星级

	private Integer serviceappraisepid;          //上级编号，0：表示评价，其他：回复评价

    private Services service;                   //服务

    private User user;                      //用户
    private Evaluationservice evalua;//商家回复信息
	/**  
	 * @Title:  getServiceappraiseid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getServiceappraiseid() {
		return serviceappraiseid;
	}
	/**  
	 * @Title:  setServiceappraiseid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setServiceappraiseid(Integer serviceappraiseid) {
		this.serviceappraiseid = serviceappraiseid;
	}
	/**  
	 * @Title:  getServiceappraisecontent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getServiceappraisecontent() {
		return serviceappraisecontent;
	}
	/**  
	 * @Title:  setServiceappraisecontent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setServiceappraisecontent(String serviceappraisecontent) {
		this.serviceappraisecontent = serviceappraisecontent;
	}
	/**  
	 * @Title:  getServiceappraisedate <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getServiceappraisedate() {
		return serviceappraisedate;
	}
	/**  
	 * @Title:  setServiceappraisedate <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setServiceappraisedate(Date serviceappraisedate) {
		this.serviceappraisedate = serviceappraisedate;
	}
	/**  
	 * @Title:  getServiceappraiselevel <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getServiceappraiselevel() {
		return serviceappraiselevel;
	}
	/**  
	 * @Title:  setServiceappraiselevel <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setServiceappraiselevel(Integer serviceappraiselevel) {
		this.serviceappraiselevel = serviceappraiselevel;
	}
	/**  
	 * @Title:  getServiceappraisepid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getServiceappraisepid() {
		return serviceappraisepid;
	}
	/**  
	 * @Title:  setServiceappraisepid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setServiceappraisepid(Integer serviceappraisepid) {
		this.serviceappraisepid = serviceappraisepid;
	}
	/**  
	 * @Title:  getService <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public Services getService() {
		return service;
	}
	/**  
	 * @Title:  setService <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Services <BR>  
	 */
	public void setService(Services service) {
		this.service = service;
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
	 * @Title:  getEvalua <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Evaluationservice <BR>  
	 */
	public Evaluationservice getEvalua() {
		return evalua;
	}
	/**  
	 * @Title:  setEvalua <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Evaluationservice <BR>  
	 */
	public void setEvalua(Evaluationservice evalua) {
		this.evalua = evalua;
	}
	/**   
	 * @Title:  EvaluationVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public EvaluationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
