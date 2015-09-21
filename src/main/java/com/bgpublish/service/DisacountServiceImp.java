/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.MerchDisacount;
import com.bgpublish.mapper.DisacountMapper;

/**
 * 商品优惠信息服务实现类
 * @author ps
 *
 */
@Service
public class DisacountServiceImp implements DisacountService {
	
	private @Autowired @Getter @Setter DisacountMapper disacountMapper;
	/**
	 * 新增商品优惠信息
	 * @param merchDisacount 商品优惠信息
	 */
	public void addDisacount(MerchDisacount merchDisacount){
		this.disacountMapper.addDisacount(merchDisacount);
	}
	
	/**
	 * 根据商品优惠ID删除商品优惠信息
	 * @param diacount_id 商品优惠ID
	 */
	public void deleteDisacountById(String diacount_id){
		this.disacountMapper.deleteDisacountById(diacount_id);
	}
	
	/**
	 * 更新商品优惠信息
	 * @param merchDisacount 商品优惠信息
	 */
	public void updateDisacount(MerchDisacount merchDisacount){
		this.disacountMapper.updateDisacount(merchDisacount);
	}
	
	/**
	 * 根据商品ID查询商品优惠信息
	 * @param merch_id 商品ID
	 */
	public List<MerchDisacount> queryByMerchId(String merch_id){
		return this.disacountMapper.queryByMerchId(merch_id);
	}
	/**
	 * 根据商品ID查询商品优惠信息,查询所有
	 * @param merch_id 商品ID
	 */
	public List<MerchDisacount> queryAllByMerchId(String merch_id){
		return this.disacountMapper.queryAllByMerchId(merch_id);
	}
	/**
	 * 根据商品ID查询商品优惠信息，查询一条记录
	 * @param merch_id 商品ID
	 */
	public MerchDisacount queryFirstByMerchId(String merch_id){
		return this.disacountMapper.queryFirstByMerchId(merch_id);
	}
}
