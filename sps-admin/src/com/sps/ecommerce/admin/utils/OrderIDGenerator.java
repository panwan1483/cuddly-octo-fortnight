package com.sps.ecommerce.admin.utils;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sps.ecommerce.admin.config.SpsConfigUtil;


/**
 * 订单号生成
 * @author wangfucai
 */
public class OrderIDGenerator {

	public static final String SEPARATOR = "_";

	/**
	 * 最终的订单号
	 */
	private String orderId = null;

	/**
	 * 产品名
	 */
	private String product = null;

	/**
	 * 生成订单号的时间(包括毫秒部分)
	 */
	private String time = null;

	/**
	 * 填充 0
	 */
	private static final String[] ZERO_FILL = new String[] { "", "0", "00", "000", "0000", "00000", "000000", "0000000", "00000000", "000000000",
			"0000000000", };

	public OrderIDGenerator() {

	}

	/**
	 * 订单号生成
	 * 
	 * @param product
	 *            - 产品名，不能为空
	 */
	public OrderIDGenerator(String product) {
		if (StringUtils.isNotEmpty(product) ) {
			if (product.length() > 11) {
				throw new RuntimeException("产品名称和服务名称加起来的长度不能超过 11。");
			}
		}

		this.product = product;
	}

	/**
	 * 获得订单号
	 * 
	 * @return
	 */
	public String getOrderId() {
		if (orderId == null) {
			time = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss").replaceAll("(\\s|:|-)", "");
			if ("true".equalsIgnoreCase(SpsConfigUtil.systemTest)) {
				orderId = "test_" + time + PayUtil.getRandomString(10);
			} else {
				orderId = time + PayUtil.getRandomString(10);
			}
		}
		return orderId;
	}
	
	/**
	 * 生成百度钱包的订单ID
	 * 
	 * @return
	 */
	public String getBaifubaoOrderId() {
		if (orderId == null) {
			time = DateUtils.dateToString(new Date(), "yyyyMMddHHmmss").replaceAll("(\\s|:|-)", "");
			if ("true".equalsIgnoreCase(SpsConfigUtil.systemTest)) {
				orderId = "test" + time + PayUtil.getRandomString(2);
			} else {
				orderId = time + PayUtil.getRandomString(6);
			}
		}
		return orderId;
	}
	
	/**
	 * 生成支付宝的订单ID
	 * 
	 * @return
	 */
	public String getAliPayId() {

		return getOrderId();
	}

	/**
	 * 生成神州付的订单ID
	 * 
	 * @param merId
	 *            - 商户ID
	 * @return
	 */
	public String getShenZhouFuId(String merId) {
		String s = getOrderId();

		String date = this.time.substring(0, 8);
		return date + "-" + merId + "-" + s.replaceAll(date, "");
	}

	/**
	 * 生成 IPS 的订单ID
	 * 
	 * @return
	 */
	public String getIpsId() {
		return getOrderId();
	}

	public String getVnetontId() {

		return "";
	}

	/**
	 * 获得OrderId, 盈华讯方只允许 18 位的自定义数据
	 * 
	 * @param orderId
	 * @return
	 */
	public static String getOrderIdForVNetone(String orderId) {
		if (orderId.length() < 1) {
			throw new IllegalArgumentException("orderId");
		}
		String time = Num60Util.encodeCurrentTime();
		return time + orderId.substring(14);
	}

	/**
	 * 把提交到盈华讯方的(duowan内部的) orderId 转换为正常的 orderId
	 * 
	 * @param vNetoneOrderId
	 * @return
	 */
	public static String getOrderIdFromVNetone(String vNetoneOrderId) {
		if (vNetoneOrderId == null || vNetoneOrderId.length() != Num60Util.TIME_LENGTH + 10) {
			throw new IllegalArgumentException("vNetoneOrderId");
		}
		String time = vNetoneOrderId.substring(0, Num60Util.TIME_LENGTH);
		time = Num60Util.decodeTime(time);
		return time + vNetoneOrderId.substring(Num60Util.TIME_LENGTH);
	}

	public String getCouponId(String product, String couponType) {
		if(product.length()>5){
			product=product.substring(0,5);
		}
		return DateUtils.getCurrentDateTimeStr("yyyyMMddHHmmss") + couponType + product + PayUtil.generateRondomString(5);
	}
	
	
	public String getCouponId(String couponType) {
		return DateUtils.getCurrentDateTimeStr("yyyyMMddHHmmss") + couponType  + PayUtil.generateRondomString(10);
	}

	/**
	 * 把自然数转换成以 0 填充开头的字符串
	 * 
	 * @param n
	 * @return
	 */
	public static String getZeroFill(String n) {
		return getZeroFill(n, 10);
	}

	/**
	 * 把自然数转换成以 0 填充开头的字符串
	 * 
	 * @param n
	 *            - 数字
	 * @param numLen
	 *            - 字符串总长度
	 * @return
	 */
	public static String getZeroFill(String n, int numLen) {

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String product = "WAR";
		String server = "S1";
		// String merId = "102";
		for(int i=0;i<100;i++)
		{
		OrderIDGenerator g = new OrderIDGenerator(product);
		try 
		{
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println(g.getAliPayId());
		 System.out.println(g.getOrderId());
		}
		//
		//
		// String id = g.getAliPayId();
		// System.out.println("orderid="+id);
		// System.out.println(id.length());
		// String vnetone = g.getOrderIdForVNetone(id);
		// System.out.println("vnetone="+vnetone);
		// System.out.println("vnetone="+g.getOrderIdForVNetone("200902041653535558590190"));
		// String vnetone2=g.getOrderIdFromVNetone(vnetone);
		// System.out.println("vnetone2="+vnetone2);
		// System.out.println(vnetone.equals(vnetone));

		// System.out.println(g.getShenZhouFuId(merId));
		// System.out.println(g.getIpsId());
		//
		// System.out.println();
		// OrderIDGenerator g2 = new OrderIDGenerator(null, null);
		// System.out.println(g2.getAliPayId());
		// System.out.println(g2.getShenZhouFuId(merId));
		// System.out.println(g2.getIpsId());

		// String time = Num60Util.decodeTime("924Grs");
		// System.out.println(Num60Util.encodeCurrentTime());
		// System.out.println(time);
		// spreadQueryAction.action?orderid=200903091510023422136822&passport=zfrex&starttime=2009-01-01&endtime=2009-09-09&rmb=20&mac=A6CAF4B324CDEEDEF28DB38E592FA2B4

	}

}
