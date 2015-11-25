/**
 * 
 */
package com.bgpublish.service;

import java.util.ArrayList;
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
import com.bgpublish.domain.Merch;

/**
 * 订单服务单元测试
 * @author ps
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class MerchServiceImpTest {

	private @Autowired @Getter @Setter MerchService merchService;
	
	@Test
	public void testQueryMerchBy(){
		Merch merch = new Merch();
		List<Merch> merchLists = merchService.queryMerchBy(merch);
		
		Assert.assertNotNull(merchLists);
	}
	
	@Test
	public void testBatchUpdate(){
		List<Merch> merchList = new ArrayList<Merch>(); 
		
		for (int i = 1; i <= 3; i++) {
			Merch merchUpdate = new Merch();//商品更新对象,用于更新商品库存
			merchUpdate.setMerch_id(1);
			merchUpdate.setIn_stock(117);
			merchUpdate.setClassify_id(4);
			merchUpdate.setPrice(63.2f);
			merchUpdate.setStore_id(1);
			merchList.add(merchUpdate);
		}
		
		merchService.updateMerchBatch(merchList);
	}
}
