/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.MerchCar;
import com.bgpublish.mapper.MerchCarMapper;

/**
 * 购物车服务类
 * @author ps
 *
 */
@Service
public class MerchCarServiceImp implements MerchCarService {

	private @Autowired @Setter @Getter MerchCarMapper merchCarMapper;
	/**
	 * 添加商品到购物车中
	 * @param merchCar
	 */
	public void addMerchCar(MerchCar merchCar){
		this.merchCarMapper.addMerchCar(merchCar);
	}
	/**
	 * 更新购物车中的购买数量等信息
	 * @param merchCar
	 */
	public void updateMerchCar(MerchCar merchCar){
		this.merchCarMapper.updateMerchCar(merchCar);
	}
	/**
	 * 根据用户查询该用户的购物车中商品信息
	 * @param user_id
	 * @return 
	 */
	public List<MerchCar> queryMerchCarByUser(String user_id){
		return this.merchCarMapper.queryMerchCarByUser(user_id);
	}

}
