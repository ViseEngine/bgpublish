/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家收藏统计信息
 * @author ps
 *
 */
public class FavoriteStat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316600252296963474L;
	private @Setter @Getter int user_id;//用户
	private @Setter @Getter int store_id;//商家ID
	private @Setter @Getter String stat_date;//统计日期
	private @Setter @Getter int favorite_count;//收藏数
}
