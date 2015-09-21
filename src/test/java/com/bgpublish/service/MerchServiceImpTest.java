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
}
