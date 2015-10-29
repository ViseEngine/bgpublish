/**
 * 
 */
package com.bgpublish.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bgpublish.domain.ResponseInfo;
import com.bgpublish.domain.User;

/**
 * HTTP 工具类
 * 
 * @author ps
 *
 */
public class HttpUtil {
	/**
	 * 创建response响应信息
	 * 
	 * @param remessage
	 *            简单的返回信息
	 * @param status
	 *            响应状态
	 * @return
	 */
	public static ResponseEntity<String> createResponseEntity(String remessage, HttpStatus status) {
		return new ResponseEntity<String>(remessage, status);
	}

	/**
	 * 创建OK response响应信息
	 * 
	 * @param remessage
	 *            简单的返回信息
	 * @return
	 */
	public static ResponseEntity<String> createOkResponseEntity(String remessage) {
		return createResponseEntity(remessage, HttpStatus.OK);
	}

	/**
	 * 创建response响应信息
	 * 
	 * @param user
	 *            用户信息
	 * @param status
	 *            响应状态
	 * @return
	 */
	public static ResponseEntity<User> createResponseEntity(User user,
			HttpStatus status) {
		return new ResponseEntity<User>(user, status);
	}

	/**
	 * 创建response响应信息
	 * 
	 * @param responseInfo
	 *            响应信息
	 * @param status
	 *            响应状态
	 * @return
	 */
	public static ResponseEntity<ResponseInfo> createOkResponse(ResponseInfo responseInfo) {
		return new ResponseEntity<ResponseInfo>(responseInfo, HttpStatus.OK);
	}

	/**
	 * 创建response响应信息
	 * 
	 * @param status
	 *            {@link ResponseInfo#SUCCESS}、{@link ResponseInfo#FAILURE}
	 * @param desc
	 *            描述信息
	 * @param dataObj
	 *            给前端返回的数据
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> createOkResponse(String status,String desc, Object dataObj) {
		return createOkResponse(new ResponseInfo(status, desc, dataObj));
	}

	/**
	 * 创建response响应信息,dataObj默认为null
	 * 
	 * @param status
	 *            {@link ResponseInfo#SUCCESS}、{@link ResponseInfo#FAILURE}
	 * @param desc
	 *            描述信息
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> createOkResponse(String status,String desc) {
		return createOkResponse(status, desc, null);
	}

	/**
	 * 创建{@link ResponseInfo#SUCCESS}的response响应信息,dataObj默认为null
	 * 
	 * @param desc
	 *            描述信息
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> success(String desc) {
		return success(desc, null);
	}

	/**
	 * 创建{@link ResponseInfo#SUCCESS}的response响应信息,dataObj默认为null
	 * 
	 * @param desc
	 *            描述信息
	 * @param dataObj
	 *            给前端返回的数据
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> success(String desc,	Object dataObj) {
		return createOkResponse(ResponseInfo.SUCCESS, desc, dataObj);
	}

	/**
	 * 创建{@link ResponseInfo#SUCCESS}的response响应信息,dataObj默认为null
	 * 
	 * @param desc
	 *            描述信息
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> failure(String desc) {
		return failure(desc, null);
	}

	/**
	 * 创建{@link ResponseInfo#SUCCESS}的response响应信息,dataObj默认为null
	 * 
	 * @param desc
	 *            描述信息
	 * @param dataObj
	 *            给前端返回的数据
	 * @return
	 * @see com.bgpublish.domain.ResponseInfo
	 */
	public static ResponseEntity<ResponseInfo> failure(String desc,	Object dataObj) {
		return createOkResponse(ResponseInfo.FAILURE, desc, dataObj);
	}
}
