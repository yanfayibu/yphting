package com.accp.action.zrb;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.zrb.ForumBiz;
import com.accp.pojo.Complaint;
import com.accp.pojo.Forummanagement;
import com.accp.pojo.Post;
import com.accp.pojo.Postcollection;
import com.accp.pojo.Postcomment;
import com.accp.pojo.Postfabulous;
import com.accp.pojo.User;
import com.accp.vo.zrb.PostVo;
import com.accp.vo.zrb.PostcommentVo;
import com.accp.vo.zrb.ShareInfoVO;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/zrb")
public class ForumAction {
	
	@Autowired
	private ForumBiz biz;

	@GetMapping("column")
	public String showColumn(Integer pid,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer size,@RequestParam(required=false)String title,@RequestParam(required=false)Integer forumId,Integer orderId,@RequestParam(required=false)Integer essence,Model model,HttpSession session) {
		User user = (User)session.getAttribute("userinfo");
		//查询左侧栏板块
		List<Forummanagement> list = biz.queryBlock();
		model.addAttribute("BLIST", list);
		if(pid==null)
			pid=list.get(0).getFmid();
		//查询版块对应栏目
		List<Forummanagement> smalllist = biz.queryCount(pid);
		//分页并按条件查询帖子列表
		PageInfo<PostVo> pageInfo = biz.queryPostList(pid,page, size, pid,title,forumId,orderId,essence);

		//显示版块名称
		Forummanagement forumma = biz.queryTitleName(pid);
		model.addAttribute("CLIST", smalllist);
		model.addAttribute("FORUM", forumma);
		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("user", user);
		return "/zrb/Html/lt-forum";
	}

