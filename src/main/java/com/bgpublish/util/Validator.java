/**
 * 
 */
package com.bgpublish.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 校验类
 * 
 * @author ps
 *
 */
public class Validator {
	/**
	 * 校验邮箱地址
	 * @param email 邮箱地址
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isBlank(email)){
			return true;
		}
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, email);
	}

	/**
	 * 验证IPV4
	 * @param ipv4
	 * @return
	 */
	public static boolean isIPV4(String ipv4) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return match(regex, ipv4);
	}

	/**
	 * 校验http(s)URL
	 * @param url
	 * @return
	 */
	public static boolean isUrl(String url) {
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return match(regex, url);
	}

	/**
	 * 校验电话号码
	 * @param telephone
	 * @return
	 */
	public static boolean isTelephone(String telephone) {
		if (StringUtils.isBlank(telephone)){
			return true;
		}
		String result;
		String regex = "^[0-9]+?[0-9-()]*[0-9()]+?$|^[0-9]+?$|^$";
		String regex1 = "\\-{2,}";
		String regex2 = "\\({2,}";
		String regex3 = "\\){2,}";
		result = telephone.replaceAll(regex1, " ");
		result = result.replaceAll(regex2, " ");
		result = result.replaceAll(regex3, " ");
		return match(regex, telephone) && telephone.length() == result.length();
	}

	/**
	 * 校验密码是否为字母开头，包括字母、数字、下划线
	 * @param pwd
	 * @return
	 */
	public static boolean isPassword(String pwd) {
		String regex = "^[a-zA-Z]\\w+";
		return match(regex, pwd);
	}

	/**
	 * 校验密码长度为6到20位
	 * @param pwd
	 * @return
	 */
	public static boolean isPwdLength(String pwd) {
		String regex = "^.{6,20}$";
		return match(regex, pwd);
	}

	/**
	 * 校验6位邮政编码
	 * @param postcode
	 * @return
	 */
	public static boolean isPostalcode(String postcode) {
		String regex = "^\\d{6}$";
		return match(regex, postcode);
	}

	/**
	 * 验证手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		String regex = "^[0,1]+[3,8,5,7]+\\d{9}$";
		return match(regex, mobile);
	}

	/**
	 * 验证身份证号码
	 * @param idCard 身份证号码
	 * @return
	 */
	public static boolean isIDcard(String idCard) {
		byte []wi = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1};
		byte []valideCode = {1,0,10,9,8,7,6,5,4,3,2};
		
		if(StringUtils.isBlank(idCard)){
			return true;
		}
		
		if(idCard.length() != 15 && idCard.length() != 18){
			return false;
		}
		
		String birthday = "";
		String format = "";
		if(idCard.length() == 15){
			birthday = idCard.substring(6, 12);
			format = "yyMMdd";
		}else if(idCard.length() == 18){
			birthday = idCard.substring(6, 14);
			format = "yyyyMMdd";
		}
		
		if(!birthday.equals(DateFormatUtils.format(DateUtil.parseDate(birthday, new String[]{format}), format))){
			return false;
		}
		
		if(idCard.length() == 18){
			int sum = 0;
			
			for (int i = 0; i < 17; i++) {
				sum += wi[i] * Byte.parseByte(idCard.charAt(i)+"");//加权求和
			}
			
			int valCodePostion = sum % 11;//得到验证码位置
			byte last = idCard.charAt(17) == 'X' ? 10 : Byte.parseByte(idCard.charAt(17)+"");
			if(valideCode[valCodePostion] != last){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDecimal(String str) {
		String regex = "^[\\-\\+]?[0123456789]+(.[0123456789]*)?$";
		if (match(regex, str)) {
			try {
				Double.parseDouble(str);
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean isSignlessDecimal(String str) {
		String regex = "^[\\+]?[0-9]+(.[0-9]*)?$";
		return match(regex, str);
	}

	public static boolean isDecimalLength(String str, int intlen, int digitallen) {
		str = str.replace("[\\-\\+]", "");
		String[] strs = str.split("\\.");
		if (strs.length > 1) {
			if (digitallen < 0) {
				return !(strs[0].length() > intlen);
			} else {
				return !(strs[0].length() > intlen || strs[1].length() > digitallen);
			}
		} else {
			return !(strs[0].length() > intlen);
		}
	}

	public static boolean isMonth(String str) {
		String regex = "^(0?[[1-9]|1[0-2])$";
		return match(regex, str);
	}

	public static boolean isBeforeToday(String str) {
		Date nowdate = new Date();
		Date d;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			d = sdf.parse(str);
			cal.setTime(d);
			cal.add(Calendar.DATE, 1);
			if (nowdate.before(cal.getTime())) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean isDay(String str) {
		String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
		return match(regex, str);
	}

	public static boolean isDate(String str) {
		String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
		return match(regex, str);
	}

	public static boolean isNumber(String str) {
		return NumberUtils.isNumber(str);
	}

	public static boolean isIntNumber(String str) {
		if ("0".equals(str))
			return true;
		String regex = "^[\\-\\+]?[1-9][0-9]*$";
		return match(regex, str);
	}

	public static boolean isLetter(String str) {
		String regex = "^[A-Za-z]+$";
		return match(regex, str);
	}

	/**
	 * 判断输入的字符串是否全为中文
	 * @param chinese 中文
	 * @return
	 */
	public static boolean isChinese(String chinese) {
		String regex = "[\u4e00-\u9fa5]+";
		return match(regex, chinese);
	}

	public static boolean isLength(String str) {
		String regex = "^.{8,}$";
		return match(regex, str);
	}

	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean checkHtmlTag(String str) {
		String regex = "^[a-zA-Z0-9],{0,}$";
		return match(regex, str);
	}

	public static boolean hasCrossScriptRisk(String qString, String regx) {
		if (qString != null) {
			qString = qString.trim();
			Pattern p = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(qString);
			return m.find();
		}
		return false;
	}

	/**
	 * 检验字符里面是否有特殊字符
	 * @param qString
	 * @return
	 */
	public static boolean checkString(String qString) {
		String regx = "!|！|@|◎|#|＃|(\\$)|￥|%|％|(\\^)|……|(\\&)|※|(\\*)|×|(\\()|（|(\\))|）|_|——|(\\+)|＋|(\\|)|§ ";
		return hasCrossScriptRisk(qString, regx);
	}

	public static boolean isSelected(String[] select) {
		if (select == null || select.length == 0) {
			return false;
		}
		return true;
	}

	public static boolean isLength(String str, int minlen, int maxlen) {
		int len = 0;
		if (str != null) {
			len = str.length();
		}
		if (len >= minlen && len <= maxlen) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isRepeat(String[] strs) {
		ArrayList<String> search = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if ("".equals(str)) {
				continue;
			}
			int find = Arrays.binarySearch(search.toArray(), str);
			if (find >= 0) {
				return true;
			}
			search.add(str);
		}
		return false;
	}

	public static boolean isEmpty(String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == null || "".equals(strs[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasFullText(String str) {
		if (str == null)
			return false;
		String hanzen = str.replaceAll("[\\x00-\\xff]", "**");
		return hanzen.length() == str.length() ? true : false;
	}
}
