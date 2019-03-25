package com.accp.action.hzj;
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

import com.accp.biz.hzj.AdvertisementBiz;
import com.accp.pojo.Advertisement;
import com.accp.pojo.Post;
import com.accp.vo.hzj.AdvertisementVO;
import com.accp.vo.hzj.HomePostVO;
import com.accp.vo.hzj.ImageWidthAndHeightVO;
import com.accp.vo.hzj.SerRecommendVO;

@Controller
@RequestMapping("/c/hzj")
public class AdvertisementAction {
	@Autowired
	private AdvertisementBiz biz;
	
	/**
	 * MVC:首页地址
	 * @param model
	 * @return
	 */
	@GetMapping("homeUrl")
	public String homeUrl(Model model) {
		//首页社区服务轮播图广告位查询
		List<AdvertisementVO> homeSlideshowList = biz.queryHomeAdvertising(1);
		//首页社区服务中间广告位查询
		List<AdvertisementVO> homeMidAdvertingList = biz.queryHomeAdvertising(2);
		//首页社区上方左右广告位查询
		List<AdvertisementVO> homeTopAdvertingList = biz.queryHomeAdvertising(3);
		//首页社区下方广告位查询
		List<AdvertisementVO> homeBottomAdvertingList = biz.queryHomeAdvertising(4);
		//五大星级服务商家查询
		List<SerRecommendVO> recommendStidByOneList = biz.querySerRecommendVO(1);	//自驾游
		List<SerRecommendVO> recommendStidByTwoList = biz.querySerRecommendVO(2);	//微整形
		List<SerRecommendVO> recommendStidByThreeList = biz.querySerRecommendVO(3);	//留学中介
		List<SerRecommendVO> recommendStidByFourList = biz.querySerRecommendVO(4);	//韩语翻译
		List<SerRecommendVO> recommendStidByFiveList = biz.querySerRecommendVO(5);	//学习资源
		//韩汀社区论坛热门贴查询
		List<HomePostVO> homePostVOList = biz.queryHomePostVO();	//最新帖子
		List<Post> homePostMakeUpList = biz.queryHomePostByMakeup();	//美妆版块帖子
		model.addAttribute("homeSlideshowList",homeSlideshowList);
		model.addAttribute("homeMidAdvertingList",homeMidAdvertingList);
		model.addAttribute("recommendStidByOneList",recommendStidByOneList);
		model.addAttribute("recommendStidByTwoList",recommendStidByTwoList);
		model.addAttribute("recommendStidByThreeList",recommendStidByThreeList);
		model.addAttribute("recommendStidByFourList",recommendStidByFourList);
		model.addAttribute("recommendStidByFiveList",recommendStidByFiveList);
		model.addAttribute("homePostVOList",homePostVOList);
		model.addAttribute("homePostMakeUpList",homePostMakeUpList);
		model.addAttribute("homeTopAdvertingList",homeTopAdvertingList);
		model.addAttribute("homeBottomAdvertingList",homeBottomAdvertingList);
		return "/hzj/fw-sy";
	}
	
	
}
