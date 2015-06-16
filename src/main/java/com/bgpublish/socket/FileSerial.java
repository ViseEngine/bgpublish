/**
 * 
 */
package com.bgpublish.socket;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 序列化的文件对象
 * @author ps
 *
 */
public class FileSerial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private @Getter @Setter String fileName;// 文件名称
	private @Getter @Setter long fileLength; // 文件长度
	private @Getter @Setter byte[] fileContent; // 文件内容
	private @Getter @Setter int type;
	private @Getter @Setter String toUser;    //接收用户 (手机号码)
	private @Getter @Setter String fromUser;  //发送用户 （手机号码）
	
	public static final int TYPE_ONLINE = -1;// 上线（用户登录上线）
	public static final int TYPE_OFFLINE = -2;// 下线（用户退出下线）
	public static final int TYPE_OFFLINE_MSG = -3;// 离线信息（默认打开聊天窗口时加载）
	
	/** name保存在filename字段里面  **/  
    public static final int TYPE_NAME = 0;// 连接成功后，向对方发出自己的名字
    
    /** text保存在filename字段里面   */  
    public static final int TYPE_TEXT = 1;// 文字  
    public static final int TYPE_AUDIO = 2;// 音频  
    public static final int TYPE_PICTURE = 3;// 图片
}
