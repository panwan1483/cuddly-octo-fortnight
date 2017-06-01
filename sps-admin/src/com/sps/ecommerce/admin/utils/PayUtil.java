package com.sps.ecommerce.admin.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 工具类
 * @author wangfucai
 */
public class PayUtil {

	/**
	 * 分隔符
	 */
	public static final String PARAMETER_SEPARATOR = "-";

	/**
	 * 默认数字的总长度(多玩支付系统计数器的长度)
	 */
	public static final int DEFAULT_NUMBER_LENGTH = 10;

	/**
	 * 填充 0
	 */
	private static final String[] ZERO_FILL = new String[] { "", "0", "00",
			"000", "0000", "00000", "000000", "0000000", "00000000",
			"000000000", "0000000000", };

	/**
	 * 把自然数转换成以 0 填充开头的字符串
	 * @param n
	 * @return
	 */
	public static String getZeroFill(int n) {
		return getZeroFill(n, DEFAULT_NUMBER_LENGTH);
	}

	/**
	 * 把自然数转换成以 0 填充开头的字符串
	 * @param n - 数字
	 * @param numLen - 字符串总长度
	 * @return
	 */
	public static String getZeroFill(int n, int numLen) {

		String s = String.valueOf(n);

		// 负数无效
		if (s.charAt(0) == '-') {
			return s;
		}

		int len = numLen - s.length();
		if (len <= 0) {
			return s;
		} else if (len < ZERO_FILL.length) {
			return ZERO_FILL[len] + s;
		}

		// 最多允许 2048 个 0
		if (len > 2048) {
			return s;
		}

		StringBuilder buf = new StringBuilder(numLen + s.length() + 1);
		for (int i = 0; i < len; i++) {
			buf.append('0');
		}

		buf.append(s);
		return buf.toString();
	}

	// ----------------------------------------- 获得 duowan 内部的 orderid

	/**
	 * 获得OrderId, 盈华讯方只允许 18 位的自定义数据 
	 * @param orderId
	 * @return
	 */
	public static String getOrderIdForVNetone(int orderId) {
		if (orderId < 0) {
			throw new IllegalArgumentException("orderId");
		}
		String time = Num60Util.encodeCurrentTime();
		return time + getZeroFill(orderId);
	}

	/**
	 * 把提交到盈华讯方的(duowan内部的) orderId 转换为正常的 orderId
	 * @param vNetoneOrderId
	 * @return
	 */
	public static String getOrderIdFromVNetone(String vNetoneOrderId) {
		if (vNetoneOrderId == null
				|| vNetoneOrderId.length() != Num60Util.TIME_LENGTH
						+ DEFAULT_NUMBER_LENGTH) {
			throw new IllegalArgumentException("vNetoneOrderId");
		}
		String time = vNetoneOrderId.substring(0, Num60Util.TIME_LENGTH);
		time = Num60Util.decodeTime(time);
		return time + vNetoneOrderId.substring(Num60Util.TIME_LENGTH);
	}

	// ------------------------------------------ end

