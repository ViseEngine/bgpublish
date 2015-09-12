package com.bgpublish.web;

import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bgpublish.App;
import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class OrderControllerTest {

	@Autowired
	private OrderController orderController;
	
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
	public void testCreateOrder() {
		Order orderTest = new Order();
		orderTest.setAmount_money(new Float(11.2));
		orderTest.setCurrency_unit("RMB");
//		orderTest.setBuyer_addr_id(2);
		orderTest.setBuyer_phone("13599990000");
		orderTest.setBuyer_mobile("");
		orderTest.setSend_type("0");
		orderTest.setSend_no("012345");
		orderTest.setInvoice_need("0");
		orderTest.setPay_type("0");
		orderTest.setStatus("1");
		Integer merid = null;
		String merName = null;
		String unit = null;
		Integer amount = null;
		Float price = null;
		
		orderTest.setBuyer_name("王大帅");
		merid = new Integer(1);
		merName = "商品名称";
		unit = "瓶";
		amount = 1;
		price = 30F;
	
		/*
		List<Integer> merIdList = new ArrayList<Integer>();
		List<String> merNameList = new ArrayList<String>();
		List<String> unitList = new ArrayList<String>();
		List<Integer> amountList = new ArrayList<Integer>();
		List<Float> priceList = new ArrayList<Float>();
		
		
		for (int i = 0; i < 5; i++) {
			OrderDetail otail = new OrderDetail();
			merIdList.add(merid+i);
			merNameList.add(merName+merid);
			unitList.add(unit+i);
			amountList.add(amount+i);
			priceList.add(price+i);
		}

		orderTest.setMerch_ids(merIdList);
		orderTest.setMerch_names(merNameList);
		orderTest.setUnits(unitList);
		orderTest.setAmounts(amountList);
		orderTest.setPrices(priceList);
		
		*/
		
		List<OrderDetail> otailList = new ArrayList<OrderDetail>();
		for (int i = 0; i < 5; i++) {
			OrderDetail otail = new OrderDetail();
			otail.setMerch_id(merid+i);
			otail.setMerch_name(merName+merid);
			otail.setAmount(amount+i);
			otail.setUnit(unit+i);
			otail.setPrice(price+i);
			otailList.add(otail);
		}
		
		orderTest.setOrderDetails(otailList);
		
		//测试selectUser方法是否可用
		String postForObject = "";
		
		try {
		
			//使用了对象的方式传入request，因此controller的参数必须带上@RequestBody
			postForObject = template.postForObject(new URI(this.base.toString() + "/order/createOrder.do"), orderTest, String.class);
		

		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		System.out.println(postForObject);
	}

	@Test
	public void testGetOrderInfoById() {
		String orderId = "2015060700000000015";
		try {
			Order order = template.postForObject(new URI(this.base.toString() + "/order/getOrderInfoById.do?orderId="+orderId), String.class, Order.class);
			String orderStr = template.postForObject(new URI(this.base.toString() + "/order/getOrderInfoById.do?orderId="+orderId), String.class, String.class);
			System.out.println(order.getOrder_id()+"/n"+order.toString());
			System.out.println(order.getOrder_id()+"/n"+orderStr);
		} catch (RestClientException e) {
			fail("Not yet implemented");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			fail("Not yet implemented");
			e.printStackTrace();
		}
		
	}

	@Test
	public void testLogicDeleteOrder() {
		String orderId = "2015061023140700000000001";
		ResponseEntity<String> responseStr = null;
//		ResponseEntity<String> response =
//				template.getForEntity(this.base.toString() + "/user/query.do?id=1", String.class);
		Order order = new Order();
		order.setOrder_id(orderId);
		order.setBuyer_del("0");
		try {
			responseStr = template.postForEntity(new URI(this.base.toString() + "/order/logicDeleteOrder.do"), order, String.class);

	//		responseStr = template.postForObject(new URI(this.base.toString() + "/order/deleteOrder.do?orderId="+orderId), String.class,String.class);
		} catch (RestClientException e) {
			fail("怎么会不成功呢");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			fail("Not yet implemented");
			e.printStackTrace();
		}

	}

	@Test
	public void testCencelOrder() {
		Order order = new Order();
		order.setOrder_id("2015060700000000015");
		order.setAmount_money(34);
//		order.setBuyer_addr_id(23);
		order.setFreight(14);
		try {
	//		Order order = template.postForObject(new URI(this.base.toString() + "/order/getOrderInfoById.do?orderId="+orderId), String.class, Order.class);
			String orderStr = template.postForObject(new URI(this.base.toString() + "/order/cencelOrder.do"), order, String.class);
			System.out.println(orderStr+"/n");
		} catch (RestClientException e) {
			fail("取消都不可以");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			fail("取消都不可以");
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetOrderService() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOrderService() {
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

}
