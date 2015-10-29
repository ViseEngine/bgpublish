/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户 Entity
 * 
 * @author pansen
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1677958995472763643L;
	
	private @Getter @Setter int user_id;
	
	private @Getter @Setter String name;
	
	private @Getter @Setter String password;

	private @Getter @Setter String mobile;

	private @Getter @Setter String address;

	private @Getter @Setter String shop_name;

	private @Getter @Setter String create_time;

	private @Getter @Setter String user_type;

	private @Getter @Setter String qq;

	private @Getter @Setter String we_chat;
	
	private @Getter @Setter String old_password;
	
	private @Getter @Setter int store_id;
	
	private @Getter @Setter String store_name;
	
	private @Getter @Setter String photo;
}
