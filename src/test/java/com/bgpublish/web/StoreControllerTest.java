/**
 * 
 */
package com.bgpublish.web;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.bgpublish.App;

/**
 * 用户接口测试
 * 
 * @author pansen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class StoreControllerTest {

	@Value("${local.server.port}")//获取随机端口号
    private int port;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + this.port + "/sgams");
		template = new TestRestTemplate();
	}

	@Test
	public void testQueryStoreByVisitCount() {
		
		//测试selectUser方法是否可用
		ResponseEntity<String> response =
				template.getForEntity(this.base.toString() + "/store/queryStoreByVisitCountPage.do?start=1&limit=10", String.class);
		
		assertEquals(HttpStatus.OK , response.getStatusCode());
		
		
	}

}
