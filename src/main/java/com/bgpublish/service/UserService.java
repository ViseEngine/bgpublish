/**
 * 
 */
package com.bgpublish.service;

import com.bgpublish.domain.User;

/**
 * 用户 服务信息接口
 * 
 * @author pansen
 *
 */
public interface UserService {
	/**
	 * 根据用户Id查询用户信息
	 * 
	 * @param id
	 *            用户 Id
	 * @return 返回User对象
	 */
	public User selectUserById(String id);
	/**
	 * 根据手机号码和密码登录
	 * @param user 用户(主要是手机号码和密码【密文】)
	 * @return 返回User对象
	 */
	public User login(User user);
	/**
	 * 根据手机号码查询用户信息
	 * 
	 * @param mobile
	 *            手机号码
	 * @return 返回User对象
	 */
	public User selectUserByMobile(String mobile);
	/**
	 * 根据手机号码查询用户信息
	 * @param mobile 手机号码
	 * @param user_type 用户类型
	 * @return 返回User对象
	 */
	public User queryUserByMobile(String mobile, String user_type);
	/**
	 * 注册用户
	 * @param user 用户信息
	 */
	public void register(User user);
	/**
	 * 修改密码
	 * @param user 用户信息
	 * @return true-修改密码成功
	 */
	public boolean updatePassWord(User user);
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user);
	/**
	 * 忘记密码
	 * @param user 忘记密码
	 * @return true-修改密码成功
	 */
	public boolean forgetPassword(User user);
	/**
	 * 根据store_id 查询用户信息
	 * @param store_id
	 * @return
	 */
	public User queryByStoreId(String store_id);
}
