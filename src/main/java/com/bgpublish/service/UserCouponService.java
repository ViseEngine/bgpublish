/**
 * 
 */
package com.bgpublish.service;

import com.bgpublish.domain.UserCoupon;

/**
 * 用户优惠券信息
 * @author ps
 *
 */
public interface UserCouponService {
	/**
	 * 新增用户优惠券信息
	 * @param userCoupon 优惠券信息
	 */
	public void addUserCoupon(UserCoupon userCoupon);
	
	
	/**
	 * 更新用户优惠券信息
	 * @param userCoupon 用户优惠券信息
	 */
	public void updateUserCoupon(UserCoupon userCoupon);
	
}
