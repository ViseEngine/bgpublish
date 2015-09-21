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
	
	@Test
	public void testCompareTo(){
		String start_time = "20150917212300";
		Date d = DateUtil.parseDate(start_time, new String[]{"yyyyMMddHHmmss"});
		
		if(d.compareTo(new Date()) < 0){
			System.err.println(1);
		}
	}
}
