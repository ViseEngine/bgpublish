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

import com.bgpublish.domain.Classify;
import com.bgpublish.service.ClassifyService;
import com.bgpublish.util.HttpUtil;

/**
 * 分类Web Controller
 * 
 * @author pansen
 *
 */
@RestController
@RequestMapping(value="/sgams/classify")
public class ClassifyController {

	private @Autowired @Getter @Setter ClassifyService classifyService;
	
	
	@RequestMapping(value="/query.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Classify> queryClassify(){
		List<Classify> list = this.classifyService.queryClassify();
		
		return list;
	}

	@RequestMapping(value="/countclassifymerch.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Classify> countClassifyMerch(){
		List<Classify> list = this.classifyService.countClassifyMerch();
		
		return list;
	}

	@RequestMapping(value="/querybytype.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Classify> queryClassifyByType(String classify_type){
		List<Classify> list = this.classifyService.queryClassifyByType(classify_type);
		
		return list;
	}

	@RequestMapping(value="/queryby.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Classify> queryClassifyBy(@RequestBody Classify classify){
		List<Classify> list = this.classifyService.queryClassifyBy(classify);
		
		return list;
	}

	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ResponseEntity<String> addClassify(@RequestBody Classify classify){
		try{
			this.classifyService.addClassify(classify);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("新增分类失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("新增分类成功!", HttpStatus.OK);
	}

	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ResponseEntity<String> deleteClassifyById(String classify_id){
		try{
			this.classifyService.deleteClassifyById(classify_id);
		}catch(Exception e){
			e.printStackTrace();
			return HttpUtil.createResponseEntity("删除分类失败!", HttpStatus.BAD_REQUEST);
		}
		
		return HttpUtil.createResponseEntity("删除分类成功!", HttpStatus.OK);
	}
}
