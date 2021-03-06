/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;

import com.bgpublish.domain.Merch;
import com.bgpublish.domain.User;

/**
 * 商品服务接口
 * @author ps
 *
 */
public interface MerchService {
	/**
	 * 添加商品
	 * @param merch
	 */
	public void addMerch(Merch merch);
	/**
	 * 根据ID查询商家信息
	 * @param merchIds
	 * @return
	 */
	public List<Map<String,Object>> queryStoreByMerchId(List<String> merchIds);
	/**
	 * 更新商品
	 * @param merch
	 */
	public void updateMerch(Merch merch);
	/**
	 * 根据商品ID删除商品
	 * @param merch_id 商品ID
	 */
	public void deleteMerchById(String merch_id);
	/**
	 * 根据商家ID删除商品
	 * @param store_id 商家ID
	 */
	public void deleteMerchByStoreId(String merch_id);
	/**
	 * 根据商品ID查询商品信息
	 * @param merch_id 商品ID
	 * @return
	 */
	public Merch queryMerchById(String merch_id);
	/**
	 * 根据商品ID查询商家用户信息
	 * @param merch_id 商品ID
	 * @return
	 */
	public User queryUserById(String merch_id);
	/**
	 * 根据商家ID查询商品信息
	 * @param store_id 商家ID
	 * @return
	 */
	public List<Merch> queryMerchByStoreId(String store_id);
	/**
	 * 查询商品信息，会按创建时间倒序
	 * @param map 查询条件
	 * @return
	 */
	public List<Merch> queryMerchByMap(Map<String,String> map);
	/**
	 * 根据用户ID查询商品信息
	 * @param user_id 用户ID
	 * @return
	 */
	public List<Merch> queryMerchByUserId(String user_id);
	/**
	 * 根据输入的条件（包括用户ID、是否下架、分类等）查询商品信息
	 * @param merch 商品信息
	 * @return
	 */
	public List<Merch> queryMerchBy(Merch merch);
	/**
	 * 根据输入的条件（包括用户ID、是否下架、分类等）查询商品信息
	 * @param merch 商品信息
	 * @param start 开始
	 * @param limit 条数
	 * @return
	 */
	public List<Merch> queryMerchByPage(Merch merch,int start, int limit);
	/**
	 * 批量更新商品信息
	 * @param merchList 商品列表
	 * @return 更新状态
	 */
	public void updateMerchBatch(List<Merch> merchList);
}
