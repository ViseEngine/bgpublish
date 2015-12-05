/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;
import java.util.Map;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;
import com.bgpublish.domain.OrderStat;

/**
 * 用户Mapper接口
 * @author pansen
 * @see src/main/resources/com/bgpublish/mapper/OrderMapper.xml
 */
public interface OrderMapper {
	
	/**
	 * 根据订单信息生成新订单
	 * @param id 用户 Id
	 * @return 返回User对象
	 */
	public void createOrder(Order order);
	
	/**
	 * 批量生成订单明细
	 * @param OrderDetail数组 
	 */
	public void createOrderDetailBatch(List<OrderDetail> otail);
	
	/**
	 * 根据订单ID获取订单基本信息
	 * @param orderId
	 * @return
	 */
	public Order getOrderInfoById(String orderId);
	/**
	 * 根据ID获取订单的信息
	 * @param orderId
	 * @return
	 */
	public Order getDetailsById(String orderId);
	/**
	 * 获取已关闭的订单
	 * @param order
	 * @return
	 */
	public List<Order> getClosedOrderInfo(Order order);
	/**
	 * 获取已完成的订单
	 * @param order
	 * @return
	 */
	public List<Order> getCompletedOrderInfo(Order order);
	/**
	 * 获取进行中的订单
	 * @param order
	 * @return
	 */
	public List<Order> getInOrderInfo(Order order);
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
	 * 根据订单ID获取订单明细信息
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
	 * 更新订单状态信息
	 * @param order
	 */
	public void updateOrderStatus(Order order);
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
