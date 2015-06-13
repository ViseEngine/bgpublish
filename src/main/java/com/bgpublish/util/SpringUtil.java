/**
 * 
 */
package com.bgpublish.util;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 
 * @author ps
 *
 */
public class SpringUtil {
	private @Autowired @Getter @Setter ApplicationContext applicationContext;
}
