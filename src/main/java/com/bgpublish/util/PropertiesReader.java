/**
 * 
 */
package com.bgpublish.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 配置文件读取
 * @author ps
 *
 */
public class PropertiesReader {
	private static final Log LOGGER = LogFactory.getLog(PropertiesReader.class);
	private static final PropertiesReader PROPERTIES_READER = new PropertiesReader();
	private static PropertiesConfiguration prop;
	
	private PropertiesReader(){}
	
	static{
		try {
			prop = new PropertiesConfiguration("errorcode.properties");
		} catch (ConfigurationException e) {
			LOGGER.error("读取errorcode.properties失败",e);
		}
	}
	
	public static PropertiesReader getInstance(){
		return PROPERTIES_READER;
	}
	
	/**
	 * Searches for the property with the specified key in this property list. If the key is not found in this property list, the default property list, and its defaults, recursively, are then checked. The method returns null if the property is not found.
	 * @param property key the property key.
	 * @return the value in this property list with the specified key value.
	 */
	public String getString(String property){
		return prop.getString(property);
	}
	/**
	 * Searches for the property with the specified key in this property list. If the key is not found in this property list, the default property list, and its defaults, recursively, are then checked. The method returns null if the property is not found.
	 * @param property key the property key.
	 * @param defaultValue default value
	 * @return the value in this property list with the specified key value.
	 */
	public String getString(String property,String defaultValue){
		return prop.getString(property,defaultValue);
	}
	
	/**
	 * Searches for the property with the specified key in this property list. If the key is not found in this property list, the default property list, and its defaults, recursively, are then checked. The method returns null if the property is not found.
	 * @param property key the property key.
	 * @return the value in this property list with the specified key value.
	 */
	public String getProperty(String property){
		return getString(property);
	}
	/**
	 * Searches for the property with the specified key in this property list. If the key is not found in this property list, the default property list, and its defaults, recursively, are then checked. The method returns null if the property is not found.
	 * @param property key the property key.
	 * @param defaultValue default value
	 * @return the value in this property list with the specified key value.
	 */
	public String getProperty(String property,String defaultValue){
		return getString(property,defaultValue);
	}
	
	/**
	 * 获取属性文件值列表
	 * @param property
	 * @return
	 */
	public String[] getStringArray(String property){
		return prop.getStringArray(property);
	}
}
