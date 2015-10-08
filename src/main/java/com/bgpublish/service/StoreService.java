/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.Store;

/**
 * 商家 服务信息接口
 * 
 * @author pansen
 *
 */
public interface StoreService {
	/**
	 * 新增商家
	 * @param store 商家信息
	 */
	public void addStore(Store store);
	/**
	 * 更新商家信息
	 * @param store 商家信息
	 */
	public void updateStore(Store store);
	/**
	 * 根据商家ID删除商家
	 * @param store_id 商家ID
	 */
	public void deleteStoreById(String store_id);
	/**
	 * 根据商家ID查询商家
	 * @param store_id 商家ID
	 * @return 返回商家信息
	 */
	public Store queryStoreById(String store_id);
	/**
	 * 根据用户ID查询商家
	 * @param user_id 用户ID
	 * @return 返回商家信息
	 */
	public Store queryStoreByUserId(String user_id);
	/**
	 * 按销量大小查询商家信息
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreBySalesVolume();
	/**
	 * 按收藏数查询商家信息
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreByFavoriteCount();
	/**
	 * 按销量大小查询商家信息(分页)
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreBySalesVolume(int start,int limit);
	/**
	 * 按收藏数查询商家信息(分页)
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreByFavoriteCount(int start,int limit);
}
