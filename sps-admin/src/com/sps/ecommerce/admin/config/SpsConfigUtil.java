package com.sps.ecommerce.admin.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付系统配置文件读取
 * @author wangfucai
 */
public class SpsConfigUtil {

	// 对接系统的KEY
	public static String gameaccessNotifyUrl = null;
	public static String gameaccessActorUrl = null;
	public static String baiduWapPayUrl = null;
	
	// 应用名称(用户中心分配)
	public static String usercenterLoginApiUrl = null;
	public static String usercenterMessageCountApiUrl = null;
	public static String usercenterSSOLoginUrl = null;
	public static String usercenterSSOLoginOutUrl = null;
	public static String usercenterSSOCheckTokenUrl = null;
	
	// 获取联运平台红包接口地址
	public static String yilewanLoadReadEnvelopesApi=null;
	public static String yilewanNoticeUseRedEnvelopes=null;
	
	public static String usercenterAppId = null;
	
	// 用户中心的KEY
	public static String usercenterPrimaryKey = null;
	public static String usercenterIdApiUrl = null;
	public static String usercenterPassportApiUrl = null;
	
	// 易乐玩的KEY
	public static String yilewanAppId = null;
	public static String yilewanPrimaryKey = null;

	// 58Game的KEY
	public static String gameAppId = null;
	public static String gamePrimaryKey = null;
	
	// 是否为测试环境
	public static String systemTest = null;
	public static String cookieDomain=null;
	
	public static String yilewanNotifyUrl=null;

	// 随乐游
	public static String suileyouAppId = null;
	public static String suileyouPrimaryKey = null;

	private static final Map<String, String> map = new HashMap<String, String>();

	// 初始化
	static {
		try {
			ConfigurationManager config = ConfigurationManager.instance();

			usercenterLoginApiUrl = config.getValue("usercenter_login_api");
			usercenterMessageCountApiUrl = config.getValue("usercenter_message_count_api");
			usercenterSSOLoginUrl = config.getValue("usercenter_sso_login_api");
			usercenterSSOLoginOutUrl = config.getValue("usercenter_sso_login_out_api");
			usercenterSSOCheckTokenUrl = config.getValue("usercenter_sso_check_token_api");

			usercenterAppId = config.getValue("usercenter_app_id");
			usercenterPrimaryKey = config.getValue("usercenter_primary_key");
			usercenterIdApiUrl = config.getValue("usercenter_id_api");
			usercenterPassportApiUrl = config.getValue("usercenter_passport_api");

			yilewanLoadReadEnvelopesApi = config.getValue("yilewan_load_read_envelopes_api");
			yilewanNoticeUseRedEnvelopes = config.getValue("yilewan_notice_use_read_envelopes_api");
			
			gameaccessNotifyUrl = config.getValue("gameaccess_notify_url");
			gameaccessActorUrl = config.getValue("gameaccess_actor_url");
			systemTest = config.getValue("SYSTEM_TEST");
			baiduWapPayUrl = config.getValue("baidu_wap_pay_url");

			suileyouAppId = config.getValue("suileyou_app_id");
			suileyouPrimaryKey = config.getValue("suileyou_primary_key");
			
			yilewanAppId = config.getValue("yilewan_app_id");
			yilewanPrimaryKey = config.getValue("yilewan_primary_key");
			
			gameAppId = config.getValue("58game_app_id");
			gamePrimaryKey = config.getValue("58game_primary_key");
			
			cookieDomain = config.getValue("billing_cookie_domain");
			
			yilewanNotifyUrl = config.getValue("billing_yilewan_notify_url"); 

			map.put(usercenterAppId, usercenterPrimaryKey);
			map.put(suileyouAppId, suileyouPrimaryKey);
			map.put(yilewanAppId, yilewanPrimaryKey);
			map.put(gameAppId, gamePrimaryKey);

		} catch (Exception e) {
			throw new RuntimeException("Config error, msg=" + e.getMessage(), e);
		}
	}

	/**
	 * 根据appId获得私有的key
	 * 
	 * @return
	 */
	public static String getPrimaryKey(String appId) {
		return map.get(appId) == null ? "" : map.get(appId);
	}
}
