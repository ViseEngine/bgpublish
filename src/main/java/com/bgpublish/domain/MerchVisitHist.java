/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品访问历史
 * @author ps
 *
 */
public class MerchVisitHist  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2914418093930189108L;
	private @Getter @Setter int visit_id;
	private @Getter @Setter int merch_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String create_time;
}
