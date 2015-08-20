/**
 * 
 */
package com.bgpublish.service;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Store;
import com.bgpublish.domain.User;
import com.bgpublish.domain.UserLoginHist;
import com.bgpublish.mapper.StoreMapper;
import com.bgpublish.mapper.UserLoginHistMapper;
import com.bgpublish.mapper.UserMapper;

/**
 * 用户 服务信息实现类
 * 
 * @author pansen
 *
 */
@Service
public class UserServiceImp implements UserService {

	private  @Autowired @Getter @Setter UserMapper userMapper;
	private  @Autowired @Getter @Setter StoreMapper storeMapper;
	private  @Autowired @Getter @Setter UserLoginHistMapper userLoginHistMapper;

	/**
	 * 根据用户Id查询用户信息
	 * 
	 * @param id
	 *            用户 Id
	 * @return 返回User对象
	 * @see com.bgpublish.service.UserService#selectUserById(java.lang.String)
	 */
	@Override
	public User selectUserById(String id) {
		return this.userMapper.selectUserById(id);
	}

	/**
	 * 根据手机号码和密码登录
	 * @param user 用户(主要是手机号码和密码【密文】)
	 * @return 返回User对象
	 */
	@Override
	public User login(User user){
		User login = this.userMapper.login(user);
		UserLoginHist userLoginHist = new UserLoginHist(); 
		if(login == null){
			userLoginHist.setUser_id(0);
			userLoginHist.setUser_name(user.getMobile());
			userLoginHist.setLogin_info("登录失败,用户信息不存在");
			this.userLoginHistMapper.addUserLoginHist(userLoginHist);
			return null;
		}
		
		if("0".equals(user.getUser_type())){//买家登录不用查询商家
			Store store = this.storeMapper.queryStoreByUserId(String.valueOf(login.getUser_id()));
			if(store == null){
				userLoginHist.setUser_id(login.getUser_id());
				userLoginHist.setUser_name(login.getName());
				userLoginHist.setLogin_info("登录成功,但用户商家信息不存在");
				this.userLoginHistMapper.addUserLoginHist(userLoginHist);
				return login;
			}
			login.setStore_id(store.getStore_id());
			login.setStore_name(store.getName());
		}
		
		userLoginHist.setUser_id(login.getUser_id());
		userLoginHist.setUser_name(login.getName());
		userLoginHist.setLogin_info("登录成功");
		this.userLoginHistMapper.addUserLoginHist(userLoginHist);
		return login;
	}
	
	/**
	 * 根据手机号码查询用户信息
	 * 
	 * @param mobile
	 *            手机号码
	 * @return 返回User对象
	 * @see com.bgpublish.service.UserService#selectUserByMobile(java.lang.String)
	 */
	@Override
	public User selectUserByMobile(String mobile) {
		return this.userMapper.selectUserByMobile(mobile);
	}
	
	/**
	 * 注册用户
	 * @param user 用户信息
	 */
	@Override
	public void register(User user){
		this.userMapper.register(user);
	}
	/**
	 * 修改密码
	 * @param user 用户信息
	 */
	@Override
	public boolean updatePassWord(User user){
		this.userMapper.updatePassWord(user);
		
		return this.userMapper.checkUpdatePassword(user) > 0;
	}
	/**
	 * 忘记密码
	 * @param user 忘记密码
	 */
	@Override
	public boolean forgetPassword(User user){
		this.userMapper.forgetPassword(user);
		
		return this.userMapper.checkForgetPassword(user) > 0;
	}
}
