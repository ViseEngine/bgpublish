/**
 * 
 */
package com.bgpublish.no;

/**
 * 序列号服务，根据定义的标识生成序列号
 * @author ps
 *
 */
public interface Sequence {
	/**
	 * 判断是否存在id为seqName的序列号
 	 * @param seqName 
	 * @return 存在为true,不存在为false;
	 */
	public boolean isExist(String seqName);
	/**
	 * 获取序列号的值
	 * @param seqName
	 * @return
	 */
	public String getSeqNo(String seqName);
}
