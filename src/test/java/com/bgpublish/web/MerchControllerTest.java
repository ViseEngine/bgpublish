package com.bgpublish.web;

import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bgpublish.App;
import com.bgpublish.domain.Merch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class MerchControllerTest {

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
	public void testAddMerch() {
		
		Integer merch_id = null;
		Integer store_id = null;
		Integer user_id = new Integer(123456);

		String name = null;
		Integer classify_id = null;
		Float price = null;

		Integer in_stock = 9000;
		String published_date = "20150609000000";
		String out_published = "0";
		String last_modify_time = "20150609000000";
		String create_time = "20150609000000";

		
		merch_id = new Integer(9990);
		store_id = new Integer(209990);
//		name = new String("商品名称".getBytes("ISO-8859-1"),"utf8");
		name = "商品名称";
		classify_id = 1;
		price = 30F;
		
		List<Merch> merchList = new ArrayList<Merch>();
		for (int i = 0; i < 5; i++) {
			Merch merch = new Merch();
			merch.setMerch_id(i);
			merch.setStore_id(store_id+i);
			merch.setUser_id(user_id);
			merch.setName(name+String.valueOf(merch_id+i));
			merch.setClassify_id(classify_id+i);
			merch.setPrice(price+i);
			merch.setIn_stock(in_stock);
			merch.setPublished_date(published_date);
			merch.setOut_published(out_published);
			merch.setLast_modify_time(last_modify_time);
			merch.setCreate_time(create_time);
			merchList.add(merch);
		}
		
		String postForObject = "";
		for (int i = 0; i < merchList.size(); i++) {
			try {
				
				//使用了对象的方式传入request，因此controller的参数必须带上@RequestBody
				postForObject += template.postForObject(new URI(this.base.toString() + "/merch/add.do"), merchList.get(i), String.class);
			
			} catch (RestClientException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(postForObject);
	}

	@Test
	public void testUpdateMerch() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMerchById() {
		String merchID = "5";
		String responseStr = "";
		try {
			
			//使用了对象的方式传入request，因此controller的参数必须带上@RequestBody
			responseStr += template.postForObject(new URI(this.base.toString() + "/merch/deletebyid.do"), merchID, String.class);
		
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		System.out.println(responseStr);
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMerchByStoreId() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryMerchById() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryMerchByStoreId() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryMerchByUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryMerchBy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMerchService() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMerchService() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGueryMerchByPage() {
		try {
			
			//使用了对象的方式传入request，因此controller的参数必须带上@RequestBody
			Merch merch = new Merch();
			merch.setUser_id(1);
			merch.setOut_published("0");
			String json = template.postForObject(new URI(this.base.toString() + "/merch/querybypage.do?start=3&limit=2"), merch, String.class);
		
			
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
