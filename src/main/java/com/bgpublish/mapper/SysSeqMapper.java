/**
 * 
 */
package com.bgpublish.mapper;

import com.bgpublish.domain.SysSeq;

/**
 * 序列接口
 * @author ps
 *
 */
public interface SysSeqMapper {
	/**
	 * 增加序列
	 * @param sysSeq
	 */
	public void addSequence(SysSeq sysSeq);
	/**
	 * 根据序列名称查询序列信息
	 * @param name
	 * @return
	 */
	public SysSeq queryBySeqName(String name);
	
	/**
	 * 更新序列值
	 * @param sysSeq
	 */
	public void updateSequence(SysSeq sysSeq);
	
	/**
	 * 调用mysql函数生成序列
	 * @param name
	 * @return
	 */
	public Integer generate(String name);
}
