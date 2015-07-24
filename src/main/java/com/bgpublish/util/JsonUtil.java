/**
 * 
 */
package com.bgpublish.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 * @author ps
 *
 */
public class JsonUtil {
	private static final Log LOGGER = LogFactory.getLog(JsonUtil.class);

	 /**
     * 把json字符串转换为一个Map
     * @param json json字符串
     * @return
     */
    public static HashMap<String, String> parse2Map(String json) {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
        HashMap<String, String> map = null;
        try {
        	map = mapper.readValue(json, typeRef);
        } catch (JsonParseException e) {
        	LOGGER.error("json转换失败", e);
        } catch (JsonMappingException e) {
        	LOGGER.error("jsonMapping失败", e);
        } catch (IOException e) {
        	LOGGER.error("jsonIO 异常", e);
        }

        return map;
    }
    
    /**
     * 把json字符串转换为一个List Map
     * @param json json字符串
     * @return
     */
    public static List<HashMap<String, String>> parse2ListMap(String json) {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        TypeReference<ArrayList<HashMap<String, String>>> typeRef = new TypeReference<ArrayList<HashMap<String, String>>>() {};
        List<HashMap<String, String>> list = null;
		try {
			list = mapper.readValue(json, typeRef);
		}  catch (JsonParseException e) {
        	LOGGER.error("json转换失败", e);
        } catch (JsonMappingException e) {
        	LOGGER.error("jsonMapping失败", e);
        } catch (IOException e) {
        	LOGGER.error("jsonIO 异常", e);
        }

        return list;
    }
}
