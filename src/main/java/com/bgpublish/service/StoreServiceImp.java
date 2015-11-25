/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Store;
import com.bgpublish.mapper.StoreMapper;
import com.github.pagehelper.PageHelper;

/**
 * 商家服务信息实现类
 * @author ps
 *
 */
@Service
public class StoreServiceImp implements StoreService {

	private @Autowired @Getter @Setter StoreMapper storeMapper;
	
	/**
	 * 新增商家
	 * @param store 商家信息
	 */
	@Override
	public void addStore(Store store){
		this.storeMapper.addStore(store);
	}
	/**
	 * 更新商家信息
	 * @param store 商家信息
	 */
	@Override
	public void updateStore(Store store){
		this.storeMapper.updateStore(store);
	}
	/**
	 * 根据商家ID删除商家
	 * @param store_id 商家ID
	 */
	@Override
	public void deleteStoreById(String store_id){
		this.storeMapper.deleteStoreById(store_id);
	}
	/**
	 * 根据商家ID查询商家
	 * @param store_id 商家ID
	 * @return 返回商家信息
	 */
	@Override
	public Store queryStoreById(String store_id){
		return this.storeMapper.queryStoreById(store_id);
	}
	
	/**
	 * 根据用户ID查询商家
	 * @param user_id 用户ID
	 * @return 返回商家信息
	 */
	@Override
	public Store queryStoreByUserId(String user_id){
		return this.storeMapper.queryStoreByUserId(user_id);
	}
	/**
	 * 按销量大小查询商家信息
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreBySalesVolume(){
		return this.storeMapper.queryStoreBySalesVolume();
	}
	/**
	 * 按收藏数查询商家信息
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreByFavoriteCount(){
		return this.storeMapper.queryStoreByFavoriteCount();
	}
	/**
	 * 按销量大小查询商家信息(分页)
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreBySalesVolume(int start,int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		return this.storeMapper.queryStoreBySalesVolume();
	}
	/**
	 * 按收藏数查询商家信息(分页)
	 * @return 返回商家信息
	 */
	public List<Store> queryStoreByFavoriteCount(int start,int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		return this.storeMapper.queryStoreByFavoriteCount();
	}
}
