/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bgpublish.App;
import com.bgpublish.domain.FavoriteStat;

/**
 * 订单服务单元测试
 * @author ps
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class StoreUserFavoriteServiceImpTest {

	private @Autowired @Getter @Setter StoreUserFavoriteService storeUserFavoriteService;
	
	@Test
	public void testCountByDay(){
		FavoriteStat f = new FavoriteStat();
		f.setStore_id(1);
		f.setStat_date("20150721");
		FavoriteStat favoriteStat = storeUserFavoriteService.countByDayAndUser(f);
		Assert.assertNotNull(favoriteStat);
		System.err.println(favoriteStat.getFavorite_count());
	}
	@Test
	public void testCountByDayHour(){
		FavoriteStat f = new FavoriteStat();
		f.setStore_id(1);
		f.setStat_date("20150721");
		List<FavoriteStat> favoriteStat = storeUserFavoriteService.countByDayHourAndUser(f);
		Assert.assertNotNull(favoriteStat);
		System.err.println(favoriteStat.size());
	}
}
