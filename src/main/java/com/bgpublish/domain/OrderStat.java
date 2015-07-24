/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单统计信息
 * @author ps
 *
 */
public class OrderStat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -642969046875304699L;
	private @Setter @Getter String stat_date;//统计日期
	private @Setter @Getter String status;//订单状态
	private @Setter @Getter int order_sell;//订单销量
	private @Setter @Getter float amount_money;//成交金额
}
