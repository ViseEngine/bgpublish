/**
 * 
 */
package com.bgpublish.web;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.MerchCar;
import com.bgpublish.service.MerchCarService;
import com.bgpublish.util.HttpUtil;

/**
 * 购物车controller
 * @author ps
 *
 */
@RestController
@RequestMapping(value="/sgams/merchcar")
public class MerchCarController {
	private static final Log LOGGER = LogFactory.getLog(MerchCarController.class);
	
	private @Autowired @Getter @Setter MerchCarService merchCarService;
	
	/**
	 * 添加商品到购物车中
	 * @param merchCar
	 */
	@RequestMapping(value="/addMerchCar.do", method = RequestMethod.POST)
	public ResponseEntity<String> addMerchCar(@RequestBody MerchCar merchCar){
		try{
			this.merchCarService.addMerchCar(merchCar);
		}catch(Exception e){
			LOGGER.error("添加到购物车失败", e);
			return HttpUtil.createOkResponseEntity("添加到购物车失败!");
		}
		
		return HttpUtil.createOkResponseEntity("添加到购物车成功!");
	}
	/**
	 * 更新购物车中的购买数量等信息
	 * @param merchCar
	 */
	@RequestMapping(value="/updateMerchCar.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateMerchCar(@RequestBody MerchCar merchCar){
		try{
			this.merchCarService.updateMerchCar(merchCar);
		}catch(Exception e){
			LOGGER.error("更新购物车商品信息失败", e);
			return HttpUtil.createOkResponseEntity("更新购物车商品信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("更新购物车商品信息成功!");
	}
	/**
	 * 更新购物车中的购买数量等信息
	 * @param merchCar
	 */
	@RequestMapping(value="/updateMerchCarBy.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateMerchCarBy(@RequestBody MerchCar merchCar){
		try{
			this.merchCarService.updateMerchCarBy(merchCar);
		}catch(Exception e){
			LOGGER.error("更新购物车商品信息失败", e);
			return HttpUtil.createOkResponseEntity("更新购物车商品信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("更新购物车商品信息成功!");
	}
	/**
	 * 删除购物车商品信息
	 * @param merchCar
	 */
	@RequestMapping(value="/deleteMerchCarBy.do", method = RequestMethod.POST)
	public ResponseEntity<String> deleteMerchCarBy(@RequestBody MerchCar merchCar){
		try{
			this.merchCarService.deleteMerchCarBy(merchCar);
		}catch(Exception e){
			LOGGER.error("删除购物车商品信息失败", e);
			return HttpUtil.createOkResponseEntity("删除购物车商品信息失败!");
		}
		
		return HttpUtil.createOkResponseEntity("删除购物车商品信息成功!");
	}
	/**
	 * 根据用户查询该用户的购物车中商品信息
	 * @param user_id
	 * @return 
	 */
	@RequestMapping(value="/queryMerchCarByUser.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MerchCar> queryMerchCarByUser(@RequestParam String user_id){
		return this.merchCarService.queryMerchCarByUser(user_id);
	}
}
