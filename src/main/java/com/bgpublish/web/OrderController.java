package com.bgpublish.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.Merch;
import com.bgpublish.domain.Order;
import com.bgpublish.domain.OrderDetail;
import com.bgpublish.domain.OrderStat;
import com.bgpublish.domain.ResponseInfo;
import com.bgpublish.domain.User;
import com.bgpublish.service.MerchService;
import com.bgpublish.service.OrderService;
import com.bgpublish.util.HttpUtil;

@RestController
@RequestMapping(value="/sgams/order")
public class OrderController {
	private static final Log LOGGER = LogFactory.getLog(OrderController.class);
	
	private @Autowired @Getter @Setter OrderService orderService;
	private @Autowired @Getter @Setter MerchService merchService;

	/**
	 * 生成订单以及订单明细
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/createOrder.do", method = RequestMethod.POST)
	public ResponseEntity<ResponseInfo> createOrder(@RequestBody Order order){
		
		String orderId = "";
		try{
			
			List<OrderDetail> detailList = order.getOrderDetails();
			List<Merch> merchList = new ArrayList<Merch>(); 
			
			if(null == detailList || detailList.isEmpty()){
				return HttpUtil.failure("请先选择购买商品!");
			}
			//反查商家用户ID和名称
			OrderDetail detail = detailList.get(0);
			User user = merchService.queryUserById(detail.getMerch_id()+"");
			order.setSeller_user_id(user.getUser_id());
			order.setSeller_user_name(user.getName());
			
			this.orderService.createOrder(order);
			orderId = order.getOrder_id();
			
			
			for (int i = 0; i < detailList.size(); i++) {
				
				OrderDetail orderDetail = detailList.get(i);
				
				orderDetail.setOrder_id(orderId);
				int merId = orderDetail.getMerch_id();//商品ID
				int amount =  orderDetail.getAmount();//订购商品数量
				//获取商品信息
				Merch merch =  this.merchService.queryMerchById(String.valueOf(merId));
				
				//判断商品是否下架
				if(null == merch || "1".equals(merch.getOut_published())){
					this.orderService.deleteOrder(orderId);//删除相应订单
					return HttpUtil.failure("商品:"+merch.getName()+"已下架!");
				}
				//判断商品库存是否充足
				if(merch.getIn_stock() < amount){
					this.orderService.deleteOrder(orderId);//删除相应订单
					return HttpUtil.failure("商品:"+merch.getName()+"库存不足!");
				}
				
				Merch merchUpdate = new Merch();//商品更新对象,用于更新商品库存
				merchUpdate.setMerch_id(merId);
				merchUpdate.setIn_stock((merch.getIn_stock()-amount));
				merchUpdate.setClassify_id(merch.getClassify_id());
				merchUpdate.setPrice(merch.getPrice());
				merchUpdate.setStore_id(merch.getStore_id());
				merchList.add(merchUpdate);
				
			}
			//批量生成订单明细信息
			this.orderService.createOrderDetailBatch(detailList);
			//批量更新商品信息
			this.merchService.updateMerchBatch(merchList);
			
		} catch(Exception e) {
			LOGGER.error("订单生成失败",e);
			return HttpUtil.failure("订单生成失败!", e.getMessage());
		}
		
		return HttpUtil.success( "订单生成成功!", orderId);
	}
	
	
	/**
	 * 获取订单信息（订单明细）
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/getOrderInfoById.do", method = RequestMethod.GET)
	public Order getOrderInfoById(String orderId){
		Order order = this.orderService.getOrderInfoById(orderId);
		List<OrderDetail> otailList = this.orderService.getOrderDetailsById(orderId);
		order.setOrderDetails(otailList);
		return order;
	}
	
	/**
	 * 获取已关闭的订单
	 * @return
	 */
	@RequestMapping(value="/getClosedOrderInfo.do", method = RequestMethod.POST)
	public List<Order> getClosedOrderInfo(@RequestBody Order order){
		return this.orderService.getClosedOrderInfo(order);
	}
	/**
	 * 获取已关闭的订单(分页)
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	@RequestMapping(value="/getClosedOrderInfoPage.do", method = RequestMethod.POST)
	public List<Order> getClosedOrderInfoPage(@RequestBody Order order,@RequestParam int start,@RequestParam int limit){
		return this.orderService.getClosedOrderInfoPage(order,start,limit);
	}
	
	/**
	 * 获取已完成的订单
	 * @return
	 */
	@RequestMapping(value="/getCompletedOrderInfo.do", method = RequestMethod.POST)
	public List<Order> getCompletedOrderInfo(@RequestBody Order order){
		return this.orderService.getCompletedOrderInfo(order);
	}
	/**
	 * 获取已完成的订单(分页)
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	@RequestMapping(value="/getCompletedOrderInfoPage.do", method = RequestMethod.POST)
	public List<Order> getCompletedOrderInfoPage(@RequestBody Order order,@RequestParam int start,@RequestParam int limit){
		return this.orderService.getCompletedOrderInfoPage(order,start,limit);
	}
	
	/**
	 * 获取进行中的订单（不包括订单完成和取消的订单）
	 * @return
	 */
	@RequestMapping(value="/getInOrderInfo.do", method = RequestMethod.POST)
	public List<Order> getInOrderInfo(@RequestBody Order order){
		return this.orderService.getInOrderInfo(order);
	}
	/**
	 * 获取进行中的订单(分页)
	 * @param order
	 * @param start 起始位置
	 * @param limit 每页显示数据数
	 * @return
	 */
	@RequestMapping(value="/getInOrderInfoByPage.do", method = RequestMethod.POST)
	public List<Order> getInOrderInfoByPage(@RequestBody Order order,@RequestParam int start,@RequestParam int limit){
		return this.orderService.getInOrderInfoByPage(order,start,limit);
	}
	/**
	 * 统计已完成订单 
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/countCompletedOrder.do", method = RequestMethod.POST)
	public int countCompletedOrder(@RequestBody Order order){
		return this.orderService.countCompletedOrder(order);
	}
	/**
	 * 统计进行中订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/countInOrderInfo.do", method = RequestMethod.POST)
	public int countInOrderInfo(@RequestBody Order order){
		return this.orderService.countInOrderInfo(order);
	}
	/**
	 * 搜索订单
	 * @param conditions
	 * @return
	 */
	@RequestMapping(value="/searchOrderInfo.do", method = RequestMethod.POST)
	public List<Order> searchOrderInfo(@RequestBody Map<String,Object> conditions){
		return this.orderService.searchOrderInfo(conditions);
	}
	/**
	 * 逻辑删除订单
	 */
	@RequestMapping(value="/logicDeleteOrder.do",  method = RequestMethod.POST)
	public ResponseEntity<String> logicDeleteOrder(@RequestBody Order order){
		try{
			this.orderService.logicDeleteOrder(order);
		}catch(Exception e) {
			LOGGER.error("订单删除失败",e);
			return HttpUtil.createOkResponseEntity("订单删除失败!");
		}
		
		return HttpUtil.createOkResponseEntity("订单删除成功!");
		
	}
	
