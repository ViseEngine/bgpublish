/**
 * 
 */
package com.bgpublish.service;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bgpublish.App;

/**
 * @author ps
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})//随机端口
public class GalleryServiceImpTest {
	private @Autowired @Getter @Setter GalleryService galleryService;
	
	@Test
	public void testDeleteGallery(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("merch_id", "1");
		galleryService.deleteGallery(map);
	}

}
