/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.ChatOffLineMsg;

/**
 * 离线信息
 * @author ps
 *
 */
public interface ChatOffLineMsgService {
	/**
	 * 增加离线信息
	 * @param chatOffLineMsg
	 */
	public void addOffLineMsg(ChatOffLineMsg chatOffLineMsg);
	/**
	 * 增加离线信息
	 * @param fromMobile 发送人手机号码
	 * @param toMobile 接收人手机号码
	 * @param type 类型
	 * @param chatContent 内容
	 */
	public void addOffLine(String fromMobile,String toMobile,String type,String chatContent);
	/**
	 * 增加离线信息
	 * @param fromUserId 发送人用户Id
	 * @param toUserId 接收人用户Id
	 * @param type 类型
	 * @param chatContent 内容
	 */
	public void addOffLine2(String fromUserId,String toUserId,String type,String chatContent);
	
	/**
	 * 根据chat_id删除离线信息
	 * @param chat_id
	 */
	public void deleteOffLineMsgById(String chat_id);
	/**
	 * 更新离线信息
	 * @param chatOffLineMsg
	 */
	public void updateOffLineMsg(ChatOffLineMsg chatOffLineMsg);
	
	/**
	 * 根据chat_id查询离线信息
	 * @param chat_id
	 * @return
	 */
	public List<ChatOffLineMsg> queryByChatId(String chat_id);
	
	/**
	 * 根据发送人和接收人查询离线信息
	 * @param from_user_id
	 * @param to_user_id
	 * @return
	 */
	public List<ChatOffLineMsg> queryByUserId(String from_user_id,String to_user_id);
	/**
	 * 根据发送人和接收人查询离线信息
	 * @param from_user_mobile
	 * @param to_user_mobile
	 * @return
	 */
	public List<ChatOffLineMsg> queryByMobile(String from_user_mobile,String to_user_mobile);
}
