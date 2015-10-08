/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;
import com.bgpublish.domain.OrderStat;

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
	 * 获取已关闭的订单
	 * @param order
	 * @return
	 */
	public List<Order> getClosedOrderInfo(Order order);
	/**
	 * 获取已关闭的订单
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getClosedOrderInfoPage(Order order,int start,int limit);
	/**
	 * 获取已完成的订单
	 * @param order
	 * @return
	 */
	public List<Order> getCompletedOrderInfo(Order order);
	/**
	 * 获取已完成的订单
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getCompletedOrderInfoPage(Order order,int start,int limit);
	/**
	 * 获取进行中的订单
	 * @param order
	 * @return
	 */
	public List<Order> getInOrderInfo(Order order);
	/**
	 * 获取进行中的订单(分页)
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getInOrderInfoByPage(Order order,int start,int limit);
	/**
	 * 统计已完成订单 
	 * @param order
	 * @return
	 */
	public int countCompletedOrder(Order order);
	/**
	 * 统计进行中订单
	 * @param order
	 * @return
	 */
	public int countInOrderInfo(Order order);
	/**
	 * 搜索订单
	 * @param conditions
	 * @return
	 */
	public List<Order> searchOrderInfo(Map<String,Object> conditions);
	
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
	 * 更新订单信息
	 * @param order
	 */
	public void updateOrderInfo(Order order);
	
	/**
	 * 逻辑删除订单
	 * @param order
	 */
	public void logicDeleteOrder(Order order);

	/**
	 * 按天统计订单成交量
	 * @param map
	 * @return
	 */
	public OrderStat countByDay(Map<String,String> map);
	/**
	 * 按月统计订单成交量
	 * @param map 年月（yyyyMM）
	 * @return
	 */
	public List<OrderStat> countByMonth(Map<String,String> map);
	/**
	 * 按天分时统计订单成交量
	 * @param map
	 * @return
	 */
	public List<OrderStat> countByDayHour(Map<String,String> map);
	/**
	 * 按天统计订单成交金额
	 * @param map
	 * @return
	 */
	public OrderStat countMoneyByDay(Map<String,String> map);
	/**
	 * 按天分时统计订单金额
	 * @param map
	 * @return
	 */
	public List<OrderStat> countMoneyByDayHour(Map<String,String> map);
}
