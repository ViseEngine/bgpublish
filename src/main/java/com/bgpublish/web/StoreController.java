/**
 * 
 */
package com.bgpublish.web;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.Store;
import com.bgpublish.service.StoreService;
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
			e.printStackTrace();
			return HttpUtil.createResponseEntity("注册商店失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("注册商店成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/modify.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateStore(@RequestBody Store store){
		try{
			this.storeService.updateStore(store);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("更新商店信息失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("更新商店信息成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteStoreById(String store_id){
		try{
			this.storeService.deleteStoreById(store_id);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("删除商店失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除商店成功!", HttpStatus.OK);
	}
}
