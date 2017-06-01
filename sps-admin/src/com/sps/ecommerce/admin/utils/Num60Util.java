package com.sps.ecommerce.admin.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 把大于0 小于 60 的整数转换为字母
 * @author Administrator
 *
 */
public class Num60Util {
	
	private static final char[] numbers = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
		'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
		'y', 'z'
	};
	
	/**
	 * 通过 Num60Util 转换后的时间位数
	 */
	public static final int TIME_LENGTH = 6;

	private Num60Util() {
	}
	
	/**
	 * 把普通数字转换为字符
	 * @param n
	 * @return 字符或0
	 */
	public static char getNumber60(int n) {
		if (n >= 0 && n < 60) {
			return numbers[n];
		}
		return 0;
	}
	
	/**
	 * 把字符转换为普通数字
	 * @param c
	 * @return 大于0的数或-1
	 */
	public static int getNumber(int c) {
		int num0 = '0';
		int num9 = '9';
		int A = 'A';
		int Z = 'Z';
		int a = 'a';
		int z = 'z';
		if (c >= num0 && c <= num9) {
			return c - num0;
		}
		else if (c >= A && c <= Z) {
			return (c - A + 10);
		}
		else if (c >= a && c <= z) {
			return (c - a + 10 + 26);
		}
		return -1;
	}
	
	/**
	 * 把当前时间转换成字符串，此函数在2060年之前有效
	 * @return
	 */
	public static String encodeCurrentTime() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if (year >= 2060) {
			throw new IllegalArgumentException("year >= 2060");
		}
		
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return "" + getNumber60(year % 100) + getNumber60(month) + getNumber60(day)
			+ getNumber60(hour) + getNumber60(minute) + getNumber60(second);
	}

	/**
	 * 把编码过的时间解码
	 * @param time
	 * @return
	 */
	public static String decodeTime(String time) {
		if (time == null || time.length() != TIME_LENGTH) {
			return null;
		}
		
		String s = "";
		int n;
		for (int i=0; i < time.length(); i++) {
			n = getNumber(time.charAt(i));
			if (i == 0) {
				n += 2000; // 年
			}
			s += (n < 10 ? "0" + n : n);
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Date());
		String s = encodeCurrentTime();
		System.out.println(s);
		System.out.println(decodeTime(s));
	}

}
