package com.sps.ecommerce.admin.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import com.sps.ecommerce.admin.entity.SystemConfig;
import com.sps.ecommerce.admin.listener.SpringContextUtil;
import com.sps.ecommerce.admin.service.SystemConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/***
 * 系统配置缓存
 * @author wangfucai
 */
public class SystemConfigCache {

	private static final Logger logger=LoggerFactory.getLogger(SystemConfigCache.class);
	
	public static Map<String,String> configCache=new ConcurrentHashMap<String,String>();
	
	/***
	 * 缓存的系统初始化
	 */
	public static void init()
	{
		logger.info("[SystemConfigCache] init......");
		
		SystemConfigService systeConfigService=(SystemConfigService)SpringContextUtil.getBean("systemConfigService");
		
		List<SystemConfig> listSystemConfig=systeConfigService.listSystemConfig();

		if(CollectionUtils.isNotEmpty(listSystemConfig))
		{
			for(SystemConfig systemConfig:listSystemConfig)
			{
				String code=systemConfig.getParamCode();
				
				String value=systemConfig.getParamValue();
				
				configCache.put(code, value);
			}
		}
	}
	
	/***
	 * 根据Code获得值
	 * @param code
	 * @return
	 */
	public static String getValueByCode(String code)
	{
		logger.info("[SystemConfigCache][getValueByCode]code......"+ code);
		
		if(StringUtils.isBlank(code))
		{
			logger.error("[SystemConfigCache][getValueByCode]code is empty");
		}
		return configCache.get(code);
	}
	/**
	 * 重新加载
	 */
	public static void reLoad()
	{
		logger.info("[SystemConfigCache] 重新加载缓存");
		configCache.clear();
		init();
	}
}