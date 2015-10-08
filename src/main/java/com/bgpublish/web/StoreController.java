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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.Store;
import com.bgpublish.service.StoreService;
import com.bgpublish.util.DateUtil;
import com.bgpublish.util.HttpUtil;

/**
 * 商家信息Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/store")
public class StoreController {
	private static final Log LOGGER = LogFactory.getLog(StoreController.class);
	private @Autowired @Getter @Setter StoreService storeService;
	
	
	@RequestMapping(value="/querybyuser.do", method = RequestMethod.GET)
	@ResponseBody
	public Store queryByUserId(String user_id){
		Store store = this.storeService.queryStoreByUserId(user_id);
		
		return store;
	}
	
	@RequestMapping(value="/querybyid.do", method = RequestMethod.GET)
	@ResponseBody
	public Store queryByStoreId(String store_id){
		Store store = this.storeService.queryStoreById(store_id);
		
		return store;
	}
	
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public ResponseEntity<String> addStore(@RequestBody Store store){
		try{
			this.storeService.addStore(store);
		}catch(Exception e){
			LOGGER.error("注册商店失败!", e);
			return HttpUtil.createOkResponseEntity("注册商店失败!");
		}
		
		return HttpUtil.createOkResponseEntity("注册商店成功!");
	}
	
	@RequestMapping(value="/modify.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateStore(@RequestBody Store store){
		try{
			store.setLast_modify_time(DateUtil.today("yyyyMMddHHmmss"));
			this.storeService.updateStore(store);
		}catch(Exception e){
			LOGGER.error("更新商店信息失败!", e);
			return HttpUtil.createResponseEntity("更新商店信息失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("更新商店信息成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteStoreById(String store_id){
		try{
			this.storeService.deleteStoreById(store_id);
		}catch(Exception e){
			LOGGER.error("删除商店失败!", e);
			return HttpUtil.createResponseEntity("删除商店失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除商店成功!", HttpStatus.OK);
	}
	
	/**
	 * 按销量大小查询商家信息
	 * @return 返回商家信息
	 */
	@RequestMapping(value="/queryStoreBySalesVolume.do", method = RequestMethod.GET)
	public List<Store> queryStoreBySalesVolume(){
		return this.storeService.queryStoreBySalesVolume();
	}
	/**
	 * 按收藏数查询商家信息
	 * @return 返回商家信息
	 */
	@RequestMapping(value="/queryStoreByFavoriteCount.do", method = RequestMethod.GET)
	public List<Store> queryStoreByFavoriteCount(){
		return this.storeService.queryStoreByFavoriteCount();
	}
	/**
	 * 按销量大小查询商家信息(分页)
	 * @return 返回商家信息
	 */
	@RequestMapping(value="/queryStoreBySalesVolumePage.do", method = RequestMethod.GET)
	public List<Store> queryStoreBySalesVolume(@RequestParam int start,@RequestParam int limit){
		return this.storeService.queryStoreBySalesVolume(start,limit);
	}
	/**
	 * 按收藏数查询商家信息(分页)
	 * @return 返回商家信息
	 */
	@RequestMapping(value="/queryStoreByFavoriteCountPage.do", method = RequestMethod.GET)
	public List<Store> queryStoreByFavoriteCount(@RequestParam int start,@RequestParam int limit){
		return this.storeService.queryStoreByFavoriteCount(start,limit);
	}
}
