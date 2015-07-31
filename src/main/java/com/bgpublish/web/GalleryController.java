/**
 * 
 */
package com.bgpublish.web;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgpublish.domain.Gallery;
import com.bgpublish.service.GalleryService;
import com.bgpublish.util.HttpUtil;

/**
 * 分类Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/gallery")
public class GalleryController {
	private static final Log LOGGER = LogFactory.getLog(GalleryController.class);

	private @Autowired @Getter @Setter GalleryService galleryService;
	
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addGallery(@RequestBody Gallery gallery){
		try{
			this.galleryService.addGallery(gallery);
		}catch(Exception e){
			LOGGER.error("新增图片失败", e);
			return HttpUtil.createResponseEntity("新增图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("新增图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateGallery(@RequestBody Gallery gallery){
		try{
			this.galleryService.updateGallery(gallery);
		}catch(Exception e){
			LOGGER.error("更新图片失败", e);
			return HttpUtil.createResponseEntity("更新图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("更新图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public ResponseEntity<String> deleteGallery(@RequestBody Map<String,String> map){
		try{
			this.galleryService.deleteGallery(map);
		}catch(Exception e){
			LOGGER.error("删除图片失败", e);
			return HttpUtil.createResponseEntity("删除图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/queryById.do", method = RequestMethod.GET)
	@ResponseBody
	public Gallery queryById(String gallery_id){
		Gallery gallery = this.galleryService.queryById(gallery_id);
		
		return gallery;
	}
	
	@RequestMapping(value="/queryByMerchId.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Gallery> queryByMerchId(String merch_id){
		List<Gallery> list = this.galleryService.queryByMerchId(merch_id);
		
		return list;
	}
	
	@RequestMapping(value="/queryByClassifyId.do", method = RequestMethod.GET)
	@ResponseBody
	public Gallery queryByClassifyId(String classify_id){
		Gallery gallery = this.galleryService.queryByClassifyId(classify_id);
		
		return gallery;
	}
}
