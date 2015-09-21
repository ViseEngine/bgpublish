/**
 * 
 */
package com.bgpublish.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.bgpublish.domain.MerchDisacount;
import com.bgpublish.util.JsonUtil;

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
public class DisacountControllerTest {

	@Autowired
	private UserController userController;
	
	@Value("${local.server.port}")//获取随机端口号
    private int port;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + this.port + "/sgams/disacount");
		template = new TestRestTemplate();
	}

	@Test
	public void testQueryFirstByMerchId() {
		
		//测试queryClassifyBy方法是否可用
		ResponseEntity<String> response =
				template.getForEntity(this.base.toString() + "/queryFirstByMerchId.do?merch_id=3", String.class);
		
		assertEquals(HttpStatus.OK , response.getStatusCode());
		
		System.err.println(response.getBody());
		
		//把json 转换为list<map>
		MerchDisacount disacount = JsonUtil.parse2Object(response.getBody(), MerchDisacount.class);
		assertNotNull(disacount);
	}
}
