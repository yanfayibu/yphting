package com.accp.vo.hzj;

import java.util.Date;

import com.accp.pojo.Advertisement;

public class AdvertisementVO extends Advertisement{
	private ImageWidthAndHeightVO whObj;	//广告大小对象

	public ImageWidthAndHeightVO getWhObj() {
		return whObj;
	}

	public void setWhObj(ImageWidthAndHeightVO whObj) {
		this.whObj = whObj;
	}

	public AdvertisementVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvertisementVO(Integer aid, Integer atid, String atitle, Integer aorder, String aimgpath, String apcurl,
			String aappurl, Boolean state, Date starttime, Integer rentamonth, Float price, String adescribe) {
		super(aid, atid, atitle, aorder, aimgpath, apcurl, aappurl, state, starttime, rentamonth, price, adescribe);
		// TODO Auto-generated constructor stub
	}
	
}