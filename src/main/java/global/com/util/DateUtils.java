package global.com.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 按照默认格式，格式化日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parse(String dateStr) {
		return parse(dateStr, SIMPLE_DATE_FORMAT);
	}

	/**
	 * 按照指定格式，格式化日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parse(String dateStr, String pattern) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 按照默认格式，格式化日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static String formate(Date date) {
		return formate(date, SIMPLE_DATE_FORMAT);
	}

	/**
	 * 按照指定格式，格式化日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static String formate(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return date == null ? null : format.format(date);
	}

	/**
	 * 按照指定格式验证日期
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean isValidDate(String str, String pattern) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 验证日期是否为 yyyy-MM-dd格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			convertSuccess = false;
		}
		return convertSuccess;
	}
	
	/**计算两个时间间隔日期
	 * 
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	
	public static int count(Date starttime, Date endtime) {
		int days = (int)((endtime.getTime() - starttime.getTime())/86400000);
		return days;
	}
}
