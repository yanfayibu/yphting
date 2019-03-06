
package com.accp.vo.lz;

import java.util.Date;

import com.accp.pojo.User;
import com.alibaba.fastjson.annotation.JSONField;

@SuppressWarnings("all")
public class NewVO {
	
	private Integer newsid;          //消息编号

	private User sender; //发件人
    
    private User ressee; //收件人

    @JSONField(format="yyyy-MM-dd HH:mm:ss ")
    private Date sendingtime;        //发送时间

    private Boolean readstate;       //是否已读

    private Integer newstype;        //消息类型，1：系统消息，2：站内信

    private Integer messagegroup;    //消息组编号

    private String content;          //内容

	/**  
	 * @Title:  getNewsid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getNewsid() {
		return newsid;
	}

	/**  
	 * @Title:  setNewsid <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	
	/**  
	 * @Title:  getSendingtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public Date getSendingtime() {
		return sendingtime;
	}

	/**  
	 * @Title:  setSendingtime <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Date <BR>  
	 */
	public void setSendingtime(Date sendingtime) {
		this.sendingtime = sendingtime;
	}

	/**  
	 * @Title:  getReadstate <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Boolean <BR>  
	 */
	public Boolean getReadstate() {
		return readstate;
	}

	/**  
	 * @Title:  setReadstate <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Boolean <BR>  
	 */
	public void setReadstate(Boolean readstate) {
		this.readstate = readstate;
	}

	/**  
	 * @Title:  getNewstype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getNewstype() {
		return newstype;
	}

	/**  
	 * @Title:  setNewstype <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setNewstype(Integer newstype) {
		this.newstype = newstype;
	}

	/**  
	 * @Title:  getMessagegroup <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getMessagegroup() {
		return messagegroup;
	}

	/**  
	 * @Title:  setMessagegroup <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setMessagegroup(Integer messagegroup) {
		this.messagegroup = messagegroup;
	}

	/**  
	 * @Title:  getContent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getContent() {
		return content;
	}

	/**  
	 * @Title:  setContent <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setContent(String content) {
		this.content = content;
	}

	
	/**  
	 * @Title:  getSender <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getSender() {
		return sender;
	}

	/**  
	 * @Title:  setSender <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**  
	 * @Title:  getRessee <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public User getRessee() {
		return ressee;
	}

	/**  
	 * @Title:  setRessee <BR>  
	 * @Description: please write your description <BR>  
	 * @return: User <BR>  
	 */
	public void setRessee(User ressee) {
		this.ressee = ressee;
	}

	/**   
	 * @Title:  NewVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param newsid
	 * @param:  @param sender
	 * @param:  @param ressee
	 * @param:  @param sendingtime
	 * @param:  @param readstate
	 * @param:  @param newstype
	 * @param:  @param messagegroup
	 * @param:  @param content  
	 * @throws   
	 */
	public NewVO(Integer newsid, User sender, User ressee, Date sendingtime, Boolean readstate, Integer newstype,
			Integer messagegroup, String content) {
		super();
		this.newsid = newsid;
		sender = sender;
		ressee = ressee;
		this.sendingtime = sendingtime;
		this.readstate = readstate;
		this.newstype = newstype;
		this.messagegroup = messagegroup;
		this.content = content;
	}

	/**   
	 * @Title:  NewVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param newsid  
	 * @throws   
	 */
	public NewVO(Integer newsid) {
		super();
		this.newsid = newsid;
	}

	/**   
	 * @Title:  NewVO   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public NewVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**   
	 * <p>Title: toString</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "NewVO [newsid=" + newsid + ", Sender=" + sender + ", Ressee=" + ressee + ", sendingtime=" + sendingtime
				+ ", readstate=" + readstate + ", newstype=" + newstype + ", messagegroup=" + messagegroup
				+ ", content=" + content + "]";
	}
    
    
	

}
