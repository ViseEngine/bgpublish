package com.bgpublish.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日期处理工具类 
 * @author ps
 * @since 1.0
 */
public class DateUtil {
	private static final Log LOGGER = LogFactory.getLog(DateUtil.class);

	/**
	 * 获取当前日期，默认格式为yyyyMMdd
	 * @return 当前日期
	 */
	public static String today(){
		return today("yyyyMMdd");
	}
	
	/**
	 * 获取前一天日期
	 * @return
	 */
	public static String yesterday(){
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		return DateFormatUtils.format(instance.getTime(), "yyyyMMdd");
	}
	/**
	 * 获取当前日期
	 * @param format 日期格式
	 * @return 当前日期
	 */
	public static String today(String format){
		return DateFormatUtils.format(Calendar.getInstance(), format);
	}

	/**
	 * 获取当前日期时间，默认格式为yyyyMMddHHmmss
	 * @return 当前日期时间
	 */
	public static String currentTime(){
		return today("yyyyMMddHHmmss");
	}
	
	/**
	 * 封装{DateUtils.parseDate}方法
	 * @param str 转换的日期字符串，不能为空
	 * @param parsePatterns 日期格式
	 * @return
	 */
	public static Date parseDate(String str, String[] parsePatterns){
		Date date = null;
		try {
			date = DateUtils.parseDate(str, parsePatterns);
		} catch (ParseException e) {
			LOGGER.error("转换日期失败",e);
		}
		
		return date;
	}
	/**
	 * 转换Date为字符格式
	 * @param date 时间
	 * @param pattern 格式
	 * @return
	 */
	public static String format(Date date,String pattern) {
		return DateFormatUtils.format(date, pattern);
	}
	
	/**
	 * 转换Date为字符格式
	 * pattern 格式默认为yyyy-MM-dd HH:mm:ss
	 * @param date 时间
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取月份的最大天数
	 * @param month
	 * @return
	 */
	public static int getDayOfMonth(String month){
		month = month.substring(4, 6);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}
	
	/**
	 * <pre>
	 * 获取两时间相差多少分钟
	 * </pre>
	 * @param startday 开始时间
	 * @param endday 结束时间
	 * @return 分钟
	 */
	public static int getDiffMins(Date startday,Date endday){     
        long sl=startday.getTime();
        long el=endday.getTime();       
        long ei=el-sl;           
        return (int)(ei/(60000));
    }
}