/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;

import com.bgpublish.domain.MerchDisacount;

/**
 * 商品优惠信息
 * @author ps
 *
 */
public interface DisacountMapper {
	/**
	 * 新增商品优惠信息
	 * @param merchDisacount 商品优惠信息
	 */
	public void addDisacount(MerchDisacount merchDisacount);
	
	/**
	 * 根据商品优惠ID删除商品优惠信息
	 * @param diacount_id 商品优惠ID
	 */
	public void deleteDisacountById(String diacount_id);
	
	/**
	 * 更新商品优惠信息
	 * @param merchDisacount 商品优惠信息
	 */
	public void updateDisacount(MerchDisacount merchDisacount);
	
	/**
	 * 根据商品ID查询商品优惠信息
	 * @param merch_id 商品ID
	 */
	public List<MerchDisacount> queryByMerchId(String merch_id);
	/**
	 * 根据商品ID查询商品优惠信息,查询所有
	 * @param merch_id 商品ID
	 */
	public List<MerchDisacount> queryAllByMerchId(String merch_id);
	/**
	 * 根据商品ID查询商品优惠信息，查询一条记录
	 * @param merch_id 商品ID
	 */
	public MerchDisacount queryFirstByMerchId(String merch_id);
}
