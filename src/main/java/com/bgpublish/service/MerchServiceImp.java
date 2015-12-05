/**
 * 
 */
package com.bgpublish.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Merch;
import com.bgpublish.domain.User;
import com.bgpublish.mapper.GalleryMapper;
import com.bgpublish.mapper.MerchMapper;
import com.github.pagehelper.PageHelper;

/**
 * @author ps
 *
 */
@Service
public class MerchServiceImp implements MerchService {
	
	private @Autowired @Getter @Setter MerchMapper merchMapper;
	private @Autowired @Getter @Setter GalleryMapper galleryMapper;

	/**
	 * 添加商品
	 * @param merch
	 */
	public void addMerch(Merch merch){
		this.merchMapper.addMerch(merch);
	}
	/**
	 * 根据ID查询商家信息
	 * @param merchIds
	 * @return
	 */
	public List<Map<String,Object>> queryStoreByMerchId(List<String> merchIds){
		return this.merchMapper.queryStoreByMerchId(merchIds);
	}
	/**
	 * 更新商品
	 * @param merch
	 */
	public void updateMerch(Merch merch){
		this.merchMapper.updateMerch(merch);
	}
	/**
	 * 根据商品ID删除商品
	 * @param merch_id 商品ID
	 */
	public void deleteMerchById(String merch_id){
		this.merchMapper.deleteMerchById(merch_id);
		
		//删除图片
		Map<String,String> map = new HashMap<String,String>();
		map.put("merch_id", merch_id);
		this.galleryMapper.deleteGallery(map);
		
		
	}
	/**
	 * 根据商家ID删除商品
	 * @param store_id 商家ID
	 */
	public void deleteMerchByStoreId(String merch_id){
		this.merchMapper.deleteMerchByStoreId(merch_id);
	}
	/**
	 * 根据商品ID查询商品信息
	 * @param merch_id 商品ID
	 * @return
	 */
	public Merch queryMerchById(String merch_id){
		return this.merchMapper.queryMerchById(merch_id);
	}
	/**
	 * 根据商品ID查询商家用户信息
	 * @param merch_id 商品ID
	 * @return
	 */
	public User queryUserById(String merch_id){
		return this.merchMapper.queryUserById(merch_id);
	}
	/**
	 * 根据商家ID查询商品信息
	 * @param store_id 商家ID
	 * @return
	 */
	public List<Merch> queryMerchByStoreId(String store_id){
		return this.merchMapper.queryMerchByStoreId(store_id);
	}
	/**
	 * 查询商品信息，会按创建时间倒序
	 * @param map 查询条件
	 * @return
	 */
	public List<Merch> queryMerchByMap(Map<String,String> map){
		return this.merchMapper.queryMerchByMap(map);
	}
	/**
	 * 根据用户ID查询商品信息
	 * @param user_id 用户ID
	 * @return
	 */
	public List<Merch> queryMerchByUserId(String user_id){
		return this.merchMapper.queryMerchByUserId(user_id);
	}

	/**
	 * 根据输入的条件（包括用户ID、是否下架、分类等）查询商品信息
	 * @param merch 商品信息
	 * @return
	 */
	@Override
	public List<Merch> queryMerchBy(Merch merch) {
		return this.merchMapper.queryMerchBy(merch);
	}
	/**
	 * 根据输入的条件（包括用户ID、是否下架、分类等）查询商品信息
	 * @param merch 商品信息
	 * @param start 开始
	 * @param limit 条数
	 * @return
	 */
	public List<Merch> queryMerchByPage(Merch merch,int start, int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		return this.merchMapper.queryMerchBy(merch);
	}

	/**
	 * 批量更新商品信息
	 * @param merchList 商品列表
	 * @return 更新状态
	 */
	@Override
	public void updateMerchBatch(List<Merch> merchList) {
		this.merchMapper.updateMerchBatch(merchList);
	}
}
