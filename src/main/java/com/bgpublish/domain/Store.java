/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家信息
 * 
 * @author ps
 *
 */
public class Store implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8925076764062515747L;
	private @Getter @Setter int store_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String name;
	private @Getter @Setter String person;
	private @Getter @Setter String address;
	private @Getter @Setter String phone;
	private @Getter @Setter String logo;
	private @Getter @Setter String desc;
	private @Getter @Setter String classify_id;
	private @Getter @Setter String last_modify_time;
	private @Getter @Setter String create_time;
	private @Getter @Setter int sales_volume;
}
