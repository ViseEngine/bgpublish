/**
 * 
 */
package com.bgpublish.service;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.UserCoupon;
import com.bgpublish.mapper.UserCouponMapper;

/**
 * 用户优惠券信息
 * @author ps
 *
 */
@Service
public class UserCouponServiceImp implements UserCouponService {
	
	private @Autowired @Setter @Getter UserCouponMapper userCouponMapper;
	/**
	 * 新增用户优惠券信息
	 * @param userCoupon 优惠券信息
	 */
	public void addUserCoupon(UserCoupon userCoupon){
		this.userCouponMapper.addUserCoupon(userCoupon);
	}
	
	
	/**
	 * 更新用户优惠券信息
	 * @param userCoupon 用户优惠券信息
	 */
	public void updateUserCoupon(UserCoupon userCoupon){
		this.userCouponMapper.updateUserCoupon(userCoupon);
	}
	
}