	private static final String RANDOM_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * 获得一个随机的字符串
	 * @param len
	 * @return
	 */
	public static String getRandomString(int len) {
		StringBuilder buf = new StringBuilder(len + 1);
		
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			buf.append(RANDOM_CHARS.charAt(rand.nextInt(RANDOM_CHARS.length())));
		}
		return buf.toString();
	}

	/**
	 * 组装成 string
	 * @param userName - 用户名
	 * @param coin - 金币
	 * @param product - 产品
	 * @param server - 服务器
	 * @return
	 */
	public static String buildString(String userName, int coin, String product,
			String server) {
		// duowan 的用户名不允许 '-' ，因此可以用 '-' 作分隔符
		return userName + PARAMETER_SEPARATOR + coin + PARAMETER_SEPARATOR
				+ (product == null ? "" : product) + PARAMETER_SEPARATOR
				+ (server == null ? "" : server);
	}

	// ------------------------------------------------- 多玩金币

	/**
	 * 把人民币兑换成多玩币，当前是 1:1 的比率
	 * @param rmb - 人民币
	 */
	public static int exchangeRMBToDuowanCoin(double rmb) {
		// 四舍五入
		long coin = Math.round(rmb);
		return (int) coin;
	}

	// ------------------------------------------------- 套餐相关

	/**
	 * 获得套餐对应的金币
	 * @param config - 套餐配置, 见 http://pay.duowan.com/config.jsp
	 * @param product - 产品，默认是 DUOWAN
	 * @param choice - 套餐
	 * @return
	@SuppressWarnings("unchecked")
	public static int getCoin(Map config, String product, String choice) {
		Map coinMap = null;
		if (product == null || product.length() == 0) {
			// 默认的套餐
			coinMap = (Map) config.get("DUOWAN");
		} else {
			coinMap = (Map) config.get(product);
		}
		String[] s = (String[]) coinMap.get(choice);
		if (s == null)
			return -1;
		return StringUtil.parseInt(s[0]);
	}
	 */

	/**
	 * 获得套餐对应的人民币
	 * @param config - 套餐配置, 见 config.jsp
	 * @param product - 产品，默认是 DUOWAN
	 * @param choice - 套餐
	 * @return
	@SuppressWarnings("unchecked")
	public static double getMoney(Map config, String product, String choice) {
		Map coinMap = null;
		if (product == null || product.length() == 0) {
			// 默认的套餐
			coinMap = (Map) config.get("DUOWAN");
		} else {
			coinMap = (Map) config.get(product);
		}
		String[] s = (String[]) coinMap.get(choice);
		if (s == null)
			return -1;
		return StringUtil.parseDouble(s[1]);
	}
	 */

	/**
	 * 获得神州行套餐对应的人民币
	 * @param config, 见 config.jsp
	 * @param product
	 * @param choice
	 * @return
	@SuppressWarnings("unchecked")
	public static double getShenZhouFuMoney(Map config, String product,
			String choice) {
		Map coinMap = null;
		if (product == null || product.length() == 0) {
			// 默认的套餐
			coinMap = (Map) config.get("DUOWAN");
		} else {
			coinMap = (Map) config.get(product);
		}
		String[] s = (String[]) coinMap.get(choice);
		if (s == null)
			return -1;
		return StringUtil.parseDouble(s[1]);
	}
	 */

	/**
	 * 获得神州行套餐对应的金币
	 * @param config - 套餐配置, 见 config.jsp
	 * @param product - 产品，默认是 DUOWAN
	 * @param choice - 套餐
	 * @return
	@SuppressWarnings("unchecked")
	public static int getShenZhouFuCoin(Map config, String product,
			String choice) {
		Map coinMap = null;
		if (product == null || product.length() == 0) {
			// 默认的套餐
			coinMap = (Map) config.get("DUOWAN");
		} else {
			coinMap = (Map) config.get(product);
		}
		String[] s = (String[]) coinMap.get(choice);
		if (s == null)
			return -1;
		return StringUtil.parseInt(s[0]);
	}
	 */

	// -------------------------------------------------- 其他

	/**
	 * 获得 IPS 的金额格式，保留小数点后 2 位
	 * @param m
	 * @return
	 */
	public static String getIPSMoney(double m) {
		if (m < 0.02d) {
			// IPS 最少要 2 分钱
			return "0.02";
		}

		DecimalFormat f = (DecimalFormat) DecimalFormat.getNumberInstance();
		f.setMaximumFractionDigits(2);
		f.setMinimumFractionDigits(2);
		return f.format(m).replaceAll(",", "");
	}

	/**
	 * 获得的 URL
	 * @param url - 结果URL
	 * @param pay - 支付信息
	 * @param success - 是否成功
	 * @return
	 */
	//	public static String getResultURL(String url, Payment pay, boolean success, String message) {
	//		if (!StringUtil.isFine(url)) {
	//			return null;
	//		}
	//		
	//		if (pay == null) {
	//			return url;
	//		}
	//
	//		if (!StringUtil.isFine(message)) {
	//			if (!success) {
	//				message = "未知错误";
	//			} else {
	//				message = "成功";
	//			}
	//		}
	//		
	//		StringBuilder buf = new StringBuilder(160);
	//		buf.append(url).append("?orderid=").append(pay.getInternalOrderId() == null ? "" : pay.getInternalOrderId());
	//		buf.append("&result=").append(success ? "1" : "0");
	//		buf.append("&money=").append(pay.getMoney());
	//		buf.append("&coin=").append(pay.getCoin());
	//		buf.append("&message=").append(EscapeUtil.escape(message));
	//		return buf.toString();
	//	}
	// -------------------------------------------------------
	/**
	 * 获得支付渠道名称（如 alipay, ips 等等）
	 * @param type - PaymentType 中的定义
	 * @param config - 配置
	 */
	@SuppressWarnings("unchecked")
	//	public static String getPaymentTypeName(int type, Map config, String product) {
	//		String typeName = PaymentType.getPaymentName(type);
	//		Map productConfig = (Map) config.get(product);
	//		String s = null;
	//		if (productConfig != null) {
	//			s = (String) productConfig.get(typeName);
	//		}
	//		return (s == null ? typeName : s);
	//	}
	/**
	 * 往URL增加快钱充值URL的参数
	 * @param url - URL
	 * @param paramName - 参数名
	 * @param value - 值
	 * @return
	public static String append99BillParam(String url, String paramName,
			String value) {
		if (StringUtil.isFine(url)) {
			if (StringUtil.isFine(value)) {
				url = url + "&" + paramName + "=" + value;
			}
		} else {
			if (StringUtil.isFine(value)) {
				url = paramName + "=" + value;
			}
		}
		return url;
	}
	 */

	public static final String BASE64_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +

	"abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";

	public static final int SPLIT_LINES_AT = 76;

	public static String base64Encode(String string) {

		String encoded = "";
		// determine how many padding bytes to add to the output
		int paddingCount = (3 - (string.length() % 3)) % 3;
		// add any necessary padding to the input
		string += "\0\0".substring(0, paddingCount);
		// process 3 bytes at a time, churning out 4 output bytes
		// worry about CRLF insertions later
		for (int i = 0; i < string.length(); i += 3) {

			int j = (string.charAt(i) << 16) + (string.charAt(i + 1) << 8)
					+ string.charAt(i + 2);
			encoded = encoded + BASE64_CODE.charAt((j >> 18) & 0x3f)
					+ BASE64_CODE.charAt((j >> 12) & 0x3f)
					+ BASE64_CODE.charAt((j >> 6) & 0x3f)
					+ BASE64_CODE.charAt(j & 0x3f);

		}
		return splitLines(encoded.substring(0, encoded.length() -

		paddingCount) + "==".substring(0, paddingCount));

	}

	public static String splitLines(String string) {

		String lines = "";
		for (int i = 0; i < string.length(); i += SPLIT_LINES_AT) {

			lines += string.substring(i, Math.min(string.length(), i
					+ SPLIT_LINES_AT));
			lines += "\r\n";

		}
		return lines;

	}

	public static Date parseTime(String time) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		System.out.println(PayUtil.convertStringToDate(null, DATE_FORMAT_PATTEN));
