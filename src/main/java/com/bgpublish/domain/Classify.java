/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 分类
 * @author ps
 *
 */
public class Classify implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4301362764262320094L;

	private @Getter @Setter int classify_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String name;
	private @Getter @Setter String desc;
	private @Getter @Setter String classify_type;
	private @Getter @Setter int classify_num;
	private @Getter @Setter String classify_image;//图片的文件名
}
