/**
 * 
 */
package com.bgpublish.web;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.Coupon;
import com.bgpublish.service.CouponService;
import com.bgpublish.util.HttpUtil;

/**
 * 商家优惠信息Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/coupon")
public class CouponController {
	private static final Log LOGGER = LogFactory.getLog(CouponController.class);
	private @Autowired @Getter @Setter CouponService couponService;
	
	/**
	 * 新增优惠券信息
	 * @param coupon 优惠券信息
	 */
	@RequestMapping(value="/addCoupon.do", method = RequestMethod.POST)
	public ResponseEntity<String> addCoupon(@RequestBody Coupon coupon){
		try{
			this.couponService.addCoupon(coupon);
		}catch(Exception e){
			LOGGER.error("新增优惠券信息失败!",e);
			return HttpUtil.createOkResponseEntity("新增优惠券信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("新增优惠券信息成功!");
	}
	
	/**
	 * 根据优惠ID删除优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	@RequestMapping(value="/deleteCouponById.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteCouponById(@RequestParam String coupon_id){
		try{
			this.couponService.deleteCouponById(coupon_id);
		}catch(Exception e){
			LOGGER.error("删除优惠券信息失败!",e);
			return HttpUtil.createOkResponseEntity("删除优惠券信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("删除优惠券信息成功!");
	}
	
	/**
	 * 更新优惠券信息
	 * @param coupon 优惠券信息
	 */
	@RequestMapping(value="/updateCoupon.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateCoupon(@RequestBody Coupon coupon){
		try{
			this.couponService.updateCoupon(coupon);
		}catch(Exception e){
			LOGGER.error("更新优惠券信息失败!",e);
			return HttpUtil.createOkResponseEntity("更新优惠券信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("更新优惠券信息成功!");
	}
	
	/**
	 * 根据ID查询优惠券信息
	 * @param coupon_id 优惠券ID
	 */
	@RequestMapping(value="/queryByCouponId.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Coupon> queryByCouponId(@RequestParam String coupon_id){
		
		return this.couponService.queryByCouponId(coupon_id);
	}
	/**
	 * 根据ID查询优惠券信息(分页)
	 * @param coupon_id 优惠券ID
	 */
	@RequestMapping(value="/queryByCouponIdPage.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Coupon> queryByCouponIdPage(@RequestParam String coupon_id,@RequestParam int start,@RequestParam int limit){
		
		return this.couponService.queryByCouponIdPage(coupon_id,start,limit);
	}
	/**
	 * 根据ID查询优惠券信息
	 * @param user_id 用户ID
	 */
	@RequestMapping(value="/queryByUserId.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Coupon> queryByUserId(@RequestParam String user_id){
		
		return this.couponService.queryByUserId(user_id);
	}
	/**
	 * 根据ID查询优惠券信息(分页)
	 * @param user_id 用户ID
	 */
	@RequestMapping(value="/queryByUserIdPage.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Coupon> queryByUserIdPage(@RequestParam String user_id,@RequestParam int start,@RequestParam int limit){
		
		return this.couponService.queryByUserIdPage(user_id,start,limit);
	}
	/**
	 * 根据ID查询我的优惠券信息
	 * @param map 参数
	 */
	@RequestMapping(value="/queryByCouponUserId.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Coupon> queryByCouponUserId(@RequestBody Map<String,String> map){
		return this.couponService.queryByCouponUserId(map);
	}
}
