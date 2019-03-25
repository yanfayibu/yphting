package com.accp.action.smy;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.smy.ServicesBiz;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Advertisementapply;
import com.accp.util.file.Upload;
import com.accp.vo.smy.AppraisalApply;
import com.accp.vo.smy.EvaluationVo;
import com.accp.vo.smy.LanguageType;
import com.accp.vo.smy.MajorType;
import com.accp.vo.smy.Order;
import com.accp.vo.smy.Orders;
import com.accp.vo.smy.Refund;
import com.accp.vo.smy.RefundVO;
import com.accp.vo.smy.ServiceType;
import com.accp.vo.smy.Services;
import com.accp.vo.smy.ServicesLevel;
import com.accp.vo.smy.ShArea;
import com.accp.vo.smy.User;
import com.accp.vo.smy.UserAppVo;
import com.accp.vo.smy.Users;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;





@Controller
@RequestMapping("/c/smy")
public class ServicesAcion {
	
	@Autowired
	private ServicesBiz biz;
	
	@RequestMapping(value="/getMer",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> getMer(HttpSession session) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();
		User user = biz.UserID(userID);
		Integer userMer = user.getMerchantType();
		Integer auditStatus=user.getAuditStatus();
		Map<String,String> map=new HashMap<String,String>();
		map.put("userMer",userMer.toString());
		map.put("auditStatus", auditStatus.toString());
		return map;
		/*if(userMer==0) {
			return "/view/sjrz";
		}else if(userMer!=0&&auditStatus==1) {
			return "/sjzx-shzl";
		}else {
			return "/c/smy/user/getUserBySjzx";
		}*/
		//return userMer.toString();
	}
	
