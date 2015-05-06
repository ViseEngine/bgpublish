/**
 * 
 */
package com.bgpublish.web;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

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

	private @Autowired @Getter @Setter GalleryService galleryService;
	
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addGallery(@RequestBody Gallery gallery){
		try{
			this.galleryService.addGallery(gallery);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("新增图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("新增图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateGallery(@RequestBody Gallery gallery){
		try{
			this.galleryService.updateGallery(gallery);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("更新图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("更新图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteGallery(String gallery_id){
		try{
			this.galleryService.deleteGallery(gallery_id);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("删除图片失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除图片成功!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/querybyid.do", method = RequestMethod.GET)
	@ResponseBody
	public Gallery queryById(String gallery_id){
		Gallery gallery = this.galleryService.queryById(gallery_id);
		
		return gallery;
	}
	
	@RequestMapping(value="/query.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Gallery> queryByMerchId(String merch_id){
		List<Gallery> list = this.galleryService.queryByMerchId(merch_id);
		
		return list;
	}
}
