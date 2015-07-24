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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.MerchDisacount;
import com.bgpublish.service.DisacountService;
import com.bgpublish.util.HttpUtil;

/**
 * 商家优惠信息Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/disacount")
public class DisacountController {
	private static final Log LOGGER = LogFactory.getLog(DisacountController.class);
	private @Autowired @Getter @Setter DisacountService disacountService;
	
	
	@RequestMapping(value="/querybyid.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MerchDisacount> queryByMerchId(String merch_id){
		List<MerchDisacount> list = this.disacountService.queryByMerchId(merch_id);
		
		return list;
	}
	
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addDisacount(@RequestBody MerchDisacount merchDisacount){
		try{
			this.disacountService.addDisacount(merchDisacount);
		}catch(Exception e){
			LOGGER.error("新增商品优惠信息失败!",e);
			return HttpUtil.createResponseEntity("新增商品优惠信息失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("新增商品优惠信息成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/modify.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateDisacount(@RequestBody MerchDisacount merchDisacount){
		try{
			this.disacountService.updateDisacount(merchDisacount);
		}catch(Exception e){
			LOGGER.error("更新商品优惠信息失败!",e);
			return HttpUtil.createResponseEntity("更新商店优惠信息失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("更新商店优惠信息成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteDisacountById(String disacount_id){
		try{
			this.disacountService.deleteDisacountById(disacount_id);
		}catch(Exception e){
			LOGGER.error("删除商品优惠信息失败!",e);
			return HttpUtil.createResponseEntity("删除商店优惠信息失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除商店优惠信息成功!", HttpStatus.OK);
	}
}
