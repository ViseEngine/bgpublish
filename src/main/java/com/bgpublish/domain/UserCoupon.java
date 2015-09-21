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
public class UserCoupon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Setter @Getter int user_coupon_id;
	private @Setter @Getter int user_id;
	private @Setter @Getter int coupon_id;
	private @Setter @Getter int has_coupon;
	private @Setter @Getter String create_time;
	
}
