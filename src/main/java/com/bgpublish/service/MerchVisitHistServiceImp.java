/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.MerchVisitHist;
import com.bgpublish.mapper.MerchVisitHistMapper;

/**
 * 商家访问历史服务类
 * @author ps
 *
 */
@Service
public class MerchVisitHistServiceImp implements MerchVisitHistService{
	
	private @Autowired @Setter @Getter MerchVisitHistMapper merchVisitHistMapper;
	/**
	 * 增加商家访问信息
	 * @param storeVisitHist
	 */
	public void addMerchVisitHist(MerchVisitHist merchVisitHist){
		this.merchVisitHistMapper.addMerchVisitHist(merchVisitHist);
	}
	/**
	 * 根据用户ID查询商家访问信息
	 * @param user_id
	 * @return
	 */
	public List<MerchVisitHist> queryByUserId(String user_id){
		return this.merchVisitHistMapper.queryByUserId(user_id);
	}
	/**
	 * 根据商家ID查询商家访问信息
	 * @param merch_id
	 * @return
	 */
	public List<MerchVisitHist> queryByMerchId(String merch_id){
		return this.merchVisitHistMapper.queryByMerchId(merch_id);
	}
}
