/**
 * 
 */
package com.bgpublish.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.ChatOffLineMsg;
import com.bgpublish.domain.User;
import com.bgpublish.mapper.ChatOffLineMsgMapper;
import com.bgpublish.mapper.UserMapper;
import com.bgpublish.util.DateUtil;

/**
 * 离线信信服务实现类
 * @author ps
 *
 */
@Service
public class ChatOffLineMsgServiceImp implements ChatOffLineMsgService {
	
	private @Autowired @Getter @Setter ChatOffLineMsgMapper chatOffLineMsgMapper;
	private @Autowired @Getter @Setter UserMapper userMapper;

	/**
	 * 增加离线信息
	 * @param chatOffLineMsg
	 */
	public void addOffLineMsg(ChatOffLineMsg chatOffLineMsg){
		chatOffLineMsgMapper.addOffLineMsg(chatOffLineMsg);
	}
	
	/**
	 * 增加离线信息
	 * @param fromMobile 发送人手机号码
	 * @param toMobile 接收人手机号码
	 * @param type 类型
	 * @param chatContent 内容
	 */
	@Override
	public void addOffLine(String fromMobile, String toMobile, String type,
			String chatContent) {
		User fromUser = userMapper.selectUserByMobile(fromMobile);
		User toUser = userMapper.selectUserByMobile(toMobile);
		
		ChatOffLineMsg chatOffLineMsg = new ChatOffLineMsg();
		chatOffLineMsg.setIs_read("0");
		chatOffLineMsg.setTo_user_id(toUser.getUser_id());
		chatOffLineMsg.setTo_user_name(toUser.getName());
		chatOffLineMsg.setFrom_user_id(fromUser.getUser_id());
		chatOffLineMsg.setFrom_user_name(fromUser.getName());
		chatOffLineMsg.setChat_type(type);
		chatOffLineMsg.setChat_content(chatContent);
		chatOffLineMsg.setChat_date(DateUtil.today());
		chatOffLineMsg.setChat_time(DateUtil.today("HHmmss"));
		
		addOffLineMsg(chatOffLineMsg);
	}
	/**
	 * 增加离线信息
	 * @param fromUserId 发送人用户Id
	 * @param toUserId 接收人用户Id
	 * @param type 类型
	 * @param chatContent 内容
	 */
	public void addOffLine2(String fromUserId,String toUserId,String type,String chatContent){
		User fromUser = userMapper.selectUserById(fromUserId);
		User toUser = userMapper.selectUserById(toUserId);
		
		ChatOffLineMsg chatOffLineMsg = new ChatOffLineMsg();
		chatOffLineMsg.setIs_read("0");
		chatOffLineMsg.setTo_user_id(toUser.getUser_id());
		chatOffLineMsg.setTo_user_name(toUser.getName());
		chatOffLineMsg.setFrom_user_id(fromUser.getUser_id());
		chatOffLineMsg.setFrom_user_name(fromUser.getName());
		chatOffLineMsg.setChat_type(type);
		chatOffLineMsg.setChat_content(chatContent);
		chatOffLineMsg.setChat_date(DateUtil.today());
		chatOffLineMsg.setChat_time(DateUtil.today("HHmmss"));
		
		addOffLineMsg(chatOffLineMsg);
	}
	/**
	 * 根据chat_id删除离线信息
	 * @param chat_id
	 */
	public void deleteOffLineMsgById(String chat_id){
		chatOffLineMsgMapper.deleteOffLineMsgById(chat_id);
	}
	/**
	 * 更新离线信息
	 * @param chatOffLineMsg
	 */
	public void updateOffLineMsg(ChatOffLineMsg chatOffLineMsg){
		chatOffLineMsgMapper.updateOffLineMsg(chatOffLineMsg);
	}
	
	/**
	 * 根据chat_id查询离线信息
	 * @param chat_id
	 * @return
	 */
	public List<ChatOffLineMsg> queryByChatId(String chat_id){
		return chatOffLineMsgMapper.queryByChatId(chat_id);
	}
	
	/**
	 * 根据发送人和接收人查询离线信息
	 * @param map
	 * @return
	 */
	public List<ChatOffLineMsg> queryByUserId(Map<String,String> map){
		return chatOffLineMsgMapper.queryByUserId(map);
	}

	/**
	 * 根据发送人和接收人查询离线信息
	 * @param from_user_mobile
	 * @param to_user_mobile
	 * @return
	 */
	public List<ChatOffLineMsg> queryByMobile(String from_user_mobile,String to_user_mobile){
		User fromUser = userMapper.selectUserByMobile(from_user_mobile);
		User toUser = userMapper.selectUserByMobile(to_user_mobile);
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("from_user_id", String.valueOf(fromUser.getUser_id()));
		map.put("to_user_id", String.valueOf(toUser.getUser_id()));
		
		return queryByUserId(map);
	}
}
