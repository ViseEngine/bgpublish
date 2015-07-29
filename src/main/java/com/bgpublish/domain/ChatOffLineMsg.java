/**
 * 
 */
package com.bgpublish.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 离线信息
 * @author ps
 *
 */
public class ChatOffLineMsg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4301362764262320094L;

	private @Getter @Setter int chat_id;
	private @Getter @Setter int from_user_id;
	private @Getter @Setter int to_user_id;
	private @Getter @Setter String from_mobile;
	private @Getter @Setter String to_mobile;
	private @Getter @Setter String from_user_name;
	private @Getter @Setter String to_user_name;
	private @Getter @Setter String chat_date;
	private @Getter @Setter String chat_time;
	private @Getter @Setter String chat_type;
	private @Getter @Setter String is_read;
	private @Getter @Setter String chat_content;
}
