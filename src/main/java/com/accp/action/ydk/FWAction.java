package com.accp.action.ydk;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.ydk.MerchantEnterAndServiceBiz;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Complainttype;
import com.accp.pojo.Languagetype;
import com.accp.pojo.Majortype;
import com.accp.pojo.Post;
import com.accp.pojo.Resouroe;
import com.accp.pojo.Rgzn;
import com.accp.pojo.Servicelevel;
import com.accp.pojo.Services;
import com.accp.pojo.Servicetype;
import com.accp.pojo.Sharea;
import com.accp.pojo.User;
import com.accp.util.file.Upload;
import com.accp.vo.ydk.AdvertisementVO;
import com.accp.vo.ydk.Artificiaiintelligence;
import com.accp.vo.ydk.EsLevelVO;
import com.accp.vo.ydk.HomePostVO;
import com.accp.vo.ydk.SameServiceVO;
import com.accp.vo.ydk.SerRecommendVO;
import com.accp.vo.ydk.SerReserveVO;
import com.accp.vo.ydk.ServiceDetailInfo;
import com.accp.vo.ydk.ServiceMerchantInfo;
import com.accp.vo.ydk.ServiceSelect;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/ydk")
public class FWAction {

	@Autowired
	private MerchantEnterAndServiceBiz biz;

	/**
	 * 点击服务跳转对应MVC地址
	 * 
	 * @param htmlUrl
	 *            跳转的网页名称
	 * @param stid
	 *            服务类别编号
	 * @return
	 */
	@GetMapping("serviceUrl")
	public String serviceUrl(String htmlUrl, Integer stid, Model model) {
		// 根据一级服务类别获取子类别
		List<Servicetype> serTypeList;
		if (stid == null) {
			serTypeList = biz.queryServiceType(1, 1);
		} else {
			serTypeList = biz.queryServiceType(stid, 1);
		}
		if (htmlUrl == null) {
			htmlUrl = "fw-zjyTAB";
		}
		// 查询国家
		List<Sharea> countryList = biz.querySharea(null, false);
		// 根据一级服务类别获取级别
		List<Servicelevel> serLevelList = biz.queryServicelevel(null);
		model.addAttribute("countryList", countryList); // 将国家存入request
		model.addAttribute("serTypeList", serTypeList); // 将当前一级服务类别的子类别存入request
		model.addAttribute("serLevelList", serLevelList);// 将当前一级服务类别的级别存入request
		return "/ydk/Html/" + htmlUrl;
	}

	/**
	 * 点击服务详情跳转对应详情MVC地址
	 * 
	 * @param htmlUrl
	 * @param sid
	 * @param uid
	 * @return
	 */
	@GetMapping("serviceDetailUrl")
	public String serviceDetailUrl(Model model, String htmlUrl, Integer sid, Integer uid) {
		// 查询发布服务的商家信息
		ServiceMerchantInfo serMerchantObj = biz.queryServiceMerchantInfo(uid, sid);
		// 查询服务信息
		ServiceDetailInfo serDetailObj = biz.queryServiceDetailInfo(sid);
		serDetailObj.setSerDesList(biz.queryServiceDes(sid));
		// 服务评价星级人数查询
		EsLevelVO esLObj = biz.queryEsLevelVO(sid);
		// 同城服务查询
		List<SameServiceVO> sameserList = biz.querySameServiceVO(sid);
		// 举报原因查询
		List<Complainttype> complainttypeList = biz.queryComplainttype();
		// 更新浏览数
		biz.updateServiceBrowseNumber(sid);
		// 广告查询：未完成
		model.addAttribute("serMerchantObj", serMerchantObj);
		model.addAttribute("serDetailObj", serDetailObj);
		model.addAttribute("esLObj", esLObj);
		model.addAttribute("sameserList", sameserList);
		model.addAttribute("complainttypeList", complainttypeList);
		return "/ydk/Html/" + htmlUrl;
	}

	/**
	 * 根据服务列表条件查询服务
	 * 
	 * @return
	 */
	@GetMapping("api/queryServices")
	@ResponseBody
	public PageInfo queryServices(String objJSON, int num, int size) {
		ServiceSelect obj = JSON.parseObject(objJSON, ServiceSelect.class);
		// 开始时间
		String startDate = obj.getStartDate();
		startDate = startDate != null && startDate != "" ? startDate + " 00:00:00" : null;
		// 结束时间
		String endDate = obj.getEndDate();
		endDate = endDate != null && endDate != "" ? endDate + " 00:00:00" : null;
		obj.setStartDate(startDate);
		obj.setEndDate(endDate);
		return biz.queryServices(obj, num, size);
	}

	/**
	 * 查询城市
	 * 
	 * @param areaid
	 * @return
	 */
	@GetMapping("api/queryCity")
	@ResponseBody
	public List<Sharea> queryCity(Integer areaid) {
		return biz.querySharea(areaid, true);
	}

