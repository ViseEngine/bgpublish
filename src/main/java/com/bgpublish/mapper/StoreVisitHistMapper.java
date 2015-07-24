/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;

import com.bgpublish.domain.StoreVisitHist;
import com.bgpublish.domain.VisitStat;

/**
 * 商家访问历史接口
 * @author ps
 *
 */
public interface StoreVisitHistMapper {
	/**
	 * 增加商家访问信息
	 * @param storeVisitHist
	 */
	public void addStoreVisitHist(StoreVisitHist storeVisitHist);
	/**
	 * 根据用户ID查询商家访问信息
	 * @param user_id
	 * @return
	 */
	public List<StoreVisitHist> queryByUserId(String user_id);
	/**
	 * 根据商家ID查询商家访问信息
	 * @param store_id
	 * @return
	 */
	public List<StoreVisitHist> queryByStoreId(String store_id);
	/**
	 * 按天统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	public VisitStat countByDayAndUser(VisitStat visitStat);
	/**
	 * 按天分时统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	public List<VisitStat> countByDayHourAndUser(VisitStat visitStat);
}
