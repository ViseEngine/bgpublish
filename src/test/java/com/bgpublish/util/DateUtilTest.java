/**
 * 
 */
package com.bgpublish.util;

import java.util.Date;

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
	
	@Test
	public void testGetDiffMins(){
		String now = "20150804230111";
		
		Date d = DateUtil.parseDate(now, new String[]{"yyyyMMddHHmmss"});
		
		int min = DateUtil.getDiffMins(d, new Date());
		
		System.err.println(min);
	}
}
