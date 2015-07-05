/**
 * 
 */
package com.bgpublish.no;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;

import com.bgpublish.domain.SysSeq;
import com.bgpublish.service.SysSeqService;

/**
 * 序列号机制用来生成系统中的序列号
 * 序列号以一个递增的整数为基础，构造出序列字符串
 * @author ps
 *
 */
public class DefaultSequence implements Sequence{
	
	private @Autowired @Setter @Getter SysSeqService sysSeqService; 
	
	@Override
	public boolean isExist(String seqName) {
		SysSeq sysSeq = this.sysSeqService.queryBySeqName(seqName);
		if(sysSeq != null){
			return true;
		}
		return false;
	}
	
	@Override
	public String getSeqNo(String seqName) {
		Integer seqNo = this.sysSeqService.generate(seqName);
		return String.valueOf(seqNo);
	}
}
