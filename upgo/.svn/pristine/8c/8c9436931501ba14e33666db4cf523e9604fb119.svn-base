
package com.upgo.service;

import java.util.ArrayList;

import com.upgo.dao.CouponDao;
import com.upgo.dto.CouponReceived;

public class CouponService {

	public void issueCoupon (CouponReceived newCoupon) {
		 CouponDao couponDao = new CouponDao();
		 couponDao.insertReceivedCoupon(newCoupon);
	}
	public ArrayList<CouponReceived> findReceivedCoupon(String memberId) {
		CouponDao couponDao = new CouponDao();
		ArrayList<CouponReceived> couponList = couponDao.selectCouponReceivedByMemberId(memberId);
		return couponList;

	}

}