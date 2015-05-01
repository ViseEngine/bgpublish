/**
 * 
 */
package com.bgpublish.service;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Store;
import com.bgpublish.mapper.StoreMapper;

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
	public void addStore(Store store){
		this.storeMapper.addStore(store);
	}
	/**
	 * 更新商家信息
	 * @param store 商家信息
	 */
	public void updateStore(Store store){
		this.storeMapper.updateStore(store);
	}
	/**
	 * 根据商家ID删除商家
	 * @param store_id 商家ID
	 */
	public void deleteStoreById(String store_id){
		this.storeMapper.deleteStoreById(store_id);
	}
	/**
	 * 根据商家ID查询商家
	 * @param store_id 商家ID
	 * @return 返回商家信息
	 */
	public Store queryStoreById(String store_id){
		return this.storeMapper.queryStoreById(store_id);
	}
}
