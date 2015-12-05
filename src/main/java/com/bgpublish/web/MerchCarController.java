/**
 * 
 */
package com.bgpublish.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.bgpublish.domain.ResponseInfo;
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
	 * 批量添加商品到购物车中，
	 * 如果在购物车中存在，即只累加数量
	 * @param merchCar
	 */
	@RequestMapping(value="/batchAddMerchCar.do", method = RequestMethod.POST)
	public ResponseEntity<ResponseInfo> batchAddMerchCar(@RequestBody List<MerchCar> merchCars){
		
		if(merchCars == null || merchCars.isEmpty()){
			return HttpUtil.failure("商品信息为空，保存失败！");
		}
		
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			for (MerchCar merchCar : merchCars) {
				map.put("user_id", merchCar.getUser_id());
				map.put("merch_id", merchCar.getMerch_id());
				int count = this.merchCarService.countByUserAndMerchId(map);
				
				if(count <= 0){//如果不存在就添加
					this.merchCarService.addMerchCar(merchCar);
				}else{//否则更新其数量
					this.merchCarService.updateMerchCarAppendBuyNum(merchCar);
				}
			}
		}catch(Exception e){
			LOGGER.error("添加到购物车失败", e);
			return HttpUtil.failure("添加到购物车失败!");
		}
		
		return HttpUtil.success("添加到购物车成功!");
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
