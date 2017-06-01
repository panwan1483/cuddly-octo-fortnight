package com.sps.ecommerce.admin.common.sms;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import net.sf.json.JSONObject;
/**
 * 短信工具
 * @author wangfucai
 */
public class SmsUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(SmsUtil.class);
	
	private static final String URL="https://eco.taobao.com/router/rest";
	
//	private static final String APPKEY="23347182";
//	private static final String SECRET="236d4ad158a67221886a94dda17e8840";
	
	private static final String APPKEY="";
	
	private static final String SECRET="";

	private static final String DEFAULT_SIGN_NAME="登录验证";
	
	private static final String DEFAULT_SIGN_TEMPLATECODE="SMS_7725121";
	
	private static final String DEFAULT_WARNING_NAME="变更验证";
	
	private static final String DEFAULT_WARNING_TEMPLATECODE="SMS_8740059";
	
	private static final String DEFAULT_RISK_NAME="智慧地铁";
	
	private static final String DEFAULT_RISK_TEMPLATECODE="SMS_12195670";
	
	/**
	 * 默认的 产品名称
	 */
	private static final String DEFAULT_PRODUCT="武汉地铁工程安全风险预警系统";

	/**
	 *  发送验证码短信
	 * @param phone
	 * @param code
	 * @return
	 */
	public static SmsResult sendCodeSms(String phone,String code)
	{
		return sendCodeSms(phone,code,DEFAULT_SIGN_NAME);
	}
	
	/**
	 * 发送更换手机短信
	 * @param phone
	 * @param code
	 * @return
	 */
	public static SmsResult sendChangePhoneSms(String phone,String code)
	{
		return sendCodeSms(phone,code,DEFAULT_WARNING_NAME);
	}
	
	/**
	 * 发送验证码短信
	 * @param phone
	 * @param code
	 * @param sign 数字签名即一个短信的前缀，告诉别人，这个是什么方面的短信
	 * @return
	 */
	public static SmsResult sendCodeSms(String phone,String code,String sign)
	{
		sign=StringUtils.defaultIfBlank(sign, DEFAULT_SIGN_NAME);
		
		return sendCodeSms(phone,code,"",sign,DEFAULT_SIGN_TEMPLATECODE);
	}
	
	//时间2016-05-04 13:20在地铁2号线街道口站建筑物发生较大的沉降，请立即前往了解并解决.
	/**
	 * 发送预警短信
	 * @param phone
	 * @param code
	 * @return
	 */
	public static SmsResult sendWarningSms(String phone,String message)
	{
		return sendCodeSms(phone,message,"",DEFAULT_WARNING_NAME,DEFAULT_WARNING_TEMPLATECODE);
	}
	
	/**
	 * 发送风险短信
	 * @param phone
	 * @param code
	 * @return
	 */
	public static SmsResult sendRiskSms(String phone,String message)
	{
		return sendCodeSms(phone,message,"",DEFAULT_RISK_NAME,DEFAULT_RISK_TEMPLATECODE);
	}
	
	/***
	 *  发送验证码短信
	 * @param phone
	 * @param message
	 * @return
	 */
	private static SmsResult sendCodeSms(String phone,String message,String product,String signName,String templateCode)
	{
		String sendReturn="";
		
		if(StringUtils.isBlank(phone)||StringUtils.isBlank(message)||StringUtils.isBlank(signName)||StringUtils.isBlank(templateCode))
		{
			return new SmsResult("参数有误，手机号码或者短信或者产品或者签名为空");
		}
		/**
		 * 扩展字段
		 */
		String extend=phone+"_"+message;
		
		product=StringUtils.defaultIfBlank(product,DEFAULT_PRODUCT);
		
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(extend);
		req.setSmsType("normal");
		
		SmsMessage smsMessage=new SmsMessage();
		smsMessage.setCode(message);
		smsMessage.setMessage(message);
		smsMessage.setProduct(product);
		
		String jsonParam=SmsFactory.getInstance().createSmsJson(smsMessage);
		
		req.setSmsParamString(jsonParam);
		req.setSmsFreeSignName(signName);
		req.setRecNum(phone);
		req.setSmsTemplateCode(templateCode);
		try 
		{
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			
			sendReturn=rsp.getBody();
			
			JSONObject jsonObject=JSONObject.fromObject(sendReturn);
			
			JSONObject retJson=jsonObject.getJSONObject("alibaba_aliqin_fc_sms_num_send_response");
			
			JSONObject resultJson=retJson.getJSONObject("result");
			
			boolean sendResult=resultJson.getBoolean("success");
			
			String msg=sendResult==true?"发送成功":"发送失败";
			
			return new SmsResult(sendResult,msg);
			
		} catch (ApiException e) 
		{
			logger.error("[SmsUtil][sendCodeSms]发送失败",e);
			return new SmsResult("发送短信出现异常，请马上联系管理员处理");
		}
	}
}