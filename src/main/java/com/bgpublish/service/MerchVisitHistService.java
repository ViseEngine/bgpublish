/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.MerchVisitHist;

/**
 * 商品访问历史接口
 * @author ps
 *
 */
public interface MerchVisitHistService {
	/**
	 * 增加商品访问信息
	 * @param merchVisitHist
	 */
	public void addMerchVisitHist(MerchVisitHist merchVisitHist);
	/**
	 * 根据用户ID查询商品访问信息
	 * @param user_id
	 * @return
	 */
	public List<MerchVisitHist> queryByUserId(String user_id);
	/**
	 * 根据商品ID查询商品访问信息
	 * @param merch_id
	 * @return
	 */
	public List<MerchVisitHist> queryByMerchId(String merch_id);
}
