
package com.accp.dao.lz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Banktype;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Orders;
import com.accp.pojo.Putforward;
import com.accp.pojo.Refund;
import com.accp.vo.lz.OrderVO;
import com.accp.vo.lz.RefundVO;

/**   
 * @ClassName:  IOrderDao   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: litchi
 * @date:   2019年2月26日 上午9:06:59   
 *     
 * @Copyright: 2019 www.litchi.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public interface IOrderDao {
	
	
	//Check my reservation service
	public  List<OrderVO> queryMyreservationservice(@Param("ordervo")OrderVO ordervo);

	//Post evaluation
	public  int addEvaluation(@Param("evalua") Evaluationservice evalua);
	//Modify Orderstatus
	public  int updateOrderstatus(@Param("order") Orders order);
	
	//Check my refund list
	public  List<RefundVO> queryMyrefund(@Param("userid")int userid,@Param("orderid")String orderid,@Param("start")String start,@Param("end")String end);
	
	//新增退款
	public  int  addRefund(@Param("refund") Refund refund);
	
	//修改退款状态
	public  int updateRefund(@Param("refund") Refund refund);
	
	//银行类别表
	public  List<Banktype> queryBanktype();
	
	//新增提现表
	public  int addwithdraw(@Param("put") Putforward put);
	
}
