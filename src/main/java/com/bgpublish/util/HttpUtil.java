/**
 * 
 */
package com.bgpublish.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bgpublish.domain.User;

/**
 * HTTP 工具类
 * @author ps
 *
 */
public class HttpUtil {
	/**
	 * 创建response响应信息
	 * @param remessage 简单的返回信息
	 * @param status 响应状态
	 * @return
	 */
	public static ResponseEntity<String> createResponseEntity(String remessage, HttpStatus status) {
        return new ResponseEntity<String>(remessage, status);
    }
	/**
	 * 创建OK response响应信息
	 * @param remessage 简单的返回信息
	 * @return
	 */
	public static ResponseEntity<String> createOkResponseEntity(String remessage) {
		return createResponseEntity(remessage, HttpStatus.OK);
	}
	/**
	 * 创建response响应信息
	 * @param user 用户信息
	 * @param status 响应状态
	 * @return
	 */
	public static ResponseEntity<User> createResponseEntity(User user, HttpStatus status) {
        return new ResponseEntity<User>(user, status);
    }
}
