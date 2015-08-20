/**
 * 
 */
package com.bgpublish.mapper;

import com.bgpublish.domain.UserLoginHist;

/**
 * 用户登录历史
 * @author ps
 *
 */
public interface UserLoginHistMapper {
	/**
	 * 增加用户登录信息
	 * @param userLoginHist
	 */
	public void addUserLoginHist(UserLoginHist userLoginHist);
}
