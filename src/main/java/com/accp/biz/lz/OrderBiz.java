
package com.accp.biz.lz;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.lz.IOrderDao;
import com.accp.pojo.Banktype;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Orders;
import com.accp.pojo.Putforward;
import com.accp.pojo.Putforwardrecord;
import com.accp.pojo.Refund;
import com.accp.vo.lz.EvaluationVO;
import com.accp.vo.lz.OrderVO;
import com.accp.vo.lz.RefundVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
@SuppressWarnings("all")
public class OrderBiz {

	@Autowired
	private  IOrderDao dao;
	
	//查询我的预定服务
	public  PageInfo<OrderVO> queryMyreservationservice(Integer pageNum,Integer pageSize,OrderVO ordervo) {
		PageHelper.startPage(pageNum, pageSize);
		return  new PageInfo<OrderVO>(dao.queryMyreservationservice(ordervo));
		
	}
	
	//查询订单状态数量
	public int  querystuats (OrderVO ordervo){
		return dao.queryMyreservationservice(ordervo).size();
	}
	
	//查询我的预定详细信息
	public  List<OrderVO> queryBookingdetails(OrderVO ordervo){
		return dao.queryMyreservationservice(ordervo);
	}
	
	
	//发表评价
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  boolean  addEvaluation(Evaluationservice evalua) {
		return  dao.addEvaluation(evalua)>0;
	}
	
	
	//修改订单状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  boolean updateOrderstatus(Orders order) {
		return  dao.updateOrderstatus(order)>0;
	}
	
	//查询我的退款
	public PageInfo<RefundVO> queryMyrefund(int pageNum,int pageSize,int userid,String orderid,String start,String end){
	PageHelper.startPage(pageNum, pageSize);
	return new PageInfo<RefundVO>(dao.queryMyrefund(userid, orderid, start, end));
	}
	
	//查询我的退款详细
	public  List<RefundVO> queryMyrefundDetailed(int userid,String orderid,String start,String end){
		return dao.queryMyrefund(userid, orderid, start, end);
	}
	
	//新增我的退款
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  boolean addRefund( Refund refund) {
		return  dao.addRefund(refund)>0;
	}
	
	
	//修改退款状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  boolean updateRefund( Refund refund) {
	return  dao.updateRefund(refund)>0;
		}
	
	
	//查询银行类别
	public  List<Banktype> queryBanktype(){
		return dao.queryBanktype();
	}
	
	//添加提现表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public  boolean addwithdraw( Putforward put) {
	return  dao.addwithdraw(put)>0;
	}
	
	//添加提现记录表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
		public  void addwithdrawrecord( Putforwardrecord put)throws Exception {
			dao.addwithdrawrecord(put);
			}
	
	
}
