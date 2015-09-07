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
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.MerchVisitHist;
import com.bgpublish.service.MerchVisitHistService;
import com.bgpublish.util.HttpUtil;

/**
 * 商品访问量Web
 * @author ps
 *
 */
@RestController
@RequestMapping(value="/sgams/merchvisit")
public class MerchVisitHistController {
	private static final Log LOGGER = LogFactory.getLog(MerchVisitHistController.class);

	private @Autowired @Getter @Setter MerchVisitHistService merchVisitHistService;
	
	/**
	 * 增加商品访问信息
	 * @param storeVisitHist
	 */
	@RequestMapping(value="/addMerchVisitHist.do", method = RequestMethod.POST)
	public ResponseEntity<String> addMerchVisitHist(@RequestBody MerchVisitHist merchVisitHist){
		try{
			this.merchVisitHistService.addMerchVisitHist(merchVisitHist);
		}catch(Exception e){
			LOGGER.error("新增商品访问记录失败", e);
			return HttpUtil.createOkResponseEntity("新增商品访问记录失败!");
		}
		
		return HttpUtil.createOkResponseEntity("新增商品访问记录成功!");
	}
	/**
	 * 根据用户ID查询商品访问信息
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value="/queryByUserId.do", method = RequestMethod.GET)
	public List<MerchVisitHist> queryByUserId(String user_id){
		return this.merchVisitHistService.queryByUserId(user_id);
	}
	/**
	 * 根据商品ID查询商品访问信息
	 * @param store_id
	 * @return
	 */
	@RequestMapping(value="/queryByMerchId.do", method = RequestMethod.GET)
	public List<MerchVisitHist> queryByMerchId(String merch_id){
		return this.merchVisitHistService.queryByMerchId(merch_id);
	}
}