	/**
	 * 查询热门帖子
	 * @param pid
	 * @param page
	 * @param size
	 * @param title
	 * @param model
	 * @return
	 */
	@GetMapping("hotPost")
	public String shwoHotPost(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="2")Integer size,@RequestParam(required=false)String title,Model model) {
		//查询左侧栏板块
		List<Forummanagement> list = biz.queryBlock();
		model.addAttribute("BLIST", list);
		//分页并按条件查询帖子列表
		PageInfo<PostVo> pageInfo = biz.queryHotPost(page, size, title);
		model.addAttribute("PAGE_INFO", pageInfo);
		return "/zrb/Html/lt-hotforum";
	}

	/**
	 * 跳转到发帖页面
	 * @param pid
	 * @param fmid
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("toAddForum")
	public String toAddForum(Integer pid,@RequestParam(required=false)Integer fmid,Model model,HttpSession session) {
		User user = (User)session.getAttribute("userinfo");
		if(user==null) {
			return "/zrb/Html/MSG";
		}else {
			//显示版块下拉框
			List<Forummanagement> list = biz.queryBlock();
			model.addAttribute("BLIST", list);
			model.addAttribute("pid", pid);
			model.addAttribute("fmid", fmid);
			model.addAttribute("person", user);
			return "/zrb/Html/lt-addForum";
		}
		//return "/zrb/Html/lt-addForum";
	}

	/**
	 * 显示栏目下拉框
	 * @param pid
	 * @return
	 */
	@GetMapping("showColumn")
	@ResponseBody
	public List<Forummanagement> showColumn(Integer pid){
		List<Forummanagement> list = biz.queryCount(pid);
		return list;
	}

	/**
	 * 发布帖子
	 * @param post
	 * @return
	 */
	@PostMapping("savePost")
	@ResponseBody
	public Map<String,String> savePost(@RequestBody Post post,HttpSession session) {
		Integer userId = ((User)session.getAttribute("userinfo")).getUserid();
		Map<String,String> map=new HashMap<>();
		post.setUserid(userId);
		int result = biz.savePost(post);
		int postCount = biz.checkPostCount(userId);
		if(result>0) {
			if(postCount>3) {
				map.put("code", "200");
			}else {
				//新增积分
				biz.updateJIntegral(userId);
				map.put("code", "300");
			}
		}else {
			map.put("code", "400");
		}
		return map;
	}

	/**
	 * 查询帖子详情
	 * @param postId
	 * @param model
	 * @return
	 */
	@GetMapping("postDetail")
	public String queryPostDetail(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="5")Integer size,Integer postId,Integer fmid,Integer pfmid,String fmname,Model model,HttpSession session) {
		User user = (User)session.getAttribute("userinfo");
//		if(user!=null) {
//			return "/tsy/szy-login";
//		}else {
			//帖子详情
			PostVo pv = biz.queryPostDetail(postId);
			//详情内评论列表
			PageInfo<PostcommentVo> pageInfo = biz.queryComment(page, size, postId);
			//详情右侧最新话题
			List<PostVo> newList = biz.queryNewPost(fmid);
			//帖子右侧热门话题
			PageInfo<PostVo> hotPost = biz.queryHotPost(1, 5, null);
			//帖子对应版块名
			Forummanagement forum = biz.queryTitleName(pfmid);
			model.addAttribute("HOT", hotPost);
			model.addAttribute("FORUM", forum);
			model.addAttribute("FMNAME", fmname);
			model.addAttribute("NEWLIST", newList);
			model.addAttribute("POSTVO", pv);
			model.addAttribute("PAGE_INFO", pageInfo);
			model.addAttribute("user", user);
			return "/zrb/Html/lt-postDetail";
//		}
	}

	/**
	 * 显示我的韩汀论坛中我的发帖、我的收藏、我的回复列表
	 * @param page
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("myPost")
	public String toMyForum(Integer type,@RequestParam(defaultValue="1")Integer page,@RequestParam(required=false)String title,Model model,HttpSession session) {
		User user = (User)session.getAttribute("userinfo");
		if(user==null) {
			return "/zrb/Html/MSG";
		}else {
			PageInfo<PostVo> myPostList = null;
			//显示版块
			List<Forummanagement> list = biz.queryBlock();
			model.addAttribute("BLIST", list);
			if(type==1) {
				//显示我的发帖
				myPostList = biz.queryMyForum(page, 3, user.getUserid(),title);
			}else if(type==2) {
				//显示我的收藏
				myPostList = biz.queryMyCollection(page, 3, user.getUserid(), title);
			}else {
				//显示我的回复
				myPostList = biz.queryMyComment(page, 3, user.getUserid(), title);
			}
			model.addAttribute("MYPOST_PAGE", myPostList);
			return "/zrb/Html/lt-myforum";
		}
	}

	/**
	 * 收藏并验证重复和验证是否自己的帖子
	 * @param postId
	 * @param session
	 * @return
	 */
	@PostMapping("saveCollection")
	@ResponseBody
	public Map<String,String> checkCollection(@RequestBody Postcollection collec,HttpSession session){
		User user = (User)session.getAttribute("userinfo");
		Map<String,String> map=new HashMap<>();
		if(user==null){
			map.put("code", "100");
		}else{
			collec.setUserid(user.getUserid());
			//验证点赞重复
			int rCol = biz.checkHasCollection(collec.getPcid(), user.getUserid());
			//验证是否点赞自己帖子
			int rSef = biz.checkIsSelf(collec.getPcid(), user.getUserid());
			if(rCol>0) {
				map.put("code", "300");
			}else if(rSef>0) {
				map.put("code", "400");
			}else {
				biz.saveCollection(collec);
				map.put("code", "200");
			}
		}
		return map;
	}

	/**
	 * 点赞并验证重复和验证是否自己的帖子
	 * @param fabu
	 * @param session
	 * @return
	 */
	@PostMapping("saveFabulous")
	@ResponseBody
	public Map<String,String> checkFabulous(@RequestBody Postfabulous fabu,HttpSession session){
		User user = (User)session.getAttribute("userinfo");
		Map<String,String> map=new HashMap<>();
		if(user==null){
			map.put("code", "100");
		}else{
			fabu.setUserid(user.getUserid());
			//验证点赞重复
			int rCol = biz.checkHasFabulous(fabu.getPostid(), fabu.getUserid());
			//验证是否点赞自己帖子
			int rSef = biz.checkIsSelf(fabu.getPostid(), fabu.getUserid());
			if(rCol>0) {
				int status=biz.selectFabulousStatus(fabu);
				if(status==1) {
					map.put("code", "300");
					fabu.setStatus(2);
					biz.cancelFabulous(fabu);
				}else if(status==2) {
					map.put("code", "301");
					fabu.setStatus(1);
					biz.cancelFabulous(fabu);
				}
			}else if(rSef>0) {
				map.put("code", "400");
			}else {
				biz.saveFabulous(fabu);
				map.put("code", "200");
			}
		}
		return map;
	}
	
	@GetMapping("queryLastcomment")
	@ResponseBody
	public Postcomment queryLastComment(Integer userId,Integer postId) {
		Postcomment p=biz.queryLastComment(userId,postId);
		if(p==null) {
			return new Postcomment(-1, null, null, null, null, null, null);
		}else {
			return p;
		}
		
	}

	/**
	 * 评论
	 * @param comm
	 * @return
	 */
	@PostMapping("saveComment")
	@ResponseBody
	public Map<String,String> saveComment(@RequestBody Postcomment comm){
		Map<String,String> map=new HashMap<>();
		int result = biz.queryCommentCount(comm.getCommentator());
		int commuser = biz.queryCommentAtor(comm.getPostid());
		biz.saveComment(comm);
		if(result>10||commuser==comm.getCommentator()) {
			map.put("code", "200");
		}else {
			map.put("code", "300");
			biz.updateCommentJIntegral(comm);
		}
		return map;
	}
	
	/**
	 * 删除评论回复
	 * @param pcid
	 * @return
	 */
	@PostMapping("removeComment")
	@ResponseBody
	public Map<String,String> removeComment(Integer pcid){
		Map<String,String> map=new HashMap<>();
		biz.removeComment(pcid);
		map.put("code", "200");
		return map;
	}
		
	/**
	 * 跳转编辑帖子页面
	 * @param postvo
	 * @param model
	 * @return
	 */
	@GetMapping("toUpdatePost")
	public String toUpdatePost(Integer postId,Model model) {
			//显示版块下拉框
			PostVo postvo = biz.queryPostDetail(postId);
			List<Forummanagement> list = biz.queryBlock();
			model.addAttribute("BLIST", list);
			model.addAttribute("pid", postvo.getForum().getPid());
			model.addAttribute("fmid", postvo.getForum().getFmid());
			model.addAttribute("POST", postvo);
			return "/zrb/Html/lt-updateforum";
	}
	
	@PostMapping("updatePost")
	@ResponseBody
	public Map<String,String> updatePost(@RequestBody Post post){		
		Map<String,String> map=new HashMap<>();
		biz.updatePost(post);
		map.put("code", "200");
		return map;
	}
	
	@GetMapping("toCenter")
	public String toCenter(Integer userId,Integer type,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="10")Integer size,@RequestParam(required=false)String title,Model model) {
		PageInfo<PostVo> userPostList = null;
		User user = biz.queryUserInfo(userId);
		userPostList = biz.queryMyForum(page, size, userId,title);
		//显示最新动态
		if(type==1) {
			model.addAttribute("postList",biz.queryMyForum(page, size, userId,title));
			model.addAttribute("postCollection",biz.queryMyCollection(page, size, userId, title));
			model.addAttribute("postComment",biz.queryMyComment(page, size, userId, title));
		}else if(type==2) {
			//显示用户的发帖
			userPostList = biz.queryMyForum(page, size, userId,title);
		}else if(type==4) {
			//显示用户的收藏
			userPostList = biz.queryMyCollection(page, size, userId, title);
		}else if(type==3){
			//显示用户的回复
			userPostList = biz.queryMyComment(page, size, userId, title);
		}
		model.addAttribute("type", type);
		model.addAttribute("user", user);
		model.addAttribute("user_center", userPostList);
		return "/zrb/Html/zjw-dongtai";
	}
	
	
	@GetMapping("showShareInfo")
	@ResponseBody
	public List<ShareInfoVO> showShareInfo(HttpSession session){
		User user = (User)session.getAttribute("userinfo");
		List<ShareInfoVO> list = biz.showShareInfo(user.getUserid());
		return list;
	}
	
	
	@PostMapping("addComplaint")
	@ResponseBody
	public Map<String,String> addComplaint(@RequestBody Complaint complaint,HttpSession session){
		User user = (User)session.getAttribute("userinfo");
		Map<String,String> map=new HashMap<String,String>();
		if(user==null){
			map.put("code", "100");
		}else{
			complaint.setUserid(user.getUserid());
			//先验证是否举报自己
			if(complaint.getUserid()==complaint.getPosting()) {
				map.put("code", "600");
			}else {
				//验证是否当天举报次数超过5次
				int complaintCount=biz.selectTodayCount(user.getUserid());
				if(complaintCount<=5) {
					//验证是否举报过该用户（正在审核中的）
					int checkCount=biz.checkIsComplaint(user.getUserid(),complaint.getPcid());
					if(checkCount>0) {
						map.put("code", "200");
					}else {
						int count=biz.addComplaint(complaint);
						if(count>0) {
							map.put("code", "300");
						}else {
							map.put("code", "400");
						}
					}
				}else {
					//超过举报次数
					map.put("code", "500");
				}
			}
		}
		return map;
	}

}
