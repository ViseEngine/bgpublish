/**
 * 
 */
package com.bgpublish.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 
 * @author ps
 *
 */
public class StringUtil {
	/** 
     * 使用BigDecimal，保留小数点后两位 
     */  
    public static String format2string(double value) {  
  
        BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(2, RoundingMode.HALF_UP);  
        return bd.toString();  
    } 
    /** 
     * 使用BigDecimal，保留小数点后两位 
     */  
    public static float format2float(double value) {  
    	
    	BigDecimal bd = new BigDecimal(value);  
    	bd = bd.setScale(2, RoundingMode.HALF_UP);  
    	return bd.floatValue();  
    } 
    
    /**
     * 生成11位随机数
     * @return
     */
  	public static String randomSeq() {
  		String now = DateUtil.currentTime();
  		Random random = new Random(System.currentTimeMillis());
  		StringBuilder sb = new StringBuilder(11);
  		for (int i = 0; i < 11; i++) {
  			sb.append("" + random.nextInt(10));
  		}
  		return now + sb.toString();
  	}
}
