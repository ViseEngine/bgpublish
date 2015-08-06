/**
 * 
 */
package com.bgpublish.util;

import org.json.JSONException;
import org.junit.Test;

import com.qiniu.api.auth.AuthException;

/**
 * 7牛测试
 * @author ps
 *
 */
public class QiNiuUtilTest {

	@Test
	public void testUploadToken(){
		try {
			String token = QiNiuUtil.uploadToken();
			System.err.println(token);
		} catch (AuthException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
