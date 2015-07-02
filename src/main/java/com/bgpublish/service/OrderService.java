/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;

/**
 * 订单 服务信息接口
 * 
 * @author wangxl
 *
 */
public interface OrderService {
	/**
	 * 生成订单
	 * @param Order对象
	 */
	public void createOrder(Order order);
	
	/**
	 * 批量生成订单明细
	 * @param OrderDetail数组 
	 */
	public void createOrderDetailBatch(List<OrderDetail> otail);
	
	/**
	 * 通过订单获取名单基本信息
	 * @param orderId
	 * @return Order对象
	 */
	public Order getOrderInfoById(String orderId);
	
	/**
	 * 通过订单ID获取订单明细信息
	 * @param orderId
	 * @return List<OrderDetail>
	 */
	public List<OrderDetail> getOrderDetailsById(String orderId);
	
	/**
	 * 根据订单ID删除订单
	 * @param orderId
	 */
	public void deleteOrder(String orderId);
	
	/**
	 * 逻辑删除订单
	 * @param order
	 */
	public void logicDeleteOrder(Order order);

	/**
	 * 取消订单明细信息
	 * @param orderId
	 */
	public void updateOrderInfo(Order order);
}
