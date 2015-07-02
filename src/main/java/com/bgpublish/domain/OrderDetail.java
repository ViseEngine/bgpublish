package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单详情表
 * @author wangxl
 *
 */
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1478737471794677275L;
	/*
	private @Getter @Setter String orderId;
	private @Getter @Setter int merchId;
	private @Getter @Setter String merchName;
	private @Getter @Setter int amount;
	private @Getter @Setter String unit;
	private @Getter @Setter float price;
	*/
	
	private @Getter @Setter String order_id;
	private @Getter @Setter int merch_id;
	private @Getter @Setter String merch_name;
	private @Getter @Setter int amount;
	private @Getter @Setter String unit;
	private @Getter @Setter float price;
	
	
	
}
