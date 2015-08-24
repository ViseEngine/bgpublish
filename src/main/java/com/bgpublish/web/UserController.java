/**
 * 
 */
package com.bgpublish.web;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.User;
import com.bgpublish.service.UserService;
import com.bgpublish.util.DateUtil;
import com.bgpublish.util.HttpUtil;

/**
 * 用户 信息Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/user")
public class UserController {
	private static final Log LOGGER = LogFactory.getLog(UserController.class);

	//APP Status
	/*private enum AppStatus{
		SALERAPP,//0
		BUYERAPP//1
	}*/
	
	private @Autowired @Getter @Setter UserService userService;

	/**
	 * 根据用户ID查询用户 信息
	 * @param id 用户 ID
	 * @return 返回用户 信息
	 */
	@RequestMapping(value="/query.do", method = RequestMethod.GET)
	@ResponseBody
	public User selectUserById(String id) {

		return this.userService.selectUserById(id);
	}

	/**
	 * 根据手机号码和密码登录
	 * @param user 用户 信息
	 * @return 查询到返回用户 信息否则返回null
	 */
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	@ResponseBody
	public User login(@RequestBody User user) {
		User login = this.userService.login(user);
		return login;
	}
	
	/**
	 * 判断手机号是否已被注册
	 * @param mobile 用户手机号码
	 * @return 已注册返回true，否则返回false
	 */
	@RequestMapping(value="/isregister.do", method = RequestMethod.GET)
	public boolean isMobileRegister(@RequestParam String mobile) {

		User user = this.userService.selectUserByMobile(mobile);
		
		if(user != null){
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody User user){
		
		//非空检验
		if("".equals(StringUtils.trimToEmpty(user.getPassword()))){
			return HttpUtil.createResponseEntity("密码不能为空!", HttpStatus.BAD_REQUEST);
		}
		
		//密码由前端编码后传入，不再判断
		/*if(!Validator.isPwdLength(user.getPassword())){
			return HttpUtil.createResponseEntity("密码长度为6到20位!", HttpStatus.BAD_REQUEST);
		}*/
		
		/*if(!Validator.isPassword(user.getPassword())){
			return HttpUtil.createResponseEntity("密码必须为数字和字母!", HttpStatus.BAD_REQUEST);
		}*/
		
		if("".equals(StringUtils.trimToEmpty(user.getMobile()))){
			return HttpUtil.createResponseEntity("手机号码不能为空!", HttpStatus.BAD_REQUEST);
		}
		
		//如果是卖家，要判断商家名称和详细地址
		/*if(AppStatus.SALERAPP.toString().equals(StringUtils.trimToEmpty(user.getUser_type()))){
			if("".equals(StringUtils.trimToEmpty(user.getAddress()))){
				return HttpUtil.createResponseEntity("商家地址不能为空!", HttpStatus.BAD_REQUEST);
			}
			
			if("".equals(StringUtils.trimToEmpty(user.getShop_name()))){
				return HttpUtil.createResponseEntity("商家名称不能为空!", HttpStatus.BAD_REQUEST);
			}
		}*/
		
		
		user.setCreate_time(DateUtil.today("yyyyMMddHHmmss"));
		
		User chkUser = this.userService.selectUserByMobile(user.getMobile());
		if(chkUser != null){
			return HttpUtil.createResponseEntity("手机号码已注册!", HttpStatus.BAD_REQUEST);
		}
		
		try{
			this.userService.register(user);
		} catch(Exception e) {
			LOGGER.error("注册失败",e);
			return HttpUtil.createResponseEntity("注册失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("注册成功!", HttpStatus.OK);
	}
	
	/**
	 * 修改密码
	 * @param user 用户信息
	 */
	@RequestMapping(value="/modifypwd.do", method = RequestMethod.POST)
	public ResponseEntity<String> updatePassWord(@RequestBody User user){
		//先验证原来的用户和密码是否正确
		User oldUser = new User();
		oldUser.setMobile(user.getMobile());
		oldUser.setPassword(user.getOld_password());
		oldUser.setUser_type(user.getUser_type());
		
		oldUser = this.userService.login(oldUser);
		if(oldUser == null){
			return HttpUtil.createResponseEntity("修改密码失败", HttpStatus.BAD_REQUEST);
		}
		
		boolean existed = this.userService.updatePassWord(user);
		if(existed){
			return HttpUtil.createResponseEntity("修改密码成功", HttpStatus.OK);
		}
		return HttpUtil.createResponseEntity("修改密码失败", HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 忘记密码
	 * @param user 用户信息
	 */
	@RequestMapping(value="/forgetpwd.do", method = RequestMethod.POST)
	public ResponseEntity<String> forgetPassword(@RequestBody User user){
		
		boolean existed = this.userService.forgetPassword(user);
		
		if(existed){
			return HttpUtil.createResponseEntity("修改密码成功", HttpStatus.OK);
		}
		return HttpUtil.createResponseEntity("修改密码失败", HttpStatus.BAD_REQUEST);
	}
}
