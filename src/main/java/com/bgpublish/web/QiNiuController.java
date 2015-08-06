/**
 * 
 */
package com.bgpublish.web;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.User;
import com.bgpublish.service.UserService;
import com.bgpublish.util.QiNiuUtil;
import com.qiniu.api.auth.AuthException;

/**
 * 7牛 Controller
 * @author ps
 */
@RestController
@RequestMapping(value="/sgams/qiniu")
public class QiNiuController {
	private static final Log LOGGER = LogFactory.getLog(QiNiuController.class);
	
	private @Autowired @Getter @Setter UserService userService;
	
	/**
	 * 先验证用户是否存在，再获取token
	 * @param user_id 
	 * @return
	 */
	@RequestMapping(value="/getQiNiuToken.do", method = RequestMethod.GET)
	public String getQiNiuToken(String user_id){
		User user = userService.selectUserById(user_id);
		if(user == null){
			return "";
		}
		try {
			String uploadToken = QiNiuUtil.uploadToken();
			return uploadToken;
		} catch (AuthException e) {
			LOGGER.error("授权失败",e);
		} catch (JSONException e) {
			LOGGER.error("JSON转换出错",e);
		}
		
		return "";
	}
	
	/**
	 * 删除文件
	 * @param key 文件名
	 * @return
	 */
	@RequestMapping(value="/deleteFile.do", method = RequestMethod.GET)
	public String deleteFile(String key){
		return QiNiuUtil.deleteFile(key);
	}
	/**
	 * 获取文件URL
	 * @param key 文件名
	 * @return
	 */
	@RequestMapping(value="/downloadUrl.do", method = RequestMethod.GET)
	public String downloadUrl(String key){
		return QiNiuUtil.downloadUrl(key);
	}
}
