/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;
import com.bgpublish.domain.OrderStat;
import com.bgpublish.mapper.OrderMapper;

/**
 * 订单服务信息实现类
 * 
 * @author wangxl
 *
 */
@Service
public class OrderServiceImp implements OrderService {

	private  @Autowired @Getter @Setter OrderMapper orderMapper;

	/**
	 * 生成订单
	 * @param order
	 * @see com.bgpublish.service.OrderService#CreateOrder(java.lang.String)
	 */
	
	@Override
	public void createOrder(Order order) {
		this.orderMapper.createOrder(order);
	}

	/**
	 * 生成订单明细信息
	 * @param OrderDetail数组
	 * @see com.bgpublish.service.OrderService#createOrderDetailBatch(java.util.List<OrderDetail>)
	 */
	@Override
	public void createOrderDetailBatch(List<OrderDetail> otail) {
		this.orderMapper.createOrderDetailBatch(otail);
	}
	
	/**
	 * 获取订单基本信息
	 * @param orderId
	 * @see com.bgpublish.service.OrderService#getOrderInfoById(java.lang.String)
	 */
	@Override
	public Order getOrderInfoById(String orderId) {
		return this.orderMapper.getOrderInfoById(orderId);
	}

	/**
	 * 获取订单明细信息
	 * @param orderId
	 * @see com.bgpublish.service.OrderService#getOrderDetailsById(java.lang.String)
	 */
	@Override
	public List<OrderDetail> getOrderDetailsById(String orderId) {
		return this.orderMapper.getOrderDetailsById(orderId);
	}

	/**
	 * 获取已完成的订单
	 * @param order
	 * @return
	 */
	public List<Order> getCompletedOrderInfo(Order order){
		List<Order> completedOrderList = this.orderMapper.getCompletedOrderInfo(order);
		return completedOrderList;
	}
	/**
	 * 获取进行中的订单
	 * @param order
	 * @return
	 */
	public List<Order> getInOrderInfo(Order order){
		List<Order> inOrderList = this.orderMapper.getInOrderInfo(order);
		return inOrderList;
	}
	
	/**
	 * 根据订单ID删除订单
	 * @param orderId
	 */
	@Override
	public void deleteOrder(String orderId) {
		this.orderMapper.deleteOrder(orderId);
	}

	/**
	 * 逻辑删除订单信息
	 * @param order
	 */
	@Override
	public void logicDeleteOrder(Order order) {
		this.orderMapper.logicDeleteOrder(order);
	}


	/**
	 * 更新订单信息
	 * @param orderId
	 */
	@Override
	public void updateOrderInfo(Order order) {
		this.orderMapper.updateOrderInfo(order);
		
	}
	
	/**
	 * 按天统计订单成交量
	 * @param map
	 * @return
	 */
	public OrderStat countByDay(Map<String,String> map){
		return this.orderMapper.countByDay(map);
	}
	
	/**
	 * 按月统计订单成交量
	 * @param map 年月（yyyyMM）
	 * @return
	 */
	public List<OrderStat> countByMonth(Map<String,String> map){
		return this.orderMapper.countByMonth(map);
	}
	/**
	 * 按天分时统计订单成交量
	 * @param map
	 * @return
	 */
	public List<OrderStat> countByDayHour(Map<String,String> map){
		return this.orderMapper.countByDayHour(map);
	}
	/**
	 * 按天统计订单成交金额
	 * @param map
	 * @return
	 */
	public OrderStat countMoneyByDay(Map<String,String> map){
		return this.orderMapper.countMoneyByDay(map);
	}
	/**
	 * 按天分时统计订单金额
	 * @param map
	 * @return
	 */
	public List<OrderStat> countMoneyByDayHour(Map<String,String> map){
		return this.orderMapper.countMoneyByDayHour(map);
	}
}
