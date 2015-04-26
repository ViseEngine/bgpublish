/**
 * 
 */
package com.bgpublish.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bgpublish.App;
import com.bgpublish.domain.User;

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
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
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
	public void testSelectUser() {
		
		//测试selectUser方法是否可用
		ResponseEntity<String> response =
				template.getForEntity(this.base.toString() + "/user/query.do?id=1", String.class);
		
		assertEquals(HttpStatus.OK , response.getStatusCode());
		
		
		try {
			//此方式与上一种方式一样
			User user = template.getForObject(this.base.toString() + "/user/query.do?id=1", User.class);
			Assert.assertNotNull(user);
			assertThat(user.getName(), is("pansen"));
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		
		User user = new User();
		user.setMobile("13533714838");
		user.setPassword("6506a3d713a63a4586628128b158b053bb80840f");//pansen
		user.setUserType("0");//卖家

		//测试selectUser方法是否可用
		String postForObject = "";
		try {
			//使用了对象的方式传入request，因此controller的参数必须带上@RequestBody
			postForObject = template.postForObject(new URI(this.base.toString() + "/user/login.do"), user, String.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		System.out.println(postForObject);
		
	}
}
