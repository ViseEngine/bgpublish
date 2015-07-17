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
		List<Order> completedOrderInfo = orderService.getCompletedOrderInfo();
		for (Order order : completedOrderInfo) {
			
			Assert.assertNotNull(order);
		}
	}
	@Test
	public void testGetInOrderInfo(){
		List<Order> inOrderInfo = orderService.getInOrderInfo();
		for (Order order : inOrderInfo) {
			
			Assert.assertNotNull(order);
		}
	}
}
