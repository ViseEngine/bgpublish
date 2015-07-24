/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.StoreVisitHist;
import com.bgpublish.domain.VisitStat;
import com.bgpublish.mapper.StoreVisitHistMapper;

/**
 * 商家访问历史服务类
 * @author ps
 *
 */
@Service
public class StoreVisitHistServiceImp implements StoreVisitHistService{
	
	private @Autowired @Setter @Getter StoreVisitHistMapper storeVisitHistMapper;
	/**
	 * 增加商家访问信息
	 * @param storeVisitHist
	 */
	public void addStoreVisitHist(StoreVisitHist storeVisitHist){
		this.storeVisitHistMapper.addStoreVisitHist(storeVisitHist);
	}
	/**
	 * 根据用户ID查询商家访问信息
	 * @param user_id
	 * @return
	 */
	public List<StoreVisitHist> queryByUserId(String user_id){
		return this.storeVisitHistMapper.queryByUserId(user_id);
	}
	/**
	 * 根据商家ID查询商家访问信息
	 * @param store_id
	 * @return
	 */
	public List<StoreVisitHist> queryByStoreId(String store_id){
		return this.storeVisitHistMapper.queryByStoreId(store_id);
	}
	/**
	 * 按天统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	public VisitStat countByDayAndUser(VisitStat visitStat){
		return this.storeVisitHistMapper.countByDayAndUser(visitStat);
	}
	/**
	 * 按天分时统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	public List<VisitStat> countByDayHourAndUser(VisitStat visitStat){
		return this.storeVisitHistMapper.countByDayHourAndUser(visitStat);
	}
}
