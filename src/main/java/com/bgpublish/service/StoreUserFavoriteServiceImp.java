/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

import com.bgpublish.domain.FavoriteStat;
import com.bgpublish.domain.StoreUserFavorite;
import com.bgpublish.mapper.StoreUserFavoriteMapper;

/**
 * 商家用户收藏服务实现类
 * @author ps
 *
 */
@Service
public class StoreUserFavoriteServiceImp implements StoreUserFavoriteService {
	
	private @Autowired @Getter @Setter StoreUserFavoriteMapper storeUserFavoriteMapper;
	
	/**
	 * 新增商家用户收藏
	 * @param storeUserFavorite 商家用户收藏信息
	 */
	public void addStoreUserFavorite(StoreUserFavorite storeUserFavorite){
		this.storeUserFavoriteMapper.addStoreUserFavorite(storeUserFavorite);
	}
	/**
	 * 删除商家
	 * @param storeUserFavorite 商家用户收藏信息
	 */
	public void deleteStoreUserFavorite(StoreUserFavorite storeUserFavorite){
		this.storeUserFavoriteMapper.deleteStoreUserFavorite(storeUserFavorite);
	}
	/**
	 * 根据用户ID查询商家收藏信息
	 * @param user_id 用户ID
	 * @return 商家收藏列表信息
	 */
	public List<StoreUserFavorite> queryByUserId(String user_id){
		return this.storeUserFavoriteMapper.queryByUserId(user_id);
	}
	/**
	 * 根据商家ID查询商家收藏信息
	 * @param store_id 商家ID
	 * @return 商家收藏列表信息
	 */
	public List<StoreUserFavorite> queryByStoreId(String store_id){
		return this.storeUserFavoriteMapper.queryByStoreId(store_id);
	}
	/**
	 * 根据商家ID统计被用户收藏数
	 * @param store_id
	 * @return 用户收藏数
	 */
	public int countUserByStoreId(String store_id){
		return this.storeUserFavoriteMapper.countUserByStoreId(store_id);
	}

	/**
	 * 按天统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	public FavoriteStat countByDayAndUser(FavoriteStat favoriteStat){
		return this.storeUserFavoriteMapper.countByDayAndUser(favoriteStat);
	}
	/**
	 * 按天分时统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	public List<FavoriteStat> countByDayHourAndUser(FavoriteStat favoriteStat){
		return this.storeUserFavoriteMapper.countByDayHourAndUser(favoriteStat);
	}
}
