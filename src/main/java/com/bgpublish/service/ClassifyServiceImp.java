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
import com.github.pagehelper.PageHelper;

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
	 * 更新分类
	 * @param classify
	 */
	public void updateClassify(Classify classify){
		this.classifyMapper.updateClassify(classify);
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
	 * 根据Id查询分类
	 * @param classify_id
	 * @return 分类
	 */
	public Classify queryClassifyById(String classify_id){
		return this.classifyMapper.queryClassifyById(classify_id);
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
	/**
	 * 根据用户ID查询所有分类
	 * @param user_id
	 * @return 分类
	 */
	public List<Classify> queryClassifyByUserId(String user_id){
		return this.classifyMapper.queryClassifyByUserId(user_id);
	}
	/**
	 * 根据用户ID查询所有分类
	 * @param user_id
	 * @param start
	 * @param limit
	 * @return 分类
	 */
	public List<Classify> queryClassifyByUserIdPage(String user_id,int start,int limit){
		int pageNum = start / limit + 1;
		
		PageHelper.startPage(pageNum, limit);
		return this.classifyMapper.queryClassifyByUserId(user_id);
	}
	/**
	 * 根据商家ID查询所有分类
	 * @param store_id
	 * @return 分类
	 */
	public List<Classify> queryClassifyByStoreId(String store_id){
		return this.classifyMapper.queryClassifyByStoreId(store_id);
	}
}
