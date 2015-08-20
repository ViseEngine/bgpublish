/**
 * 
 */
package com.bgpublish.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author ps
 *
 */
public class UserLoginHist {
	private @Getter @Setter int login_id;
	private @Getter @Setter int user_id;
	private @Getter @Setter String user_name;
	private @Getter @Setter String login_info;
	private @Getter @Setter String create_time;
}
