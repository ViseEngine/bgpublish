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
public class DateUtilTest {

	@Test
	public void testYesterday(){
		String yesterday = DateUtil.yesterday();
		Assert.assertEquals("20150720", yesterday);
	}
	
	@Test
	public void testGetDayOfMonth(){
		String month = "201502";
		int days = DateUtil.getDayOfMonth(month);
		
		Assert.assertEquals(28, days);
	}
}
