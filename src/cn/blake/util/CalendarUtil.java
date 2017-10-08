package cn.blake.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理Util_
 * 
 * @author Blake.Zhou
 *
 */
public class CalendarUtil {
	/**
	 * @see 获取当下时间
	 * @return
	 */
	public static String time() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		// 获得当前月份
		String month = String.valueOf(date.get(Calendar.MONTH) + 1);
		// 获得当前日
		String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		// 获得当前时钟
		String hour = String.valueOf(date.get(Calendar.HOUR));
		// 获得当前分钟
		String minute = String.valueOf(date.get(Calendar.MINUTE));
		// 获得当前秒钟
		String second = String.valueOf(date.get(Calendar.SECOND));
		// 打印出当前日期
		String dateTime = year + "年 " + month + "月 " + day + "日 " + hour + ":" + minute + ":" + second;
		return dateTime;
	}
	/**
	 * @see 获取传入的值的时间字符串
	 * @param millis
	 * @return
	 */
	public static String time(long millis) {
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(millis);
		String year = String.valueOf(date.get(Calendar.YEAR));
		// 获得当前月份
		String month = String.valueOf(date.get(Calendar.MONTH) + 1);
		// 获得当前日
		String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		// 获得当前时钟
		String hour = String.valueOf(date.get(Calendar.HOUR));
		// 获得当前分钟
		String minute = String.valueOf(date.get(Calendar.MINUTE));
		// 获得当前秒钟
		String second = String.valueOf(date.get(Calendar.SECOND));
		// 打印出当前日期
		String dateTime = year + "年 " + month + "月 " + day + "日 " + hour + ":" + minute + ":" + second;
		return dateTime;
	}

	/**
	 * @see 增加多少日或者减少多少日,获取日期字符串
	 * @param dayNumber
	 * @return
	 */
	public static String time(int dayNumber) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_YEAR, dayNumber);
		String dateTime = date.get(Calendar.YEAR) + "年 " + (date.get(Calendar.MONTH) + 1) + "月 " + date.get(Calendar.DAY_OF_MONTH)
				+ "日 " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
		return dateTime;
	}
	/**
	 * @see 按照输入值并且依然通过增加或者减少多少日来获取日期字符串
	 * @param dayNumber
	 * @param millis value
	 * @return
	 */
	public static String time(int dayNumber,long millis) {
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(millis);
		date.add(Calendar.DAY_OF_YEAR, dayNumber);
		String dateTime = date.get(Calendar.YEAR) + "年 " + (date.get(Calendar.MONTH) + 1) + "月 " + date.get(Calendar.DAY_OF_MONTH)
		+ "日 " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
		return dateTime;
	}

	/**
	 * @see 增加多少年或者减少多少年,来获取日期字符串
	 * @param yearNumber
	 * @return
	 */
	public static String time_(int yearNumber) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, yearNumber);
		String dateTime = date.get(Calendar.YEAR) + "年 " + (date.get(Calendar.MONTH) + 1) + "月 " + date.get(Calendar.DAY_OF_MONTH)
				+ "日 " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
		return dateTime;
	}
	/**
	 * @see  依据传入值:增加多少年或者减少多少年,来获取日期字符串
	 * @param yearNumber
	 * @param millis
	 * @return
	 */
	public static String time_(int yearNumber,long millis) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, yearNumber);
		String dateTime = date.get(Calendar.YEAR) + "年 " + (date.get(Calendar.MONTH) + 1) + "月 " + date.get(Calendar.DAY_OF_MONTH)
		+ "日 " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
		return dateTime;
	}
	/**
	 * @see yyyy-MM-dd HH:mm:ss
	 * @param text
	 * @return
	 */
	public static Date formate(String text){
    	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = null;
    	try {
			date = dateformat.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
    }

}
