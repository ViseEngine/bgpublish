/**
 * 
 */
package com.bgpublish.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bgpublish.App;


/**
 * @author ps
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class SysSeqServiceImpTest {
	
	private @Autowired SysSeqService sysSeqService;
	
	@Test
	public void testGenerate(){
		Integer orderId = sysSeqService.generate("TBL_ORDER_INFO");
		System.err.println(orderId);
	}
}
