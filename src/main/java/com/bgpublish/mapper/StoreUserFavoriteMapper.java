/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;

import com.bgpublish.domain.FavoriteStat;
import com.bgpublish.domain.StoreUserFavorite;

/**
 * 商家Mapper
 * @author ps
 *
 */
public interface StoreUserFavoriteMapper {
	
	/**
	 * 新增商家用户收藏
	 * @param storeUserFavorite 商家用户收藏信息
	 */
	public void addStoreUserFavorite(StoreUserFavorite storeUserFavorite);
	/**
	 * 删除商家
	 * @param storeUserFavorite 商家用户收藏信息
	 */
	public void deleteStoreUserFavorite(StoreUserFavorite storeUserFavorite);
	/**
	 * 根据用户ID查询商家收藏信息
	 * @param user_id 用户ID
	 * @return 商家收藏列表信息
	 */
	public List<StoreUserFavorite> queryByUserId(String user_id);
	/**
	 * 根据商家ID查询商家收藏信息
	 * @param store_id 商家ID
	 * @return 商家收藏列表信息
	 */
	public List<StoreUserFavorite> queryByStoreId(String store_id);
	/**
	 * 根据商家ID统计被用户收藏数
	 * @param store_id
	 * @return 用户收藏数
	 */
	public int countUserByStoreId(String store_id);
	
	/**
	 * 按天统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	public FavoriteStat countByDayAndUser(FavoriteStat favoriteStat);
	/**
	 * 按天分时统计商家收藏量
	 * @param favoriteStat
	 * @return
	 */
	public List<FavoriteStat> countByDayHourAndUser(FavoriteStat favoriteStat);
}
