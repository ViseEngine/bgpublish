/**
 * 
 */
package com.bgpublish.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 验证器的单元测试
 * @author ps
 *
 */
public class ValidatorTest {
	
	@Test
	public void testIsEmail(){
		Assert.assertEquals(true, Validator.isEmail("psyuhen@163.com"));
		
		Assert.assertEquals(false, Validator.isEmail("@google.com"));
	}
	
	@Test
	public void testIsIPV4(){
		Assert.assertEquals(true, Validator.isIPV4("128.128.0.1"));
		
		Assert.assertEquals(false, Validator.isIPV4("354.125.125.145"));
	}

	@Test
	public void testIsChinese(){
		Assert.assertEquals(true, Validator.isChinese("我是中国人"));
		
		Assert.assertEquals(false, Validator.isChinese("我a是中国人"));
	}
	
	@Test
	public void testIsPassword(){
		Assert.assertEquals(true, Validator.isPassword("sgams_1234"));
		
		Assert.assertEquals(false, Validator.isPassword("123_qwqw"));
	}
	
	@Test
	public void testIsPwdLength(){
		Assert.assertEquals(true, Validator.isPwdLength("sgams_1234"));
		
		Assert.assertEquals(false, Validator.isPwdLength("123_"));
		
		Assert.assertEquals(false, Validator.isPwdLength("sgams_1234sgams_1234sgams_1234"));
	}
	
	@Test
	public void testIsMobile(){
		Assert.assertEquals(true, Validator.isMobile("13598462345"));
		Assert.assertEquals(true, Validator.isMobile("18598462345"));
		Assert.assertEquals(true, Validator.isMobile("17798462345"));
		Assert.assertEquals(true, Validator.isMobile("15598462345"));
		
		Assert.assertEquals(false, Validator.isMobile("11598462345"));
		Assert.assertEquals(false, Validator.isMobile("123_qwqw"));
		Assert.assertEquals(false, Validator.isMobile("14698462345"));
	}
	
	@Test
	public void testIdCard(){
		Assert.assertEquals(true, Validator.isIDcard("440982198610034956"));
		
		Assert.assertEquals(false, Validator.isIDcard("140982198610034958"));
	}
	
	@Test
	public void testIsNumber(){
		Assert.assertEquals(true, Validator.isNumber("13598462345"));
		Assert.assertEquals(true, Validator.isNumber("13598462345.001"));
		Assert.assertEquals(true, Validator.isNumber("13598462345L"));
		Assert.assertEquals(true, Validator.isNumber("3e10"));
		
		Assert.assertEquals(false, Validator.isNumber("a3e10"));
	}
}
