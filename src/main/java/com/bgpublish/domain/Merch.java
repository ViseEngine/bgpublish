/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品信息
 * @author ps
 *
 */
public class Merch  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 92033792007790789L;
	private @Getter @Setter int merch_id;
	private @Getter @Setter int store_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String name;
	private @Getter @Setter String desc;
	private @Getter @Setter String unit;//单位
	private @Getter @Setter int classify_id;
	private @Getter @Setter float price;
	private @Getter @Setter int in_stock;
	private @Getter @Setter String published_date;
	private @Getter @Setter String out_published;
	private @Getter @Setter String last_modify_time;
	private @Getter @Setter String create_time;
	private @Getter @Setter String order_by_clause;
	private @Getter @Setter String sm_recommend;
	private @Getter @Setter String free_shipping;
	private @Getter @Setter int sales_volume;
	private @Getter @Setter String image_name;
	private @Getter @Setter float weight;//重量
	private @Getter @Setter String standard;//规格
	
	private @Getter @Setter List<MerchDisacount> merchDisacounts;
}
