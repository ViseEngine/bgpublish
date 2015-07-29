/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品图片
 * @author ps
 *
 */
public class MerchGallery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5513314376380087013L;
	private @Getter @Setter int gallery_id;
	private @Getter @Setter int merch_id;
	private @Getter @Setter int classify_id;
	private @Getter @Setter String name;
	private @Getter @Setter String file_name;
	private @Getter @Setter String path;
	private @Getter @Setter String create_time;
}
