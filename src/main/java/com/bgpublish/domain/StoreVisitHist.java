/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家访问历史
 * @author ps
 *
 */
public class StoreVisitHist  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2914418093930189108L;
	private @Getter @Setter int store_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String create_time;
}
