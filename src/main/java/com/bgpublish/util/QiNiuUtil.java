package com.bgpublish.util;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.net.CallRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;

public class QiNiuUtil {
	//访问key
	public static final String accessKey="-fEnz8U73A56AiBnDAxDca7zQKOhXqKW3ewg5Dnt";
	//密钥key
	public static final String secretKey="B1tvmnT882rHUThFDnvDN8T4nTq7aciXFzWxUSuz";
	//空间名称和资源名称
	public static final String bucketName="ingbbtest";
	
	public static final String baseUrl="http://7rf2l9.com1.z0.glb.clouddn.com";
	
	/**
	 * 获取上传文件的token
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 */
	public static String uploadToken() throws AuthException, JSONException{
		//构造凭证
		Mac mac = new Mac(accessKey, secretKey);
		
		//生成密钥
		PutPolicy putPolicy = new PutPolicy(bucketName);

		return putPolicy.token(mac);
	}
	/**
	 * 获取文件URL
	 * @param key
	 * @return
	 */
	public static String downloadUrl(String key){
		String url = baseUrl+"/"+key;
		GetPolicy getPolicy = new GetPolicy();
		try {
			Mac mac = new Mac(accessKey, secretKey);
			url = getPolicy.makeRequest(url, mac);
			return url;
		} catch (AuthException e) {
			return "";
		}
	}
	/**
	 * 删除7牛上的文件
	 * @param key
	 * @return
	 */
	public static String deleteFile(String key){
		Mac mac = new Mac(QiNiuUtil.accessKey, QiNiuUtil.secretKey);
		
		RSClient client = new RSClient(mac);
		CallRet callRet = client.delete(QiNiuUtil.bucketName, key);
		
		return String.valueOf(callRet.ok());
	}
}
