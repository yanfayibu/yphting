package com.accp.vo.lz;

/**
 * 
 * @Description TODO 
 * @author 荔枝
 * @version v1.0
 * @date 2019年3月26日
 */
public class TotalRetrieveVo {

	private Integer userID;//用户id
	private Integer serviceID;//服务id
	private Integer stID;//类别id
	private String stName;//服务类别的名称
	private String resouroeName;//资料名称
	private String serviceTitle;	//服务标题
	private String serviceFuTitle;//服务的副标题
	private String serviceCity;//服务的城市
	private String serviceCoverImg;	//服务封面图路径
	private Integer servicePrice;	//服务价格
	private Integer browseNumber;//	商家被浏览数
	private boolean recommendBool;	//商家推荐
	private String shopImg;	//店铺图片路径
	private String shopName;	//店铺名
	private float merchantLevel;//商家星级
	
	
	
	/**  
	 * @Title:  getStID <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getStID() {
		return stID;
	}
	/**  
	 * @Title:  setStID <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setStID(Integer stID) {
		this.stID = stID;
	}
	public Integer getBrowseNumber() {
		return browseNumber;
	}
	public void setBrowseNumber(Integer browseNumber) {
		this.browseNumber = browseNumber;
	}
	public String getResouroeName() {
		return resouroeName;
	}
	public void setResouroeName(String resouroeName) {
		this.resouroeName = resouroeName;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public String getServiceCity() {
		return serviceCity;
	}
	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	public Integer getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	public boolean isRecommendBool() {
		return recommendBool;
	}
	public void setRecommendBool(boolean recommendBool) {
		this.recommendBool = recommendBool;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public float getMerchantLevel() {
		return merchantLevel;
	}
	public void setMerchantLevel(float merchantLevel) {
		this.merchantLevel = merchantLevel;
	}
	
	public TotalRetrieveVo(Integer userID, Integer serviceID, String stName, String resouroeName, String serviceTitle,
			String serviceFuTitle, String serviceCity, String serviceCoverImg, Integer servicePrice,
			boolean recommendBool, String shopImg, String shopName, float merchantLevel, Integer browseNumber) {
		super();
		this.userID = userID;
		this.serviceID = serviceID;
		this.stName = stName;
		this.resouroeName = resouroeName;
		this.serviceTitle = serviceTitle;
		this.serviceFuTitle = serviceFuTitle;
		this.serviceCity = serviceCity;
		this.serviceCoverImg = serviceCoverImg;
		this.servicePrice = servicePrice;
		this.recommendBool = recommendBool;
		this.shopImg = shopImg;
		this.shopName = shopName;
		this.merchantLevel = merchantLevel;
		this.browseNumber = browseNumber;
	}
	public TotalRetrieveVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TotalRetrieveVo [userID=" + userID + ", serviceID=" + serviceID + ", stName=" + stName
				+ ", serviceTitle=" + serviceTitle + ", serviceFuTitle=" + serviceFuTitle + ", serviceCity="
				+ serviceCity + ", serviceCoverImg=" + serviceCoverImg + ", servicePrice=" + servicePrice
				+ ", recommendBool=" + recommendBool + ", shopImg=" + shopImg + ", shopName=" + shopName
				+ ", merchantLevel=" + merchantLevel + "]";
	}
}
