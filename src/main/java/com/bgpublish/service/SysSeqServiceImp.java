/**
 * 
 */
package com.bgpublish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

import com.bgpublish.domain.SysSeq;
import com.bgpublish.mapper.SysSeqMapper;

/**
 * @author ps
 *
 */
@Service
public class SysSeqServiceImp implements SysSeqService {
	
	private @Autowired @Getter @Setter SysSeqMapper sysSeqMapper;

	/* (non-Javadoc)
	 * @see com.bgpublish.service.SysSeqService#addSequence(com.bgpublish.domain.SysSeq)
	 */
	@Override
	public void addSequence(SysSeq sysSeq) {
		this.sysSeqMapper.addSequence(sysSeq);
	}

	/* (non-Javadoc)
	 * @see com.bgpublish.service.SysSeqService#queryBySeqName(java.lang.String)
	 */
	@Override
	public SysSeq queryBySeqName(String name) {
		return this.sysSeqMapper.queryBySeqName(name);
	}

	/* (non-Javadoc)
	 * @see com.bgpublish.service.SysSeqService#updateSequence(com.bgpublish.domain.SysSeq)
	 */
	@Override
	public void updateSequence(SysSeq sysSeq) {
		this.sysSeqMapper.updateSequence(sysSeq);
	}

	/* (non-Javadoc)
	 * @see com.bgpublish.service.SysSeqService#generate(java.lang.String)
	 */
	@Override
	public Integer generate(String name) {
		return this.sysSeqMapper.generate(name);
	}

}