	/**
	 * 取消订单
	 */
	@RequestMapping(value="/cencelOrder.do",  method = RequestMethod.POST)
	public ResponseEntity<String> cencelOrder(@RequestBody Order order){
		//判断订单是都出库
		if(!"0".equals(order.getStatus())){
				try{
					
				String orderId = order.getOrder_id();
				order.setStatus("5");
				List<Merch> merchs = new ArrayList<Merch>();
				List<OrderDetail> orderTails = this.orderService.getOrderDetailsById(orderId);
				
				for (int i = 0; i < orderTails.size(); i++) {
					
					int merId = orderTails.get(i).getMerch_id();//商品ID
					int amount =  orderTails.get(i).getAmount();//订购商品数量
					//获取商品信息
					Merch merch =  this.merchService.queryMerchById(String.valueOf(merId));
					
					if(null != merch){
						Merch merchUpdate = new Merch();//商品更新对象,用于更新商品库存
						merchUpdate.setMerch_id(merId);
						merchUpdate.setIn_stock((merch.getIn_stock()+amount));
						merchUpdate.setClassify_id(merch.getClassify_id());
						merchUpdate.setPrice(merch.getPrice());
						merchUpdate.setStore_id(merch.getStore_id());
						merchs.add(merchUpdate);
					}
					
				}
				
				if(null != merchs && merchs.size()>0){
					this.merchService.updateMerchBatch(merchs);//批量更新商品信息
				}
				
		//		this.orderService.deleteOrderTailById(orderId);//删除订单明细信息
				this.orderService.updateOrderInfo(order);//更新订单
			}catch(Exception e) {
				LOGGER.error("订单取消失败",e);
				return HttpUtil.createOkResponseEntity("订单取消失败!");
			}
			
			return HttpUtil.createOkResponseEntity("订单取消成功!");

		}else{
			return HttpUtil.createOkResponseEntity("商品已发货，无法取消订单!");
		}
			
	}
	/**
	 * 更新订单状态信息
	 * @param order
	 */
	@RequestMapping(value="/updateOrderStatus.do",  method = RequestMethod.POST)
	public ResponseEntity<String> updateOrderStatus(@RequestBody Order order){
		try{
			this.orderService.updateOrderStatus(order);//更新订单
			return HttpUtil.createOkResponseEntity("更新订单成功!");
		}catch (Exception e){
			LOGGER.error("更新订单失败",e);
			return HttpUtil.createOkResponseEntity("更新订单失败!");
		}
	}
	/**
	 * 更新订单信息
	 * @param order
	 */
	@RequestMapping(value="/updateOrderInfo.do",  method = RequestMethod.POST)
	public ResponseEntity<String> updateOrderInfo(@RequestBody Order order){
		try{
			this.orderService.updateOrderInfo(order);//更新订单
			return HttpUtil.createOkResponseEntity("更新订单成功!");
		}catch (Exception e){
			LOGGER.error("更新订单失败",e);
			return HttpUtil.createOkResponseEntity("更新订单失败!");
		}
	}
	
