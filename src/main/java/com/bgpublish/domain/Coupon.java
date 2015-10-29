/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pansen
 *
 */
public class Coupon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Setter @Getter int coupon_id;
	private @Setter @Getter int store_id;
	private @Setter @Getter float coupon_money;
	private @Setter @Getter float min_order_money;
	private @Setter @Getter int coupon_total;
	private @Setter @Getter int coupon_limit;
	private @Setter @Getter String start_time;
	private @Setter @Getter String end_time;
	private @Setter @Getter String create_time;
	private @Setter @Getter String desc;
	private @Setter @Getter int has_coupon_num;
	private @Setter @Getter int user_coupon_id;
	
}
