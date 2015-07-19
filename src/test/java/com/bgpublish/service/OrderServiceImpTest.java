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
import com.bgpublish.domain.Order;

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
}
