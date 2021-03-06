/**
 * 
 */
package com.bgpublish.service;

import java.util.List;

import com.bgpublish.domain.Classify;

/**
 * 分类接口
 * @author ps
 *
 */
public interface ClassifyService {
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
	 * 更新分类
	 * @param classify
	 */
	public void updateClassify(Classify classify);
	/**
	 * 查询所有分类
	 * @return 分类
	 */
	public List<Classify> queryClassify();
	/**
	 * 根据Id查询分类
	 * @param classify_id
	 * @return 分类
	 */
	public Classify queryClassifyById(String classify_id);
	/**
	 * 查询所有商品分类和数量
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
	 * @param classify_type
	 * @return 分类
	 */
	public List<Classify> queryClassifyByType(String classify_type);
	/**
	 * 根据用户ID查询所有分类
	 * @param user_id
	 * @return 分类
	 */
	public List<Classify> queryClassifyByUserId(String user_id);
	/**
	 * 根据用户ID查询所有分类
	 * @param user_id
	 * @param start
	 * @param limit
	 * @return 分类
	 */
	public List<Classify> queryClassifyByUserIdPage(String user_id,int start,int limit);
	/**
	 * 根据商家ID查询所有分类
	 * @param store_id
	 * @return 分类
	 */
	public List<Classify> queryClassifyByStoreId(String store_id);
}
