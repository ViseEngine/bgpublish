/**
 * 
 */
package com.bgpublish.mapper;

import java.util.List;

import com.bgpublish.domain.Classify;

/**
 * 分类Mapper接口
 * @author ps
 *
 */
public interface ClassifyMapper {
	/**
	 * 增加分类
	 * @param classify
	 */
	public void addClassify(Classify classify);
	/**
	 * 根据ID删除分类内容
	 * @param classify_id
	 */
	public void deleteClassifyById(String classify_id);
	/**
	 * 查询所有分类
	 * @return 分类
	 */
	public List<Classify> queryClassify();
	/**
	 * 查询所有商品分类和商品数
	 * @return 分类
	 */
	public List<Classify> countClassifyMerch();
	/**
	 * 查询所有分类
	 * @param classify 分类条件
	 * @return 分类
	 */
	public List<Classify> queryClassifyBy(Classify classify);
	/**
	 * 根据分类类型查询所有分类
	 * @param classifyType
	 * @return 分类
	 */
	public List<Classify> queryClassifyByType(String classify_type);
}
