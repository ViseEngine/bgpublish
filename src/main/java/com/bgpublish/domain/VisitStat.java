/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家访问信息
 * @author ps
 *
 */
public class VisitStat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3893378343020310815L;
	private @Setter @Getter int user_id;//用户
	private @Setter @Getter int store_id;//商家ID
	private @Setter @Getter String stat_date;//统计日期
	private @Setter @Getter int visit_count;//收藏数
}
