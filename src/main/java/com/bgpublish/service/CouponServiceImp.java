/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Coupon;
import com.bgpublish.mapper.CouponMapper;
import com.github.pagehelper.PageHelper;

/**
 * 优惠券信息服务接口
 * @author ps
 *
 */
@Service
public class CouponServiceImp implements CouponService {
	
	private @Autowired @Getter @Setter CouponMapper couponMapper;
	/**
	 * 新增优惠券信息
	 * @param coupon 优惠券信息
	 */
	public void addCoupon(Coupon coupon){
		this.couponMapper.addCoupon(coupon);
	}
	
	/**
	 * 根据优惠ID删除优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	public void deleteCouponById(String coupon_id){
		this.couponMapper.deleteCouponById(coupon_id);
	}
	
	/**
	 * 更新优惠券信息
	 * @param coupon 优惠券信息
	 */
	public void updateCoupon(Coupon coupon){
		this.couponMapper.updateCoupon(coupon);
	}
	
	/**
	 * 根据ID查询优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	public List<Coupon> queryByCouponId(String coupon_id){
		return this.couponMapper.queryByCouponId(coupon_id);
	}
	/**
	 * 根据ID查询优惠券信息(分页)
	 * @param coupon_id 优惠券ID
	 * @param start
	 * @param limit
	 */
	public List<Coupon> queryByCouponIdPage(String coupon_id,int start,int limit){
		PageHelper.startPage(start, limit);
		return this.couponMapper.queryByCouponId(coupon_id);
	}
	
	/**
	 * 根据ID查询优惠券信息
	 * @param user_id 用户ID
	 */
	public List<Coupon> queryByUserId(String user_id){
		return this.couponMapper.queryByUserId(user_id);
	}
	/**
	 * 根据ID查询优惠券信息
	 * @param user_id 用户ID
	 * @param start
	 * @param limit
	 */
	public List<Coupon> queryByUserIdPage(String user_id,int start,int limit){
		PageHelper.startPage(start, limit);
		return this.couponMapper.queryByUserId(user_id);
	}
	/**
	 * 根据ID查询我的优惠券信息
	 * @param map 参数
	 */
	public List<Coupon> queryByCouponUserId(Map<String,String> map){
		return this.couponMapper.queryByCouponUserId(map);
	}
}