//		double money = 100000;
//		System.out.println(getZeroFill(10));
//		System.out.println(getZeroFill(10, 15));
//		System.out.println(getIPSMoney(0.01d));
//		System.out.println(getIPSMoney(1.0d));
//		System.out.println(getIPSMoney(1.001d));
//		System.out.println(getIPSMoney(1.01d));
//		System.out.println("money " + money + ": " + getIPSMoney(money));
//
//		System.out.println(getPaymentLogFile());
		//Payment pay = PaymentFactory.getPayment(PaymentType.MOCK, null);
		//		System.out.println(getResultURL("result.jsp", null, true, "号码"));
		Map<String, Boolean> map = new HashMap<String, Boolean>(2400000);
		int error = 0;
		for (int i=0; i < 2000000; i++) {
			String s = getRandomString(10);
			if (map.containsKey(s)) {
				error++;
			}
			else {
				map.put(s, Boolean.TRUE);
			}
		}

		System.out.println("error = " + error);
		System.out.println(getRandomString(10));
	}

	/**
	 * 得到几天前的时间
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * convert string to date ,  yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strIn
	 * @param dateFormat
	 * @return
	 */
	public static Date convertStringToDate(String strIn, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date dateReturn = null;
		try {
			dateReturn = format.parse(strIn);
		} catch (Exception ex) {
		}
		return dateReturn;
	}

	public static double cutDouble(double num, int len) {
		if (len < 0)
			return num;
		int k = 1;
		for (int i = 0; i < len; i++) {
			k = k * 10;
		}
		return ((double) Math.round(num * k)) / k;
	}
	
	/**
	 * 日期转换格式
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String DATE_FORMAT_PATTEN  =  "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期类型转换为string类型
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String timeToStr(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);

		return format.format(date);
	}
	
	private static Random random = new Random();
	/**
	 * 生成长度为length的随机字符串
	 * @param length
	 * @return
	 */
	public static String generateRondomString(int length) {
		if(length<1){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			switch (random.nextInt(3)) {
			case 0:
				sb.append((char)('0' + random.nextInt(9)));
				break;
			case 1:
				sb.append((char)('A' + random.nextInt(26)));
				break;
			default:
				sb.append((char)('a' + random.nextInt(26)));
				break;
			}
		}
		return sb.toString();
	}
	
}
