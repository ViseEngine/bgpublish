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
	private @Getter @Setter String name;
	private @Getter @Setter String classify_type;
	private @Getter @Setter int classify_num;
}
