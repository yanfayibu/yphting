package com.accp.biz.smy;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.smy.ServicesDao;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Advertisementapply;
import com.accp.pojo.Star;
import com.accp.pojo.StarApply;
import com.accp.vo.smy.AppraisalApply;
import com.accp.vo.smy.EvaluationVo;
import com.accp.vo.smy.Goldnotes;
import com.accp.vo.smy.LanguageType;
import com.accp.vo.smy.Level;
import com.accp.vo.smy.MajorType;
import com.accp.vo.smy.Order;
import com.accp.vo.smy.OrderInfoVo;
import com.accp.vo.smy.Orders;
import com.accp.vo.smy.RefundVO;
import com.accp.vo.smy.ServiceType;
import com.accp.vo.smy.Services;
import com.accp.vo.smy.ServicesLevel;
import com.accp.vo.smy.ShArea;
import com.accp.vo.smy.User;
import com.accp.vo.smy.UserAppVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;





@Service
public class ServicesBiz {
	
	@Autowired
	private ServicesDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addService(Services service) {
		Integer count = dao.addService(service);
		return count;
	}
	public List<ServiceType> queryServiceType(Integer stpid,Integer selectNum){
		return dao.queryServiceType(stpid, selectNum);
	}
	public List<LanguageType> queryLanguagetype(){
		return dao.queryLanguagetype();
	}
	public List<MajorType> queryMajortype(){
		return dao.queryMajortype();
	}
	public List<ShArea> querySharea(Integer pid,boolean flag){
		return dao.querySharea(pid,flag);
	}
	public float queryBond() {
		return dao.queryBond();
	}
	public User UserID(Integer userID) {
		return dao.queryUser(userID);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int merchantMove(User user,float bond) {
		return dao.merchantMove(user,bond);
	}
	public PageInfo<OrderInfoVo> queryUserOrder(Integer userID,Integer orderStatus,Integer refundstatus,String orderID,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<OrderInfoVo>(dao.queryUserOrder(userID, orderStatus, refundstatus, orderID));
	}
	public ServiceType querySerType(Integer stid) {
		return dao.querySerType(stid);
	}
	public List<Orders> queryCountOrder(Integer userID){
		return dao.queryCountOrder(userID);
	}
	public OrderInfoVo queryAOrder(String orderID) {
		return dao.queryAOrder(orderID);
	}
	public int updateOrdersStatus(Integer orderStatus,String orderID) {
		return dao.updateOrdersStatus(orderStatus, orderID);
	}
	public PageInfo<Services> queryServiceAndByTitle(Integer userID,String serviceTitle,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Services>(dao.queryServiceAndByTitle(userID, serviceTitle));
	}
	public PageInfo<Services> queryService(Integer userID,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Services>(dao.queryServiceAndByTitle(userID, null));
	}
	public Services queryService(Integer serviceID) {
		return dao.queryService(serviceID);
	}
//	public User queryUserById(Integer userID) {
//		return dao.queryUserById(userID);
//	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateService(Services services) {
		return dao.updateService(services);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteService(Integer serviceID) {
		return dao.deleteService(serviceID);
	}
	public List<UserAppVo> queryAppraisalapply(Integer userID,Integer oneid,Integer twoid){
		return dao.queryAppraisalapply(userID, oneid, twoid);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addAppraisalapply(AppraisalApply app) {
		return dao.addAppraisalapply(app);
	}
	public PageInfo<EvaluationVo> queryEvaluation(Integer pageNum,Integer pageSize,Integer userID){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<EvaluationVo>(dao.queryEvaluation(userID));
	}
	public AppraisalApply queryAppraisal(Integer applyID) {
		return dao.queryAppraisal(applyID);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateAppraisalApply(AppraisalApply app) {
		return dao.updateAppraisalApply(app);
	}
	public Order queryOrderById(String orderid) {
		return dao.queryOrderById(orderid);
	}
	public RefundVO queryRefundByOrderId(String orderID) {
		return dao.queryRefundByOrderId(orderID);
	}
	public PageInfo<RefundVO> queryRefundList(Integer userid, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<RefundVO>(dao.queryRefundList(userid));
	}
	public int saveGoldNotes(Integer userID,Integer acquisitionMode,String recordDescribe,float recordInAndOut,Integer auditStatus) {
		return dao.saveGoldNotes(userID, acquisitionMode, recordDescribe, recordInAndOut, auditStatus);
	}
	public boolean saveSystemMSG(Integer userID,String content) {
		return dao.saveSystemMSG(userID, content)>0;
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean refundNo(Orders order, RefundVO refund) {
		dao.saveSystemMSG(dao.queryOrderById(order.getOrderID()).getUserID(), "卖家拒绝退款，订单：" + order.getOrderID());
		dao.updateOrder(order);
		return dao.updateRefund(refund);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public boolean refundOk(Order orderInfo, Order order, RefundVO refund) {
		Integer buyer = orderInfo.getUserID();
		Integer seller = orderInfo.getService().getUser().getUserID();
		Float money = dao.queryRefundByOrderId(order.getOrderID()).getApplyRefundMoney();
		dao.saveSystemMSG(buyer, "卖家同意退款，订单：" + order.getOrderID());
		Goldnotes goldnotes = new Goldnotes();
		goldnotes.setUserID(buyer);
		goldnotes.setAcquisitionMode(4);
		goldnotes.setRecordDate(new Date());
		goldnotes.setRecordDescribe("订单退款：" + order.getOrderID());
		goldnotes.setRecordInAndOut((float) money);
		goldnotes.setAuditStatus(2);
		dao.addGoldnotes(goldnotes);
		Goldnotes goldnotes1 = new Goldnotes();
		goldnotes1.setUserID(seller);
		goldnotes1.setAcquisitionMode(4);
		goldnotes1.setRecordDate(new Date());
		goldnotes1.setRecordDescribe("订单退款：" + order.getOrderID());
		goldnotes1.setRecordInAndOut((float) (-money * 0.9));
		goldnotes1.setAuditStatus(2);
		dao.addGoldnotes(goldnotes1);
		refund.setActualRefundMoney(money);
		dao.updateUserMoney(money, buyer);
		dao.updateUserMoney((float) (-money * 0.9), seller);
//		System.out.println(money+"***"+buyer);
//		return true;
		dao.updateOrder(order);
		return dao.updateRefund(refund);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addMerchantsEvaluation(Integer serviceID,Integer userID,Integer PID,String serviceContent) {
		return dao.addMerchantsEvaluation(serviceID, userID, PID,serviceContent);
	}
	public List<ServicesLevel> querySerlevelName(Integer userID) {
		return dao.querySerlevelName(userID);
	}
	public Level queryLevel(Integer userID) {
		return dao.queryLevel(userID);
	}
	public List<Star> queryStar(Integer stid){
		return dao.queryStar(stid);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addStarApply(StarApply starApply) {
		return dao.addStarApply(starApply);
	}
	public Star queryPrice(Integer sid){
		return dao.queryPrice(sid);
	}
	
	
	
	
	
	public int selectOrderScore(Integer userId) {
		return dao.selectOrderScore(userId);
	}
	public int selectMoneyScore(Integer userId) {
		return dao.selectMoneyScore(userId);
	}
	public int selectCollectCountScore(Integer userId) {
		return dao.selectCollectCountScore(userId);
	}
	public int selectGoodScore(Integer userId) {
		return dao.selectGoodScore(userId);
	}
	public int selectMerchantLevelScore(Integer userId) {
		return dao.selectMerchantLevelScore(userId);
	}
	public Advertisement queryAimgpath() {
		return dao.queryAimgpath();
	}
}
