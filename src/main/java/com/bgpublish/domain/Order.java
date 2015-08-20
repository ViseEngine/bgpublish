/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单信息
 * @author ps
 *
 */
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2416617126376984743L;
	
	private @Getter @Setter String order_id;
	/*
	private @Getter @Setter int merch_id;
	private @Getter @Setter String name;
	private @Getter @Setter int amount;
	private @Getter @Setter String unit;
	private @Getter @Setter float price;
	*/
	private @Getter @Setter float amount_money;
	private @Getter @Setter int buyer_user_id;
	private @Getter @Setter String buyer_user_name;
	private @Getter @Setter int seller_user_id;
	private @Getter @Setter String seller_user_name;
	private @Getter @Setter String currency_unit;
	private @Getter @Setter String buyer_name;
//	private @Getter @Setter String buyer_area;
//	private @Getter @Setter String buyer_postcode;
	private @Getter @Setter String buyer_phone;
	private @Getter @Setter String buyer_mobile;
	private @Getter @Setter String send_type;
	private @Getter @Setter String send_no;
	private @Getter @Setter String send_time;
	private @Getter @Setter float freight;
	private @Getter @Setter String invoice_need;
	private @Getter @Setter String invoice_title;
	private @Getter @Setter String pay_type;
	private @Getter @Setter String buyer_pay_time;
	private @Getter @Setter String trad_time;
	private @Getter @Setter String trad_finish_time;
	private @Getter @Setter String update_time;
	private @Getter @Setter String seller_deliver_time;
	private @Getter @Setter String buyer_confirm_time;
	private @Getter @Setter String buyer_del;
	private @Getter @Setter String seller_del;
	private @Getter @Setter String buyer_del_time;
	private @Getter @Setter String seller_del_time;
	private @Getter @Setter String buyer_score;
	private @Getter @Setter String seller_score;
	private @Getter @Setter String status;
	
	//买家地址
	private @Setter @Getter int town_id;
	private @Setter @Getter String province_code;//
	private @Setter @Getter String city_code;//
	private @Setter @Getter String address;//
	
	//买家评价
	private @Setter @Getter String buyer_advise;//
	
	private @Getter @Setter List<OrderDetail> orderDetails;//int
	
	/*
	private @Getter @Setter List<Integer> merch_ids;//int
	private @Getter @Setter List<String> merch_names;//String
	private @Getter @Setter List<Integer> amounts;//int
	private @Getter @Setter List<String> units;//String
	private @Getter @Setter List<Float> prices;//float
	*/
}
