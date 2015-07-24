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
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.FavoriteStat;
import com.bgpublish.domain.StoreUserFavorite;
import com.bgpublish.service.StoreUserFavoriteService;
import com.bgpublish.util.HttpUtil;

/**
 * 商家信息Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/storeuf")
public class StoreUserFavoriteController {
	private static final Log LOGGER = LogFactory.getLog(StoreUserFavoriteController.class);
	private @Autowired @Getter @Setter StoreUserFavoriteService storeUserFavoriteService;

	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addStoreUserFavorite(@RequestBody StoreUserFavorite storeUserFavorite){
		try{
			this.storeUserFavoriteService.addStoreUserFavorite(storeUserFavorite);
		}catch(Exception e){
			LOGGER.error("收藏失败!", e);
			return HttpUtil.createResponseEntity("收藏失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("收藏成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public ResponseEntity<String> deleteStoreUserFavorite(@RequestBody StoreUserFavorite storeUserFavorite){
		try{
			this.storeUserFavoriteService.deleteStoreUserFavorite(storeUserFavorite);
		}catch(Exception e){
			LOGGER.error("取消收藏失败!", e);
			return HttpUtil.createResponseEntity("取消收藏失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("取消收藏成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/querybyuser.do", method = RequestMethod.GET)
	public List<StoreUserFavorite> queryByUserId(String user_id){
		return this.storeUserFavoriteService.queryByUserId(user_id);
	}
	
	@RequestMapping(value="/querybyid.do", method = RequestMethod.GET)
	public List<StoreUserFavorite> queryByStoreId(String store_id){
		return this.storeUserFavoriteService.queryByStoreId(store_id);
	}
	
	@RequestMapping(value="/count.do", method = RequestMethod.GET)
	public int countUserByStoreId(String store_id){
		return this.storeUserFavoriteService.countUserByStoreId(store_id);
	}
	
	/**
	 * 按天统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	@RequestMapping(value="/countByDayAndUser.do", method = RequestMethod.POST)
	public FavoriteStat countByDayAndUser(@RequestBody FavoriteStat favoriteStat){
		return this.storeUserFavoriteService.countByDayAndUser(favoriteStat);
	}
	/**
	 * 按天分时统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	@RequestMapping(value="/countByDayHourAndUser.do", method = RequestMethod.POST)
	public List<FavoriteStat> countByDayHourAndUser(@RequestBody FavoriteStat favoriteStat){
		return this.storeUserFavoriteService.countByDayHourAndUser(favoriteStat);
	}
}
