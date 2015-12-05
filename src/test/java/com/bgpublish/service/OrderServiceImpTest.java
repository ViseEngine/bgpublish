/**
 * 
 */
package com.bgpublish.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderStat;

/**
 * 订单服务单元测试
 * @author ps
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class OrderServiceImpTest {

	private @Autowired @Getter @Setter OrderService orderService;
	
	@Test
	public void testGetCompletedOrderInfo(){
		Order order = new Order();
		order.setBuyer_user_id(3);
		order.setBuyer_user_name("aa");
		List<Order> completedOrderInfo = orderService.getCompletedOrderInfo(order);
		for (Order order1 : completedOrderInfo) {
			
			Assert.assertNotNull(order1);
		}
	}
	@Test
	public void testGetInOrderInfo(){
		Order order = new Order();
		order.setBuyer_user_id(4);
		order.setBuyer_user_name("aa");
		List<Order> inOrderInfo = orderService.getInOrderInfo(order);
		for (Order order1 : inOrderInfo) {
			
			Assert.assertNotNull(order1);
		}
	}
	
	@Test
	public void testCountByDay(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("stat_date", "20150721");
		map.put("user_id", "1");
		OrderStat orderStat = orderService.countByDay(map);
		Assert.assertNotNull(orderStat);
		System.err.println(orderStat.getOrder_sell());
	}
	@Test
	public void testCountByDayHour(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("stat_date", "20150721");
		map.put("user_id", "1");
		List<OrderStat> orderStat = orderService.countByDayHour(map);
		Assert.assertNotNull(orderStat);
		System.err.println(orderStat.size());
	}
	@Test
	public void testCountMoneyByDay(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("stat_date", "20150721");
		map.put("user_id", "1");
		OrderStat orderStat = orderService.countMoneyByDay(map);
		Assert.assertNotNull(orderStat);
		System.err.println(orderStat.getOrder_sell());
	}
	@Test
	public void testCountMoneyByDayHour(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("stat_date", "20150721");
		map.put("user_id", "1");
		List<OrderStat> orderStat = orderService.countMoneyByDayHour(map);
		Assert.assertNotNull(orderStat);
		System.err.println(orderStat.size());
	}
	
	@Test
	public void testGetInOrderInfoByPage(){
		Order order = new Order();
		List<Order> list = orderService.getInOrderInfoByPage(order,1,10);
		
		Assert.assertNotNull(list);
		System.err.println(list.size());
	}
	@Test
	public void testGetClosedOrderInfoPage(){
		Order order = new Order();
		order.setSeller_user_id(1);
		List<Order> list = orderService.getClosedOrderInfoPage(order,1,10);
		
		Assert.assertNotNull(list);
		System.err.println(list.size());
	}
	@Test
	public void testSearchOrderInfo(){
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("order_id", "2015071800061200000000006");
		condition.put("merch_name", "2015071800061200000000006");
		condition.put("buyer_mobile", "2015071800061200000000006");
		condition.put("buyer_name", "2015071800061200000000006");
		List<Order> list = orderService.searchOrderInfo(condition);
		
		Assert.assertNotNull(list);
		System.err.println(list.size());
	}
	
	@Test
	public void testGetDetailInfo(){
		Order order = orderService.getDetailsById("2015113016142979922491780");
		System.err.println(order);
	}
}
