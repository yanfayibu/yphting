
package com.accp.vo.lz;

import java.util.Date;

import com.accp.pojo.Orders;
import com.accp.pojo.Services;
import com.accp.pojo.User;

@SuppressWarnings("all")
public class RefundVO {

	private Integer refundid;               //退款编号

	private Integer point;                  //退款申请指向，1：商家，2：管理员

	private Orders order;                 //订单

	private User user;                 //用户
   
	private Services service; //服务
	private User merchant;     //商家
	private String refundimg;               //退款附带图片

	private Float applyrefundmoney;         //申请退款金额

	private Float actualrefundmoney;        //实际退款金额
	
	private Date applicationtime;           //申请时间

	private Date audittime;                 //商家审核时间

	private Integer auditstatus;            //商家审核状态(1待审核2审核成功3未通过)

	private Date admintime;                 //管理员审核时间

	private Integer adminstatus;            //管理员审核状态(1待审核2审核成功3未通过)

	private String refundreason;            //退款原因

	private String refundexplain;           //退款说明

	private String businessremarks;         //商家审核备注

	private String adminremarks;            //管理员审核备注

	/**  
	 * @Title:  getRefundid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getRefundid() {
		return refundid;
	}

	/**  
	 * @Title:  setRefundid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setRefundid(Integer refundid) {
		this.refundid = refundid;
	}

	/**  
	 * @Title:  getPoint <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getPoint() {
		return point;
	}

	/**  
	 * @Title:  setPoint <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**  
	 * @Title:  getOrder <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Orders <BR>  
	 */
	public Orders getOrder() {
		return order;
	}

	/**  
	 * @Title:  setOrder <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Orders <BR>  
	 */
	public void setOrder(Orders order) {
		this.order = order;
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
	 * @Title:  getRefundimg <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getRefundimg() {
		return refundimg;
	}

	/**  
	 * @Title:  setRefundimg <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setRefundimg(String refundimg) {
		this.refundimg = refundimg;
	}

	/**  
	 * @Title:  getApplyrefundmoney <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public Float getApplyrefundmoney() {
		return applyrefundmoney;
	}

	/**  
	 * @Title:  setApplyrefundmoney <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public void setApplyrefundmoney(Float applyrefundmoney) {
		this.applyrefundmoney = applyrefundmoney;
	}

	/**  
	 * @Title:  getActualrefundmoney <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public Float getActualrefundmoney() {
		return actualrefundmoney;
	}

	/**  
	 * @Title:  setActualrefundmoney <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Float <BR>  
	 */
	public void setActualrefundmoney(Float actualrefundmoney) {
		this.actualrefundmoney = actualrefundmoney;
	}

	/**  
	 * @Title:  getApplicationtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getApplicationtime() {
		return applicationtime;
	}

	/**  
	 * @Title:  setApplicationtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}

	/**  
	 * @Title:  getAudittime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getAudittime() {
		return audittime;
	}

	/**  
	 * @Title:  setAudittime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	/**  
	 * @Title:  getAuditstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getAuditstatus() {
		return auditstatus;
	}

	/**  
	 * @Title:  setAuditstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}

	/**  
	 * @Title:  getAdmintime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getAdmintime() {
		return admintime;
	}

	/**  
	 * @Title:  setAdmintime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setAdmintime(Date admintime) {
		this.admintime = admintime;
	}

	/**  
	 * @Title:  getAdminstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getAdminstatus() {
		return adminstatus;
	}

	/**  
	 * @Title:  setAdminstatus <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setAdminstatus(Integer adminstatus) {
		this.adminstatus = adminstatus;
	}

	/**  
	 * @Title:  getRefundreason <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getRefundreason() {
		return refundreason;
	}

	/**  
	 * @Title:  setRefundreason <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setRefundreason(String refundreason) {
		this.refundreason = refundreason;
	}

	/**  
	 * @Title:  getRefundexplain <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getRefundexplain() {
		return refundexplain;
	}

	/**  
	 * @Title:  setRefundexplain <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setRefundexplain(String refundexplain) {
		this.refundexplain = refundexplain;
	}

	/**  
	 * @Title:  getBusinessremarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getBusinessremarks() {
		return businessremarks;
	}

	/**  
	 * @Title:  setBusinessremarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setBusinessremarks(String businessremarks) {
		this.businessremarks = businessremarks;
	}

	/**  
	 * @Title:  getAdminremarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getAdminremarks() {
		return adminremarks;
	}

	/**  
	 * @Title:  setAdminremarks <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setAdminremarks(String adminremarks) {
		this.adminremarks = adminremarks;
	}

	
	/**  
	 * @Title:  getMerchant <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getMerchant() {
		return merchant;
	}

	/**  
	 * @Title:  setMerchant <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setMerchant(User merchant) {
		this.merchant = merchant;
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
	 * @Title:  RefundVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public RefundVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
