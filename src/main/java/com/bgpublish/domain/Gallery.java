/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片库
 * @author ps
 *
 */
public class Gallery  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1362096766120387201L;
	private @Setter @Getter int gallery_id;
	private @Setter @Getter int merch_id;
	private @Getter @Setter int classify_id;
	private @Setter @Getter String name;
	private @Setter @Getter String file_name;
	private @Setter @Getter String path;
	private @Setter @Getter String create_time;
}
