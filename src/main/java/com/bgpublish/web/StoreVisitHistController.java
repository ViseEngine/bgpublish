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

import com.bgpublish.domain.StoreVisitHist;
import com.bgpublish.domain.VisitStat;
import com.bgpublish.service.StoreVisitHistService;
import com.bgpublish.util.HttpUtil;

/**
 * 商家访问量Web
 * @author ps
 *
 */
@RestController
@RequestMapping(value="/sgams/storevisit")
public class StoreVisitHistController {
	private static final Log LOGGER = LogFactory.getLog(StoreVisitHistController.class);

	private @Autowired @Getter @Setter StoreVisitHistService storeVisitHistService;
	
	/**
	 * 增加商家访问信息
	 * @param storeVisitHist
	 */
	@RequestMapping(value="/addStoreVisitHist.do", method = RequestMethod.POST)
	public ResponseEntity<String> addStoreVisitHist(@RequestBody StoreVisitHist storeVisitHist){
		try{
			this.storeVisitHistService.addStoreVisitHist(storeVisitHist);
		}catch(Exception e){
			LOGGER.error("新增商家访问记录失败", e);
			return HttpUtil.createOkResponseEntity("新增商家访问记录失败!");
		}
		
		return HttpUtil.createOkResponseEntity("新增商家访问记录成功!");
	}
	/**
	 * 根据用户ID查询商家访问信息
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value="/queryByUserId.do", method = RequestMethod.GET)
	public List<StoreVisitHist> queryByUserId(String user_id){
		return this.storeVisitHistService.queryByUserId(user_id);
	}
	/**
	 * 根据商家ID查询商家访问信息
	 * @param store_id
	 * @return
	 */
	@RequestMapping(value="/queryByStoreId.do", method = RequestMethod.GET)
	public List<StoreVisitHist> queryByStoreId(String store_id){
		return this.storeVisitHistService.queryByStoreId(store_id);
	}
	/**
	 * 按天统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	@RequestMapping(value="/countByDayAndUser.do", method = RequestMethod.POST)
	public VisitStat countByDayAndUser(@RequestBody VisitStat visitStat){
		return this.storeVisitHistService.countByDayAndUser(visitStat);
	}
	/**
	 * 按天分时统计商家访问信息
	 * @param visitStat
	 * @return
	 */
	@RequestMapping(value="/countByDayHourAndUser.do", method = RequestMethod.POST)
	public List<VisitStat> countByDayHourAndUser(@RequestBody VisitStat visitStat){
		return this.storeVisitHistService.countByDayHourAndUser(visitStat);
	}
}
