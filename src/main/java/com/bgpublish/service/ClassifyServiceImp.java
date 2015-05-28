/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Classify;
import com.bgpublish.mapper.ClassifyMapper;

/**
 * 分类服务接口实现类
 * @author ps
 *
 */
@Service
public class ClassifyServiceImp implements ClassifyService {

	private @Autowired @Getter @Setter ClassifyMapper classifyMapper;
	/**
	 * 增加分类
	 * @param classify
	 */
	@Override
	public void addClassify(Classify classify){
		this.classifyMapper.addClassify(classify);
	}
	/**
	 * 根据ID删除分类内容
	 * @param classify_id
	 */
	@Override
	public void deleteClassifyById(String classify_id){
		this.classifyMapper.deleteClassifyById(classify_id);
	}
	/**
	 * 查询所有分类
	 * @return 分类
	 */
	@Override
	public List<Classify> queryClassify(){
		return this.classifyMapper.queryClassify();
	}

	 /**
         * 查询所有商品分类和商品数
         * @return 分类
         */
	@Override
        public List<Classify> countClassifyMerch(){
		return this.classifyMapper.countClassifyMerch();
	}
	/**
	 * 根据分类条件查询所有分类
	 * @param classify 分类条件
	 * @return 分类
	 */
	@Override
	public List<Classify> queryClassifyBy(Classify classify){
		return this.classifyMapper.queryClassifyBy(classify);
	}
	/**
	 * 根据分类类型查询所有分类
	 * @param classify_type
	 * @return 分类
	 */
	@Override
	public List<Classify> queryClassifyByType(String classify_type) {
		return this.classifyMapper.queryClassifyByType(classify_type);
	}
}
