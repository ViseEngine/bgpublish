/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.MerchCar;

/**
 * 购物车服务类
 * @author ps
 *
 */
public interface MerchCarService {
	/**
	 * 添加商品到购物车中
	 * @param merchCar
	 */
	public void addMerchCar(MerchCar merchCar);
	/**
	 * 更新购物车中的购买数量等信息
	 * @param merchCar
	 */
	public void updateMerchCar(MerchCar merchCar);
	/**
	 * 更新购买数量
	 * @param merchCar
	 */
	public void updateMerchCarBy(MerchCar merchCar);
	/**
	 * 删除购物车商品信息
	 * @param merchCar
	 */
	public void deleteMerchCarBy(MerchCar merchCar);
	/**
	 * 根据用户查询该用户的购物车中商品信息
	 * @param user_id
	 * @return 
	 */
	public List<MerchCar> queryMerchCarByUser(String user_id);
}
