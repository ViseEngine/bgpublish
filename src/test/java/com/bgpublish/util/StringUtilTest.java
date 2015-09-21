/**
 * 
 */
package com.bgpublish.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 日期类测试用例
 * @author ps
 *
 */
public class StringUtilTest {

	@Test
	public void testFormat2string(){
		double d = 10.254685;
		
		Assert.assertEquals("10.25", StringUtil.format2string(d));
	}
	
	@Test
	public void testFormat2float(){
		double d = 10.256685;
		
		Assert.assertEquals(10.26, StringUtil.format2float(d),10.26);
	}
	
}