	@RequestMapping(value="/getMoney",method=RequestMethod.GET)
	@ResponseBody
	public String getMoney(HttpSession session) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();
		User user = biz.UserID(userID);//模拟登录
		Float userMoney = user.getUserMoney();	//用户金币
		return userMoney.toString();
	}
	//发布服务---→韩语翻译
	@PostMapping("addServiceshyfy")
	public String  addServiceshyfy(HttpSession session,Model model,int stid,String serviceTitle,String[] typeid,String serviceFuTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceIntro,String[] serviceCostInclude,String serviceCostTypeID) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();	
				System.out.println(JSON.toJSONString(typeid));
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCity(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String zy="";
				for(String type:typeid) {
					zy+=type+",";
				}
				String baohao="";
				for(String val:serviceCostInclude) {
					baohao+=val+",";
				}
			
				service.setStid(stid);
				//service.setUserID(userID);
				service.setUserID(userID);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCostInclude(baohao);
				service.setGoodAtMajoy(zy);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
		
				biz.addService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//发布服务---→留学中介
	@PostMapping("addServiceslxzj")
	public String  addServiceslxzj(HttpSession session,Model model,int stid,int resourceID,String servicetitle,String servicefutitle,String downloadtitle,int serviceprice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceintro,String[] areaids, int countryid,String[] servicecostinclude,String servicecosttypeid,String uploaddataurl) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();
		
		Services service=new Services();
		try {
			if(!serviceCoverImg.isEmpty()) {
				String	fmturl=Upload.uploadFile(serviceCoverImg);
				service.setServiceCoverImg(fmturl);
			}
			if(!serviceImgUrlOne.isEmpty()) {
				String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
				service.setServiceImgUrlOne(xjturl1);
			}
			if(!serviceImgUrlTwo.isEmpty()) {
				
				String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
				service.setServiceImgUrlTwo(xjturl2);
			}
			if(!serviceImgUrlThree.isEmpty()) {
				String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
				service.setServiceImgUrlThree(xjturl3);
			}
			
			if(!serviceImgUrlFour.isEmpty()) {
				String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
				service.setServiceImgUrlFour(xjturl4);
			}
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String cs="";
		for(String i:areaids) {
			cs+=i+",";
		}
		String baohao="";
		for(String val:servicecostinclude) {
			baohao+=val+",";
		}
//		System.out.println(stid);
		service.setStid(stid);
		service.setUserID(userID);
		service.setResourceID(resourceID);
		service.setServiceTitle(servicetitle);
		service.setServiceFuTitle(servicefutitle);
		service.setServiceCity(cs);
		service.setServiceCostInclude(baohao);
		service.setDownloadTitle(downloadtitle);
		service.setServicePrice(serviceprice);
		service.setServiceCostTypeID(servicecosttypeid);
		service.setServiceIntro(serviceintro);
		service.setCountry(countryid);
		service.setUploadDataUrl(uploaddataurl);
		System.out.println(service);
		biz.addService(service);
		return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//发布服务---→微整形
	@PostMapping("addServiceswzx")
	public String  addServiceswzx(HttpSession session,Model model,int stid,int resourceID,String serviceTitle,String hospitalName,String serviceFuTitle,String downloadTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceStartDate,String serviceEndDate,String serviceIntro,String[] areaids,int countryid,String[] serviceCostInclude,String serviceCostTypeID,String uploadDataUrl) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();
				Services service=new Services();
		try {
			if(!serviceCoverImg.isEmpty()) {
				String	fmturl=Upload.uploadFile(serviceCoverImg);
				service.setServiceCity(fmturl);
			}
			if(!serviceImgUrlOne.isEmpty()) {
				String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
				service.setServiceImgUrlOne(xjturl1);
			}
			if(!serviceImgUrlTwo.isEmpty()) {
				
				String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
				service.setServiceImgUrlTwo(xjturl2);
			}
			if(!serviceImgUrlThree.isEmpty()) {
				String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
				service.setServiceImgUrlThree(xjturl3);
			}
			
			if(!serviceImgUrlFour.isEmpty()) {
				String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
				service.setServiceImgUrlFour(xjturl4);
			}
		
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cs="";
				for(String i:areaids) {
					cs+=i+",";
				}
				String baohao="";
				for(String val:serviceCostInclude) {
					baohao+=val+",";
				}
				
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    
			    Date servicestartdate=null;
			    Date serviceenddate=null;
			    
			  try {
				servicestartdate=dateFormat.parse(serviceStartDate);
				serviceenddate=dateFormat.parse(serviceEndDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				service.setStid(stid);
				service.setUserID(userID);
				service.setResourceID(resourceID);
				
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCity(cs);
			
				service.setServiceStartDate(servicestartdate);
				service.setServiceEndDate(serviceenddate);
				service.setServiceCostInclude(baohao);
				service.setDownloadTitle(downloadTitle);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				service.setCountry(countryid);
				service.setUploadDataUrl(uploadDataUrl);
				biz.addService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//发布服务---→学习资源
	@PostMapping("addServicesxxzy")
	public String  addServicesxxzy(HttpSession session,Model model,int stid,int resourceID,String serviceTitle,String serviceFuTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String schoolRegion,String schoolNameByCN,String majoyNameByCN,String schoolNameByROK,String majoyNameByROK,String serviceIntro,String serviceCostTypeID, MultipartFile uploadDataUrl) {
		Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();	

				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCity(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
					
					if(!uploadDataUrl.isEmpty()) {
						String	filesc=Upload.uploadFile(uploadDataUrl);

						service.setUploadDataUrl(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
				service.setStid(stid);
				service.setUserID(userID);
				service.setResourceID(resourceID);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setSchoolRegion(schoolRegion);
				service.setSchoolNameByCN(schoolNameByCN);
				service.setMajoyNameByCN(majoyNameByCN);
				service.setSchoolNameByROK(schoolNameByROK);
				service.setMajoyNameByROK(majoyNameByROK);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
			
				biz.addService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//发布服务---→自驾游
	@PostMapping("addServiceszjy")
	public String  addServiceszjy(HttpSession session,Model model,int stid,int resourceID,String serviceTitle,String serviceFuTitle,String downloadTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceStartDate,String serviceEndDate,int serviceHour,String serviceIntro,String[] areaids,int countryid,String[] serviceCostInclude,String serviceCostTypeID,String uploadDataUrl) {
				Services service=new Services();
				Integer userID=((com.accp.pojo.User)session.getAttribute("userinfo")).getUserid();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCity(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cs="";
				for(String i:areaids) {
					cs+=i+",";
				}
				String baohao="";
				for(String val:serviceCostInclude) {
					baohao+=val+",";
				}
				service.setStid(stid);
				service.setUserID(userID);
				service.setResourceID(resourceID);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCity(cs);
				service.setServiceHour(serviceHour);
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    
			    Date servicestartdate=null;
			    Date serviceenddate=null;
			    
			  try {
				servicestartdate=dateFormat.parse(serviceStartDate);
				serviceenddate=dateFormat.parse(serviceEndDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				service.setServiceStartDate(servicestartdate);
				service.setServiceEndDate(serviceenddate);
				service.setServiceCostInclude(baohao);
				service.setDownloadTitle(downloadTitle);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				service.setCountry(countryid);
				service.setUploadDataUrl(uploadDataUrl);
				biz.addService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	
	//商家入驻
	@GetMapping("merchantEnterUrl")
	public String merchantEnterUrl(Model model,HttpSession session) {
		com.accp.pojo.User user =(com.accp.pojo.User)session.getAttribute("userinfo");	//登录用户对象
		Float userMoney = user.getUsermoney();	//用户金币
		List<ServiceType> servicetypeList = biz.queryServiceType(null, null);	//获取服务类别
		List<LanguageType> languagetypeList = biz.queryLanguagetype();	//获取服务语言
		List<MajorType> majortypeList = biz.queryMajortype();	//获取擅长专业
		List<ShArea> shareaList = biz.querySharea(null,false);	//获取国家
		List<ShArea> liveCityList = biz.querySharea(2,false);	//获取韩国城市集合
		model.addAttribute("servicetypeList", servicetypeList);	//将服务类别集合存入request
		model.addAttribute("languagetypeList", languagetypeList); //将服务语言集合存入request
		model.addAttribute("majortypeList", majortypeList); //将擅长专业集合存入request
		model.addAttribute("shareaList",shareaList);	//将国家集合存入request
		model.addAttribute("liveCityList",liveCityList);	//将韩国城市集合存入request
		model.addAttribute("bond",biz.queryBond());	//将商家入驻需缴纳保证金额大小存入request
		model.addAttribute("userMoney",userMoney);	//将用户金额存入request
		return "/smy/Html/sjrz-txzl";
	}
	@GetMapping("api/querySharea")
	@ResponseBody
	public List<ShArea> querySharea(Integer pid){
		return biz.querySharea(pid,false);
	}
	@PostMapping("merchantEnter")
	public String merchantMove(HttpSession session,User user,String serviceID,MultipartFile shopimgData,MultipartFile identitypositiveimgData,MultipartFile identitynegativeimgData,MultipartFile identityhandimgData) {
		com.accp.pojo.User loginUser =(com.accp.pojo.User)session.getAttribute("userinfo");	//登录用户对象	//登录用户
		float bond = biz.queryBond();	//入驻缴纳保证金金额要求
		if(loginUser.getUsermoney()>=bond) {	//如果当前登录用户的金额足够缴纳保证金
			if(serviceID.split(",").length==2) {	//如果用户选择的服务类别为两个
				user.setFirstServiceID(Integer.parseInt(serviceID.split(",")[0]));
				user.setSecondServiceID(Integer.parseInt(serviceID.split(",")[1]));	
			}else {
				user.setFirstServiceID(Integer.parseInt(serviceID));
			}
			try {
				String shopimgDataFName = Upload.uploadFile(shopimgData);
				String identitypositiveimgDataFName = Upload.uploadFile(identitypositiveimgData);
				String identitynegativeimgDataFName = Upload.uploadFile(identitynegativeimgData);
				String identityhandimgDataFName = Upload.uploadFile(identityhandimgData);
				user.setShopImg(shopimgDataFName);	//设置数据库存储图片路径
				user.setIdentityPositiveImg(identitypositiveimgDataFName);
				user.setIdentityNegativeImg(identitynegativeimgDataFName);
				user.setIdentityHandImg(identityhandimgDataFName);
				user.setUserID(loginUser.getUserid());//当前登录用户编号赋给修改对象
			} catch (IllegalStateException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(biz.merchantMove(user,bond)>0) {//商家入驻受影响行数
				biz.saveGoldNotes(loginUser.getUserid(), 4, "商家入驻缴纳保证金",-bond , 2);	//添加金币流向记录
				biz.saveSystemMSG(loginUser.getUserid(), "您好，您已成功提交商家入驻的申请，请等待管理员审核。");
				return "redirect:/view/shzl";
			}else {
				return "redirect:/Public/error/500.html";
			}
		}else {
			return "redirect:/Public/error/500.html";
		}
	}
	
	@RequestMapping(value="/user/getUserBySjzx",method=RequestMethod.GET)
	public String getUserBySjzx(HttpSession session,Model model) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		User userID = biz.UserID(userid);
		model.addAttribute("user", userID);
		model.addAttribute("level", biz.querySerlevelName(userid));
		model.addAttribute("orders", biz.queryUserOrder(userid, 0, -1, "", 1, 3));
		//model.addAttribute("user", this.queryAUser(session));
		return "/smy/Html/sjzx-index";
	}
	
	@RequestMapping(value="/order/querySerType",method=RequestMethod.GET)
	@ResponseBody
	public ServiceType querySerType(Integer stid) {
		return biz.querySerType(stid);
	}
	
	@RequestMapping(value="/order/queryCountOrder",method=RequestMethod.GET)
	@ResponseBody
	public List<Orders> queryCountOrder(HttpSession session) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		return biz.queryCountOrder(userid);
	}
	
	//商家中心收到的预定查询
	@RequestMapping(value="/order/queryAllOrder",method=RequestMethod.GET)
	public String queryAllOrdes(HttpSession session,Model model,Integer orderStatus,Integer refundstatus,String orderID,Integer pageNum,Integer pageSize) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		model.addAttribute("pageInfo", biz.queryUserOrder(userid, orderStatus, refundstatus, orderID, pageNum, pageSize));
		return "/smy/Html/sjzx-order";
	}
	//订单查看详情
	@RequestMapping(value="/order/queryAOrder",method=RequestMethod.GET)
	public String queryAOrder(Model model,String orderID) {
		model.addAttribute("order", biz.queryAOrder(orderID));
		return "/smy/Html/sjrz-order-deatil.html";
	}
	//修改订单状态
	@RequestMapping(value="/order/updateOrders",method=RequestMethod.GET)
	public String updateOrders(HttpSession session,Integer orderStatus,String orderID,Integer userID) {
		biz.updateOrdersStatus(orderStatus, orderID);
		String content="";
		switch (orderStatus) {
		case 3:
			content="您的订单"+orderID+",商家已接单,请进入个人中心查看";
			break;
		case 4:
			content="您的订单"+orderID+",商家已提供服务,请进入个人中心查看";
			break;
		case 7:
			content="您的订单"+orderID+",商家已取消,请进入个人中心查看";
			break;
		default:
			System.out.println("多余状态");
			break;
		}
		biz.saveSystemMSG(userID, content);
		return "redirect:/c/smy/order/queryAllOrder?orderStatus=0&refundstatus=-1&pageNum=1&pageSize=5&orderID=";
	}
	//查询我发布的服务
	@GetMapping("getServices")
	public String  queryService(HttpSession session,Model model,Integer pageNum,Integer pageSize) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		PageInfo<Services> pageInfo=biz.queryService(userid,pageNum, pageSize);
		model.addAttribute("PAGE_INFO", pageInfo);
		return "/smy/Html/sjzx-services";
	}
	//我发布的服务根据服务名称查询
	@PostMapping("getServicesByTitle")
	public String  queryServicesByTitle(HttpSession session,Model model,Integer pageNum,Integer pageSize,String serviceTitle) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		PageInfo<Services> pageInfo=biz.queryServiceAndByTitle(userid, serviceTitle, pageNum, pageSize);
		model.addAttribute("PAGE_INFO", pageInfo);
		return "/smy/Html/sjzx-services";
	}
	//商家中心我发布的服务中编辑时服务获取服务类别
	@GetMapping("queryServices")
	public String queryServices(Model model,int serviceID,int stid) {
			Services service=biz.queryService(serviceID);
			model.addAttribute("Services",service);
			if(stid==1) {
				return "/smy/Html/sjzx-xgzjy";
			}else if(stid==2) {
				return "/smy/Html/sjzx-xgwzx";
			}else if(stid==3) {
				return "/smy/Html/sjzx-xglxzj";
			}else if(stid==4) {
				return "/smy/Html/sjzx-xghyfy";
			}else if(stid==5){
				return "/smy/Html/sjzx-xgxxzy";
			}
			return null;
		}
	//商家中心我发布的服务---→编辑韩语翻译
	@PostMapping("updateServiceshyfy")
	public String  updateServiceshyfy(HttpSession session,Model model,int serviceID,int stid,String serviceTitle,String [] typeid,String serviceFuTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceIntro,String[] serviceCostInclude,String serviceCostTypeID) {
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCoverImg(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String zy="";//擅长专业
				for(String i:typeid) {
					zy+=i+",";
				}
				String baohao="";//费用包含
				for(String val:serviceCostInclude) {
					baohao+=val+",";
				}
				service.setServiceID(serviceID);
				service.setStid(stid);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCostInclude(baohao);
				service.setGoodAtMajoy(zy);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				biz.updateService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//商家中心我发布的服务---→编辑留学中介
	@PostMapping("updateServiceslxzj")
	public String  updateServiceslxzj(HttpSession session,Model model,int serviceID,int stid,String servicetitle,String servicefutitle,String downloadtitle,int serviceprice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceintro,String[] areaids,int countryid,String[] servicecostinclude,String servicecosttypeid,String uploaddataurl) {
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCoverImg(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cs="";
				for(String i:areaids) {
					cs+=i+",".substring(0,areaids.length-1);
				}
				String baohao="";
				for(String val:servicecostinclude) {
					baohao+=val+",".substring(0,servicecostinclude.length-1);
				}
				service.setServiceID(serviceID);
				service.setStid(stid);
				service.setServiceTitle(servicetitle);
				service.setServiceFuTitle(servicefutitle);
				service.setServiceCity(cs);
				service.setServiceCostInclude(baohao);
				service.setDownloadTitle(downloadtitle);
				service.setServicePrice(serviceprice);
				service.setServiceCostTypeID(servicecosttypeid);
				service.setServiceIntro(serviceintro);
				service.setCountry(countryid);
				service.setUploadDataUrl(uploaddataurl);
				biz.updateService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//商家中心我发布的服务---→编辑微整形
	@PostMapping("updateServiceswzx")
	public String  updateServiceswzx(HttpSession session,Model model,int serviceID,int stid,String serviceTitle,String hospitalName,String serviceFuTitle,String downloadTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceStartDate,String serviceEndDate,String serviceIntro,String[] areaids,int countryid,String[] serviceCostInclude,String serviceCostTypeID,String uploadDataUrl) {
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCoverImg(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cs="";
				for(String i:areaids) {
					cs+=i+",";
				}
				String baohao="";
				for(String val:serviceCostInclude) {
					baohao+=val+",";
				}
				
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    
			    Date servicestartdate=null;
			    Date serviceenddate=null;
			    
			  try {
				servicestartdate=dateFormat.parse(serviceStartDate);
				serviceenddate=dateFormat.parse(serviceEndDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				service.setServiceID(serviceID);
				service.setStid(stid);
				//service.setResourceID(resourceID);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCity(cs);
			
				service.setServiceStartDate(servicestartdate);
				service.setServiceEndDate(serviceenddate);
				service.setServiceCostInclude(baohao);
				service.setDownloadTitle(downloadTitle);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				service.setCountry(countryid);
				service.setUploadDataUrl(uploadDataUrl);
				biz.updateService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//商家中心我发布的服务---→编辑学习资源
	@PostMapping("updateServicesxxzy")
	public String  updateServicesxxzy(HttpSession session,Model model,int serviceID,int stid,int resourceID,String serviceTitle,String serviceFuTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String schoolRegion,String schoolNameByCN,String majoyNameByCN,String schoolNameByROK,String majoyNameByROK,String serviceIntro,String serviceCostTypeID,MultipartFile uploadDataUrl) {
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCoverImg(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
					
					if(!uploadDataUrl.isEmpty()) {
						String	filesc=Upload.uploadFile(uploadDataUrl);

						service.setUploadDataUrl(filesc);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				service.setServiceID(serviceID);
				service.setStid(stid);
				service.setResourceID(resourceID);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setSchoolRegion(schoolRegion);
				service.setSchoolNameByCN(schoolNameByCN);
				service.setMajoyNameByCN(majoyNameByCN);
				service.setSchoolNameByROK(schoolNameByROK);
				service.setMajoyNameByROK(majoyNameByROK);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				biz.updateService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	//商家中心我发布的服务---→编辑自驾游
	@PostMapping("updateServiceszjy")
	public String  updateServiceszjy(HttpSession session,Model model,int serviceID,int stid,String serviceTitle,String serviceFuTitle,String downloadTitle,int servicePrice, MultipartFile serviceCoverImg,MultipartFile serviceImgUrlOne,MultipartFile serviceImgUrlTwo,MultipartFile serviceImgUrlThree,MultipartFile serviceImgUrlFour,String serviceStartDate,String serviceEndDate,int serviceHour,String serviceIntro,String[] areaids,int countryid,String[] serviceCostInclude,String serviceCostTypeID,String uploadDataUrl) {
				Services service=new Services();
				try {
					if(!serviceCoverImg.isEmpty()) {
						String	fmturl=Upload.uploadFile(serviceCoverImg);
						service.setServiceCoverImg(fmturl);
					}
					if(!serviceImgUrlOne.isEmpty()) {
						String	xjturl1=Upload.uploadFile(serviceImgUrlOne);
						service.setServiceImgUrlOne(xjturl1);
					}
					if(!serviceImgUrlTwo.isEmpty()) {
						
						String	xjturl2=Upload.uploadFile(serviceImgUrlTwo);
						service.setServiceImgUrlTwo(xjturl2);
					}
					if(!serviceImgUrlThree.isEmpty()) {
						String	xjturl3=Upload.uploadFile(serviceImgUrlThree);
						service.setServiceImgUrlThree(xjturl3);
					}
					
					if(!serviceImgUrlFour.isEmpty()) {
						String	xjturl4=Upload.uploadFile(serviceImgUrlFour);
						service.setServiceImgUrlFour(xjturl4);
					}
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cs="";
				for(String i:areaids) {
					cs+=i+",".substring(0,areaids.length-1);
				}
				String baohao="";
				for(String val:serviceCostInclude) {
					baohao+=val+",".substring(0,serviceCostInclude.length-1);
				}
				
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    
			    Date servicestartdate=null;
			    Date serviceenddate=null;
			    
			  try {
				servicestartdate=dateFormat.parse(serviceStartDate);
				serviceenddate=dateFormat.parse(serviceEndDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				service.setServiceID(serviceID);
				service.setStid(stid);
				service.setServiceTitle(serviceTitle);
				service.setServiceFuTitle(serviceFuTitle);
				service.setServiceCity(cs);
				service.setServiceHour(serviceHour);
				service.setServiceStartDate(servicestartdate);
				service.setServiceEndDate(serviceenddate);
				service.setServiceCostInclude(baohao);
				service.setDownloadTitle(downloadTitle);
				service.setServicePrice(servicePrice);
				service.setServiceCostTypeID(serviceCostTypeID);
				service.setServiceIntro(serviceIntro);
				service.setCountry(countryid);
				service.setUploadDataUrl(uploadDataUrl);
				biz.updateService(service);
				return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	
	//删除商家中心我发布的服务
	@GetMapping("removeServices")
	public String  removeService(int serviceID) {
		//System.out.println("删除的id为:"+serviceID);
		biz.deleteService(serviceID);
		return "redirect:/c/smy/getServices?pageNum=1&pageSize=3";
	}
	
	//商家发布新服务时根据该用户入驻时所申请的服务来选择发布的服务类型
	@GetMapping("queryUser")
	public String queryUser(HttpSession session, Model model) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		User user=biz.UserID(userid);
		model.addAttribute("ZUSER",user);
		return "/smy/Html/sjzx-xzfwlb";
	}
	
	//商家中心查询我提交的鉴定
	@GetMapping("queryAppraisalapply")
	public String queryAppraisalapply(HttpSession session, Model model) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		Integer oneid=((com.accp.pojo.User)session.getAttribute("userinfo")).getFirstserviceid();
		Integer twoid=((com.accp.pojo.User)session.getAttribute("userinfo")).getSecondserviceid();
		List<UserAppVo> list=biz.queryAppraisalapply(userid, oneid, twoid);
		//System.out.println(JSON.toJSONString(list));
		model.addAttribute("LIST",list);
		return "/smy/Html/sjzx-auth";
	}
	
	//商家提交鉴定申请---→自驾游
	@PostMapping("addzjyjd")
	public String  addzjyjd(HttpSession session,Model model,int stid,String name,int sex,int height,String constellation,int age,String visatype,int documentType,String certificates,String experience,boolean vehicle,boolean guideCard,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
				AppraisalApply app=new AppraisalApply();
				try {
					if(!schoolReport.isEmpty()) {
						String	filesc=Upload.uploadFile(schoolReport);
						app.setSchoolReport(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				app.setUserID(userid);
				app.setStid(stid);
				app.setName(name);
				app.setSex(sex);
				app.setHeight(height);
				app.setConstellation(constellation);
				app.setAge(age);
				app.setVisaType(visatype);
				app.setDocumentType(documentType);
				app.setCertificates(certificates);
				app.setExperience(experience);
				app.setVehicle(vehicle);
				app.setGuideCard(guideCard);
				app.setInKorea(inKorea);
				app.setPhone(phone);
				app.setEmail(email);
				app.setCountry(country);
				app.setProvincialID(provincialID);
				app.setCityID(cityID);
				app.setDetailed(detailed);
			
				app.setSubmitTime(new Date());
				app.setAuditStatus(1);
				biz.addAppraisalapply(app);
				return "redirect:/c/smy/queryAppraisalapply";
	}
	//商家提交鉴定申请---→微整形
	@PostMapping("addwzxjd")
	public String  addwzxjd(HttpSession session,Model model,int applyID,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean vehicle,MultipartFile hospitalLicense,String cooperativeHospital,String cooperativeHospitalURL,String hospitalPhone,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
				AppraisalApply app=new AppraisalApply();
				try {
					if(!hospitalLicense.isEmpty()) {
						String	yyfile=Upload.uploadFile(hospitalLicense);
						app.setHospitalLicense(yyfile);
					}
					if(!schoolReport.isEmpty()) {
						String	filesc=Upload.uploadFile(schoolReport);
						app.setSchoolReport(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				app.setApplyID(applyID);
				app.setStid(stid);
				app.setName(name);
				app.setSex(sex);		
				app.setVisaType(visatype);
				app.setDocumentType(documentType);
				app.setCertificates(certificates);
				app.setExperience(experience);
				app.setVehicle(vehicle);
				app.setInKorea(inKorea);
				app.setCooperativeHospital(cooperativeHospital);
				app.setCooperativeHospitalURL(cooperativeHospitalURL);
				app.setHospitalPhone(hospitalPhone);
				app.setPhone(phone);
				app.setEmail(email);
				app.setCountry(country);
				app.setProvincialID(provincialID);
				app.setCityID(cityID);
				app.setDetailed(detailed);
				app.setSubmitTime(new Date());
				app.setAuditStatus(1);
				biz.addAppraisalapply(app);
				return "redirect:/c/smy/queryAppraisalapply";
	}
	//商家提交鉴定申请---→留学中介
	@PostMapping("addlxzjjd")
	public String  addlxzjjd(HttpSession session,Model model,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean office,String officeCountry,String officeProvince,String officeCity,String officeDetailed,MultipartFile koreaLicense,String officialNetworkURL,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
				AppraisalApply app=new AppraisalApply();
				try {
					if(!koreaLicense.isEmpty()) {
						String	file1=Upload.uploadFile(koreaLicense);
						app.setKoreaLicense(file1);
					}
					if(!schoolReport.isEmpty()) {
						String	filesc=Upload.uploadFile(schoolReport);
						app.setSchoolReport(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				app.setUserID(userid);
				app.setStid(stid);
				app.setName(name);
				app.setSex(sex);		
				app.setVisaType(visatype);
				app.setDocumentType(documentType);
				app.setCertificates(certificates);
				app.setExperience(experience);
				app.setOffice(office);
				app.setOfficeCountry(officeCountry);
				app.setOfficeProvince(officeProvince);
				app.setOfficeCity(officeCity);
				app.setOfficeDetailed(officeDetailed);
				app.setOfficialNetworkURL(officialNetworkURL);
				app.setInKorea(inKorea);
		
				app.setPhone(phone);
				app.setEmail(email);
				app.setCountry(country);
				app.setProvincialID(provincialID);
				app.setCityID(cityID);
				app.setDetailed(detailed);
				app.setSubmitTime(new Date());
				app.setAuditStatus(1);
				biz.addAppraisalapply(app);
				return "redirect:/c/smy/queryAppraisalapply";
	}
	//商家提交鉴定申请---→韩语翻译
	@PostMapping("addhyfyjd")
	public String  addhyfyjd(HttpSession session,Model model,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean office,int translateType,MultipartFile translate,String officeCountry,String officeProvince,String officeCity,String officeDetailed,MultipartFile koreaLicense,String translateWebsite,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
				AppraisalApply app=new AppraisalApply();
				try {
					if(!translate.isEmpty()) {
						String	filetranslate=Upload.uploadFile(translate);
						app.setKoreaLicense(filetranslate);
					}
					
					
					if(!koreaLicense.isEmpty()) {
						String	file1=Upload.uploadFile(koreaLicense);
						app.setKoreaLicense(file1);
					}
					if(!schoolReport.isEmpty()) {
						String	filesc=Upload.uploadFile(schoolReport);
						app.setSchoolReport(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				app.setUserID(userid);
				app.setStid(stid);
				app.setName(name);
				app.setSex(sex);		
				app.setVisaType(visatype);
				app.setDocumentType(documentType);
				app.setCertificates(certificates);
				app.setExperience(experience);
				app.setOffice(office);
				app.setTranslateWebsite(translateWebsite);
				app.setInKorea(inKorea);
				app.setTranslateType(translateType);
				app.setOfficeCountry(officeCountry);
				app.setOfficeProvince(officeProvince);
				app.setOfficeCity(officeCity);
				app.setOfficeDetailed(officeDetailed);
				app.setPhone(phone);
				app.setEmail(email);
				app.setCountry(country);
				app.setProvincialID(provincialID);
				app.setCityID(cityID);
				app.setDetailed(detailed);
				app.setSubmitTime(new Date());
				app.setAuditStatus(1);
				biz.addAppraisalapply(app);
				return "redirect:/c/smy/queryAppraisalapply";
	}
	//商家提交鉴定申请---→学习资源
	@PostMapping("addxxzyjd")
	public String  addxxzyjd(HttpSession session,Model model,int stid,String name,int sex,String visatype,int documentType,String certificates,String studyMajor,MultipartFile schoolReport) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
				AppraisalApply app=new AppraisalApply();
				try {
				
					if(!schoolReport.isEmpty()) {
						String	filesc=Upload.uploadFile(schoolReport);
						app.setSchoolReport(filesc);
					}
					
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				app.setUserID(userid);
				app.setStid(stid);
				app.setName(name);
				app.setSex(sex);		
				app.setVisaType(visatype);
				app.setDocumentType(documentType);
				app.setCertificates(certificates);
				app.setStudyMajor(studyMajor);
				app.setSubmitTime(new Date());
				app.setAuditStatus(1);
				biz.addAppraisalapply(app);
				return "redirect:/c/smy/queryAppraisalapply";
	}
	//重新提交鉴定获取服务类别
	@GetMapping("queryAppraisal")
	public String queryAppraisal(Model model,int applyID,int stid) {
			AppraisalApply app=biz.queryAppraisal(applyID);
			model.addAttribute("App",app);
			if(stid==1) {
				return "/smy/Html/sjzx-xgzjyjd";
			}else if(stid==2) {
				return "/smy/Html/sjzx-xgwzxjd";
			}else if(stid==3) {
				return "/smy/Html/sjzx-xglxzjjd";
			}else if(stid==4) {
				return "/smy/Html/sjzx-xghyfyjd";
			}else if(stid==5){
				return "/smy/Html/sjzx-xgxxzyjd";
			}
			return null;
		}
	//商家重新提交鉴定申请---→自驾游
		@PostMapping("updatezjyjd")
		public String  updatezjyjd(HttpSession session,Model model,int applyID,int stid,String name,int sex,int height,String constellation,int age,String visatype,int documentType,String certificates,String experience,boolean vehicle,boolean guideCard,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
					AppraisalApply app=new AppraisalApply();
					try {
						if(!schoolReport.isEmpty()) {
							String	filesc=Upload.uploadFile(schoolReport);
							app.setSchoolReport(filesc);
						}
						
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.setApplyID(applyID);
					app.setStid(stid);
					app.setName(name);
					app.setSex(sex);
					app.setHeight(height);
					app.setConstellation(constellation);
					app.setAge(age);
					app.setVisaType(visatype);
					app.setDocumentType(documentType);
					app.setCertificates(certificates);
					app.setExperience(experience);
					app.setVehicle(vehicle);
					app.setGuideCard(guideCard);
					app.setInKorea(inKorea);
					app.setPhone(phone);
					app.setEmail(email);
					app.setCountry(country);
					app.setProvincialID(provincialID);
					app.setCityID(cityID);
					app.setDetailed(detailed);
				
					app.setSubmitTime(new Date());
					app.setAuditTime(null);
					app.setAuditStatus(1);
					biz.updateAppraisalApply(app);
					return "redirect:/c/smy/queryAppraisalapply";
		}
		//商家重新提交鉴定申请---→微整形
		@PostMapping("updatewzxjd")
		public String  updatewzxjd(HttpSession session,Model model,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean vehicle,MultipartFile hospitalLicense,String cooperativeHospital,String cooperativeHospitalURL,String hospitalPhone,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
			Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
					AppraisalApply app=new AppraisalApply();
					try {
						if(!hospitalLicense.isEmpty()) {
							String	yyfile=Upload.uploadFile(hospitalLicense);
							app.setHospitalLicense(yyfile);
						}
						if(!schoolReport.isEmpty()) {
							String	filesc=Upload.uploadFile(schoolReport);
							app.setSchoolReport(filesc);
						}
						
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.setUserID(userid);
					app.setStid(stid);
					app.setName(name);
					app.setSex(sex);		
					app.setVisaType(visatype);
					app.setDocumentType(documentType);
					app.setCertificates(certificates);
					app.setExperience(experience);
					app.setVehicle(vehicle);
					app.setInKorea(inKorea);
					app.setCooperativeHospital(cooperativeHospital);
					app.setCooperativeHospitalURL(cooperativeHospitalURL);
					app.setHospitalPhone(hospitalPhone);
					app.setPhone(phone);
					app.setEmail(email);
					app.setCountry(country);
					app.setProvincialID(provincialID);
					app.setCityID(cityID);
					app.setDetailed(detailed);
					app.setSubmitTime(new Date());
					app.setAuditTime(null);
					app.setAuditStatus(1);
					biz.addAppraisalapply(app);
					return "redirect:/c/smy/queryAppraisalapply";
		}
		//商家重新提交鉴定申请---→留学中介
		@PostMapping("updatelxzjjd")
		public String  updatelxzjjd(HttpSession session,Model model,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean office,String officeCountry,String officeProvince,String officeCity,String officeDetailed,MultipartFile koreaLicense,String officialNetworkURL,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
			Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
					AppraisalApply app=new AppraisalApply();
					try {
						if(!koreaLicense.isEmpty()) {
							String	file1=Upload.uploadFile(koreaLicense);
							app.setKoreaLicense(file1);
						}
						if(!schoolReport.isEmpty()) {
							String	filesc=Upload.uploadFile(schoolReport);
							app.setSchoolReport(filesc);
						}
						
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.setUserID(userid);
					app.setStid(stid);
					app.setName(name);
					app.setSex(sex);		
					app.setVisaType(visatype);
					app.setDocumentType(documentType);
					app.setCertificates(certificates);
					app.setExperience(experience);
					app.setOffice(office);
					app.setOfficeCountry(officeCountry);
					app.setOfficeProvince(officeProvince);
					app.setOfficeCity(officeCity);
					app.setOfficeDetailed(officeDetailed);
					app.setOfficialNetworkURL(officialNetworkURL);
					app.setInKorea(inKorea);
			
					app.setPhone(phone);
					app.setEmail(email);
					app.setCountry(country);
					app.setProvincialID(provincialID);
					app.setCityID(cityID);
					app.setDetailed(detailed);
					app.setSubmitTime(new Date());
					app.setAuditTime(null);
					app.setAuditStatus(1);
					biz.updateAppraisalApply(app);
					return "redirect:/c/smy/queryAppraisalapply";
		}
		//商家重新提交鉴定申请---→韩语翻译
		@PostMapping("updatehyfyjd")
		public String  updatehyfyjd(HttpSession session,Model model,int applyID,int stid,String name,int sex,String visatype,int documentType,String certificates,String experience,boolean office,int translateType,MultipartFile translate,String officeCountry,String officeProvince,String officeCity,String officeDetailed,MultipartFile koreaLicense,String translateWebsite,String inKorea,String phone,String email,String country,String provincialID,String cityID,String detailed,MultipartFile schoolReport) {
					AppraisalApply app=new AppraisalApply();
					try {
						if(!translate.isEmpty()) {
							String	filetranslate=Upload.uploadFile(translate);
							app.setKoreaLicense(filetranslate);
						}
						
						
						if(!koreaLicense.isEmpty()) {
							String	file1=Upload.uploadFile(koreaLicense);
							app.setKoreaLicense(file1);
						}
						if(!schoolReport.isEmpty()) {
							String	filesc=Upload.uploadFile(schoolReport);
							app.setSchoolReport(filesc);
						}
						
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.setApplyID(applyID);
					app.setStid(stid);
					app.setName(name);
					app.setSex(sex);		
					app.setVisaType(visatype);
					app.setDocumentType(documentType);
					app.setCertificates(certificates);
					app.setExperience(experience);
					app.setOffice(office);
					app.setTranslateWebsite(translateWebsite);
					app.setInKorea(inKorea);
					app.setTranslateType(translateType);
					app.setOfficeCountry(officeCountry);
					app.setOfficeProvince(officeProvince);
					app.setOfficeCity(officeCity);
					app.setOfficeDetailed(officeDetailed);
					app.setPhone(phone);
					app.setEmail(email);
					app.setCountry(country);
					app.setProvincialID(provincialID);
					app.setCityID(cityID);
					app.setDetailed(detailed);
					app.setSubmitTime(new Date());
					//app.setAuditTime(null);
					app.setAuditStatus(1);
					biz.updateAppraisalApply(app);
					return "redirect:/c/smy/queryAppraisalapply";
		}
		//商家重新提交鉴定申请---→学习资源
		@PostMapping("updatexxzyjd")
		public String  updatexxzyjd(HttpSession session,Model model,int applyID,int stid,String name,int sex,String visatype,int documentType,String certificates,String studyMajor,MultipartFile schoolReport) {
					AppraisalApply app=new AppraisalApply();
					try {
					
						if(!schoolReport.isEmpty()) {
							String	filesc=Upload.uploadFile(schoolReport);
							app.setSchoolReport(filesc);
						}
						
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					app.setApplyID(applyID);
					app.setStid(stid);
					app.setName(name);
					app.setSex(sex);		
					app.setVisaType(visatype);
					app.setDocumentType(documentType);
					app.setCertificates(certificates);
					app.setStudyMajor(studyMajor);
					app.setSubmitTime(new Date());
					app.setAuditTime(null);
					app.setAuditStatus(1);
					biz.updateAppraisalApply(app);
					return "redirect:/c/smy/queryAppraisalapply";
		}
	
	//商家中心我收到的评价
	@GetMapping("queryEvaluation")
	public String  queryEvaluation(HttpSession session,Model model,Integer pageNum,Integer pageSize) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		PageInfo<EvaluationVo> pageInfo=biz.queryEvaluation(pageNum, pageSize, userid);
		model.addAttribute("PAGE_INFO", pageInfo);
		return "/smy/Html/sjzx-comment";
	}
	
	@RequestMapping("/refund/list")
	public String refundList(@RequestParam(defaultValue = "1") Integer page, Model model, HttpSession session) {
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		model.addAttribute("pageInfo", biz.queryRefundList(userid, page, 10));
		return "/smy/Html/sjzx-refund";
	}
	
	//根据编号获取订单信息查看详情
	@RequestMapping("/refund/sjdetail")
	public String refundSJDetail(@RequestParam(required = true) String orderid, Model model) {
		model.addAttribute("order", biz.queryOrderById(orderid));
		model.addAttribute("refund", biz.queryRefundByOrderId(orderid));
		return "/smy/Html/sjzx-refund-detail";
	}
	
	//拒绝退款填写理由
	@RequestMapping("/refund/why")
	public String refundWhy(@RequestParam(required = true) String orderid, Model model) {
		model.addAttribute("orderid", orderid);
		return "/smy/Html/sjzx-refund-why";
	}
	
	//拒绝退款
	@RequestMapping("/refund/no")
	public String refundNo(@RequestParam(required = true)String orderid, Model model) {
		Orders order = new Orders();
		order.setOrderID(orderid);
		order.setRefundstatus(2);
		RefundVO refund = new RefundVO();
		refund.setOrderID(orderid);
		refund.setAuditTime(new Date());
		refund.setAuditStatus(3);
		biz.refundNo(order, refund);
		return "redirect:/c/smy/refund/list";
	}
	
	//同意退款
	@RequestMapping("/refund/ok")
	@ResponseBody
	public boolean refundOk(@RequestParam(required = true) String orderid) {
		System.out.println(orderid+"dsdsddsdsdsdsdsds");
		try {
			Order orderInfo = biz.queryOrderById(orderid);
			Order order = new Order();
			order.setOrderID(orderid);
			order.setRefundstatus(5);
			RefundVO refund = new RefundVO();
			refund.setOrderID(orderid);
			refund.setAuditStatus(2);
			refund.setAuditTime(new Date());
			biz.refundOk(orderInfo, order, refund);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//商家回复评价
	@PostMapping("api/addMerchantsEvaluation")
	@ResponseBody
	public Map<String, String> addMerchantsEvaluation(Integer serviceID,Integer PID,String serviceContent,String serviceTitle,HttpSession session){
		Map<String, String> map = new HashMap<String,String>();
		Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		biz.saveSystemMSG(userid, "您好，您预订的"+serviceTitle+"评价，商家已回应，请至个人中心我的评价中查看。");//订单号
		biz.addMerchantsEvaluation(serviceID, userid, PID, serviceContent);
		map.put("code", "200");
		map.put("msg", "回复成功");
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String showAdvertisement(Model model,Integer aid) {
		List<Advertisement> list = biz.findAvailableAdvertisement();
		model.addAttribute("BLIST", list);
		return "/smy/Html/addAdvert";
	}
	
	@RequestMapping(value="/advertisementApply",method=RequestMethod.POST)
	/*@PostMapping("advertisementApply")*/
	@ResponseBody
	public Map<String,String> savePost(@RequestBody Advertisementapply advertisementapply,HttpSession session) {
		//Integer userid = ((com.accp.pojo.User) session.getAttribute("userinfo")).getUserid();
		
		//advertisementapply.setUserid(31);
		com.accp.pojo.User user=new com.accp.pojo.User();
		user.setUserid(24);
		advertisementapply.setUserid(user.getUserid());
		//User user=(User)session.getAttribute("userinfo");
		//advertisementapply.setUserid(user.getUserid());
		Map<String,String> map=new HashMap<String,String>();
		int count=biz.addAdvertisementApply(advertisementapply);
		System.out.println(count);
		if(count>0) {
			map.put("code", "200");
		}else {
			map.put("code", "400");
		}
		return map;
	}
}
