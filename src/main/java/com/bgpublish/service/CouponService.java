/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.Coupon;

/**
 * 优惠券信息服务接口
 * @author ps
 *
 */
public interface CouponService {
	/**
	 * 新增优惠券信息
	 * @param coupon 优惠券信息
	 */
	public void addCoupon(Coupon coupon);
	
	/**
	 * 根据优惠ID删除优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	public void deleteCouponById(String coupon_id);
	
	/**
	 * 更新优惠券信息
	 * @param coupon 优惠券信息
	 */
	public void updateCoupon(Coupon coupon);
	
	/**
	 * 根据ID查询优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	public List<Coupon> queryByCouponId(String coupon_id);
	/**
	 * 根据ID查询优惠券信息(分页)
	 * @param coupon_id 优惠券ID
	 * @param start
	 * @param limit
	 */
	public List<Coupon> queryByCouponIdPage(String coupon_id,int start,int limit);
	/**
	 * 根据ID查询优惠券信息
	 * @param user_id 用户ID
	 */
	public List<Coupon> queryByUserId(String user_id);
	/**
	 * 根据ID查询优惠券信息
	 * @param user_id 用户ID
	 * @param start
	 * @param limit
	 */
	public List<Coupon> queryByUserIdPage(String user_id,int start,int limit);
}
