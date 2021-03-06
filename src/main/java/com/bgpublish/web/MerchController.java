/**
 * 
 */
package com.bgpublish.web;

import java.util.List;
import java.util.Map;

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

import com.bgpublish.domain.Merch;
import com.bgpublish.service.MerchService;
import com.bgpublish.util.HttpUtil;

/**
 * 商品Web Controller
 * @author ps
 *
 */
@RestController
@RequestMapping(value="/sgams/merch")
public class MerchController {
	private static final Log LOGGER = LogFactory.getLog(MerchController.class);

	private @Autowired @Getter @Setter MerchService merchService;
	
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addMerch(@RequestBody Merch merch){
		try{
			//TODO 涉及到图片的可能会修改
			this.merchService.addMerch(merch);
		}catch(Exception e){
			LOGGER.error("新增商品失败", e);
			return HttpUtil.createResponseEntity("新增商品失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("新增商品成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/modify.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateMerch(@RequestBody Merch merch){
		try{
			//TODO 涉及到图片的可能会修改
			this.merchService.updateMerch(merch);
		}catch(Exception e){
			LOGGER.error("更新商品失败", e);
			return HttpUtil.createOkResponseEntity("更新商品失败!");
		}
		
		return HttpUtil.createOkResponseEntity("更新商品成功!");
	}
	
	@RequestMapping(value="/deletebyid.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteMerchById(String merch_id){
		try{
			this.merchService.deleteMerchById(merch_id);
		}catch(Exception e){
			LOGGER.error("删除商品失败!", e);
			return HttpUtil.createOkResponseEntity("删除商品失败!");
		}
		
		return HttpUtil.createOkResponseEntity("删除商品成功!");
	}
	
	@RequestMapping(value="/deletebystoreid.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteMerchByStoreId(String store_id){
		try{
			this.merchService.deleteMerchByStoreId(store_id);
		}catch(Exception e){
			LOGGER.error("删除商品失败", e);
			return HttpUtil.createResponseEntity("删除商品失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除商品成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/querybyid.do", method = RequestMethod.GET)
	@ResponseBody
	public Merch queryMerchById(String merch_id){
		Merch merch = this.merchService.queryMerchById(merch_id);
		
		return merch;
	}
	
	@RequestMapping(value="/querybystoreid.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Merch> queryMerchByStoreId(String store_id){
		List<Merch> list = this.merchService.queryMerchByStoreId(store_id);
		
		return list;
	}
	
	@RequestMapping(value="/querybyuserid.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Merch> queryMerchByUserId(String user_id){
		List<Merch> list = this.merchService.queryMerchByUserId(user_id);
		
		return list;
	}
	
	@RequestMapping(value="/queryby.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Merch> queryMerchBy(@RequestBody Merch merch){
		List<Merch> list = this.merchService.queryMerchBy(merch);
		
		return list;
	}
	
	@RequestMapping(value="/querybypage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Merch> queryMerchByPage(@RequestBody Merch merch,@RequestParam int start,@RequestParam int limit){
		List<Merch> list = this.merchService.queryMerchByPage(merch,start,limit);
		
		return list;
	}
	
	/**
	 * 查询商品信息，会按创建时间倒序
	 * @param map 查询条件
	 * @return
	 */
	@RequestMapping(value="/queryMerchByMap.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Merch> queryMerchByMap(@RequestBody Map<String,String> map){
		List<Merch> list = this.merchService.queryMerchByMap(map);
		
		return list;
	}
	
}
