/**
 * 
 */
package com.bgpublish.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 常用地址Bean
 * @author ps
 *
 */
public class FrequentlyAddress {
	private @Setter @Getter int freqa_id;
	private @Setter @Getter int user_id;
	private @Setter @Getter int address_id;
	private @Setter @Getter String address;//详细地址
	private @Setter @Getter String postcode;//邮编
	private @Setter @Getter String mobile;
	private @Setter @Getter String user_name;
	private @Setter @Getter String create_time;
}
