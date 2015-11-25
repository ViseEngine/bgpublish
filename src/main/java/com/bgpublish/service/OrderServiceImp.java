/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;
import com.bgpublish.domain.OrderStat;
import com.bgpublish.mapper.OrderMapper;
import com.bgpublish.util.DateUtil;
import com.github.pagehelper.PageHelper;

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
		order.setOrder_id(DateUtil.currentTime() + randomSeq());
		this.orderMapper.createOrder(order);
	}
	
	//生成11位随机数
	private String randomSeq() {
		Random random = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder(11);
		for (int i = 0; i < 11; i++) {
			sb.append("" + random.nextInt(10));
		}
		return sb.toString();
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
	 * 获取已关闭的订单
	 * @param order
	 * @return
	 */
	public List<Order> getClosedOrderInfo(Order order){
		return this.orderMapper.getClosedOrderInfo(order);
	}
	/**
	 * 获取已关闭的订单
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getClosedOrderInfoPage(Order order,int start,int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		return this.orderMapper.getClosedOrderInfo(order);
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
	 * 获取已完成的订单
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getCompletedOrderInfoPage(Order order,int start,int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
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
	 * 获取进行中的订单(分页)
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	public List<Order> getInOrderInfoByPage(Order order,int start,int limit){
		//获取第1页，10条内容，默认查询总数count
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		List<Order> inOrderList = this.orderMapper.getInOrderInfo(order);
		return inOrderList;
	}
	/**
	 * 统计已完成订单 
	 * @param order
	 * @return
	 */
	public int countCompletedOrder(Order order){
		return this.orderMapper.countCompletedOrder(order);
	}
	/**
	 * 统计进行中订单
	 * @param order
	 * @return
	 */
	public int countInOrderInfo(Order order){
		return this.orderMapper.countInOrderInfo(order);
	}
	/**
	 * 搜索订单
	 * @param conditions
	 * @return
	 */
	public List<Order> searchOrderInfo(Map<String,Object> conditions){
		return this.orderMapper.searchOrderInfo(conditions);
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
	public void updateOrderStatus(Order order) {
		this.orderMapper.updateOrderStatus(order);
		
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
