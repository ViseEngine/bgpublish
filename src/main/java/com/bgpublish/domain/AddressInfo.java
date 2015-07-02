/**
 * 
 */
package com.bgpublish.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 国家地址信息
 * @author ps
 *
 */
public class AddressInfo {
	private @Setter @Getter int address_id;
	private @Setter @Getter String country;//国家
	private @Setter @Getter String province;//省份
	private @Setter @Getter String city;//城市
	private @Setter @Getter String town;//城区
	private @Setter @Getter String postcode;//邮政编码
	private @Setter @Getter String citycode;//区号
}