	/**
	 * 查询对应服务类别下的子类别
	 * 
	 * @param stpid
	 * @return
	 */
	@GetMapping("api/queryServiceTypeChild")
	@ResponseBody
	public List<Servicetype> queryServiceTypeChild(Integer stpid) {
		return biz.queryServiceType(stpid, 1);
	}
	
	/**
	 * 举报商家
	 * @param obj
	 * @return
	 */
	@PostMapping("api/report")
	@ResponseBody
	public Map<String,String> saveServiceReport(HttpSession session,Integer businessID,Integer serviceID,Integer ctID) {
		Map<String,String> message = new HashMap<String,String>();
		User loginUser = (User)session.getAttribute("userinfo");	//登录对象：举报人
		Integer loginUserID = loginUser.getUserid();	//当前举报人用户编号
		if(biz.saveServiceReport(businessID, serviceID, loginUserID, ctID)>0) {
			message.put("code", "200");
			message.put("msg", "举报完成，请等待管理员审核");
		}else {
			message.put("code", "500");
			message.put("msg", "由于未知原因，举报失败！");
		}
		return message;
	}
	
	/**
	 * 收藏服务
	 * @param session
	 * @param sid
	 * @return
	 */
	@GetMapping("api/serviceCollection")
	@ResponseBody
	public Map<String,String> serviceCollection(HttpSession session,Integer sid){
		Map<String,String> message = new HashMap<String,String>();
		User loginUser = (User)session.getAttribute("userinfo");
		Integer uid = loginUser.getUserid();
		if(biz.queryUserSerCollectionCheck(uid, sid)==null) {
			biz.saveSerCollection(uid, sid);
			message.put("code", "200");
			message.put("msg", "已收藏");
		}else {
			biz.deleteSerCollection(uid, sid);
			message.put("code", "200");
			message.put("msg", "取消收藏");
		}
		return message;
	}
	/**
	 * MVC：预约服务地址
	 * @param srVOobj
	 * @param model
	 * @return
	 */
	@PostMapping("serReserveUrl")
	public String serReserveUrl(SerReserveVO srVOobj,Model model) {
		Integer sid = srVOobj.getServiceID();	//服务编号
		ServiceDetailInfo serDetailObj = biz.queryServiceDetailInfo(sid);	//服务详情对象
		List<Resouroe> resouroeList = biz.queryResouroe();
		System.out.println(JSON.toJSONString(srVOobj));
		model.addAttribute("srVOobj",srVOobj);	
		model.addAttribute("serDetailObj",serDetailObj);
		model.addAttribute("resouroeList",resouroeList);
		return "/ydk/Html/fw-ydfw";
	}
	/**
	 * MVC:提交预定
	 * @return
	 */
	@PostMapping("serReserve")
	public String submitReserve(HttpSession session,SerReserveVO obj,MultipartFile hyFile) {
		User loginUser = (User)session.getAttribute("userinfo");
		Integer loginUserID = loginUser.getUserid();	//当前登录用户编号
		//时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//订单号
		String orderID = sdf.format(new Date());
		Integer rd =  (int)(Math.random()*899+100);
		orderID = orderID+rd;	//三位随机数添加到订单号后面
		if(obj.getServiceTypeID()==4) {
			try {
				String fileName = Upload.uploadFile(hyFile);
				obj.setUploadPath(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		obj.setOrderID(orderID);
		obj.setUserID(loginUserID);
		biz.submitReserve(obj);
		return "redirect:/api/Forward_view/user/center";
	}
	/**
	 * 人工智能 查询
	 * @return
	 */
	@GetMapping("api/selectAI")
	@ResponseBody
	public List<Services> selectAI(Integer stid,HttpSession session){
		User user = (User)session.getAttribute("userinfo");
		if(user!=null) {
			List<Services> ai = biz.selectAI(user.getUserid(), stid);
			System.err.println(ai.size());
			return ai;
		}else {
			return biz.selectAI(0, stid);
		}
	}
	
	
	/**
	 * 
	 * @title: insertAI
	 * @description: 人工智能 添加
	 * @param session
	 * @param sid
	 * @return
	 * 下午9:21:04
	 */
	@GetMapping("api/insertAI")
	@ResponseBody
	public Map<String,String> insertAI(HttpSession session,String ai){
		Map<String,String> message = new HashMap<String,String>();
		User user = (User)session.getAttribute("userinfo");
		if(user!=null) {
			Artificiaiintelligence ail =  JSON.parseObject(ai,Artificiaiintelligence.class);
			System.out.println(ail);
			ail.setUserId(user.getUserid());
			biz.insertAI(ail);
		}
		return message;
	}
	
	/**
	 * 获取当前用户session
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/queryAUser")
	@ResponseBody
	public User queryAUser(HttpSession session) {
		if(session.getAttribute("userinfo")==null) {
			return null;
		}else {
			Integer userID=((User)session.getAttribute("userinfo")).getUserid();
			User u=biz.queryUser(userID);
			session.setAttribute("USER", u);
			return u;
		}
	}
}