	/**
	 * 按天统计订单成交量
	 * @param stat_date
	 * @return
	 */
	@RequestMapping(value="/countByDay.do",  method = RequestMethod.POST)
	public OrderStat countByDay(@RequestBody Map<String,String> map){
		return this.orderService.countByDay(map);
	}
	/**
	 * 按月统计订单成交量
	 * @param stat_date 年月（yyyyMM）
	 * @return
	 */
	@RequestMapping(value="/countByMonth.do",  method = RequestMethod.POST)
	public List<OrderStat> countByMonth(@RequestBody Map<String,String> map){
		return this.orderService.countByMonth(map);
	}
	/**
	 * 按天分时统计订单成交量
	 * @param stat_date
	 * @return
	 */
	@RequestMapping(value="/countByDayHour.do",  method = RequestMethod.POST)
	public List<OrderStat> countByDayHour(@RequestBody Map<String,String> map){
		return this.orderService.countByDayHour(map);
	}
	/**
	 * 按天统计订单成交金额
	 * @param stat_date
	 * @return
	 */
	@RequestMapping(value="/countMoneyByDay.do",  method = RequestMethod.POST)
	public OrderStat countMoneyByDay(@RequestBody Map<String,String> map){
		return this.orderService.countMoneyByDay(map);
	}
	/**
	 * 按天分时统计订单金额
	 * @param stat_date
	 * @return
	 */
	@RequestMapping(value="/countMoneyByDayHour.do",  method = RequestMethod.POST)
	public List<OrderStat> countMoneyByDayHour(@RequestBody Map<String,String> map){
		return this.orderService.countMoneyByDayHour(map);
	}
}
