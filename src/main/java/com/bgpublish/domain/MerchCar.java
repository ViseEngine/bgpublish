/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 购物车
 * @author ps
 *
 */
public class MerchCar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter int car_id;
	private @Getter @Setter int merch_id;
	private @Getter @Setter int buy_num;
	private @Getter @Setter String create_time;
	
	private @Getter @Setter String name;
	private @Getter @Setter String desc;
	private @Getter @Setter float price;

}
