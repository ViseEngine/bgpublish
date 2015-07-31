/**
 * 
 */
package com.bgpublish.service;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgpublish.domain.Gallery;
import com.bgpublish.mapper.GalleryMapper;

/**
 * 图片服务接口实现类
 * @author ps
 *
 */
@Service
public class GalleryServiceImp implements GalleryService {

	private @Autowired @Setter @Getter GalleryMapper galleryMapper;

	/**
	 * 新增图片信息
	 * @param gallery 图片信息
	 */
	public void addGallery(Gallery gallery){
		this.galleryMapper.addGallery(gallery);
	}
	/**
	 * 删除图片信息
	 * @param map
	 */
	public void deleteGallery(Map<String,String> map){
		this.galleryMapper.deleteGallery(map);
	}
	/**
	 * 更新图片信息
	 * @param gallery 图片信息
	 */
	public void updateGallery(Gallery gallery){
		this.galleryMapper.updateGallery(gallery);
	}
	/**
	 * 根据图片ID查询图片信息
	 * @param gallery_id 图片ID
	 * @return
	 */
	public Gallery queryById(String gallery_id){
		return this.galleryMapper.queryById(gallery_id);
	}
	/**
	 * 根据商品ID查询图片信息
	 * @param merch_id 商品ID
	 * @return
	 */
	public List<Gallery> queryByMerchId(String merch_id){
		return this.galleryMapper.queryByMerchId(merch_id);
	}
	/**
	 * 根据分类ID查询图片信息
	 * @param classify_id 分类ID
	 * @return
	 */
	public Gallery queryByClassifyId(String classify_id){
		return this.galleryMapper.queryByClassifyId(classify_id);
	}
}
