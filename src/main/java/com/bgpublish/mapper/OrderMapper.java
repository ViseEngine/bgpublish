/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;

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
	 * 更新订单信息
	 * @param order
	 */
	public void updateOrderInfo(Order order);

	public void logicDeleteOrder(Order order);
	
}
