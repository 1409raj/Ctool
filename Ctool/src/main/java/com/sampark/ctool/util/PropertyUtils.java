package com.sampark.ctool.util;
//package com.gap.school.util;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.lilysys.apms.dto.AppConfig;
//
//public class PropertyUtils {
//
//	private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);
//
//	private static PropertyUtils configuration;
//	private static Map<String, String> properties;
//
//	private static Object lockObject = new Object();
//
//	public static PropertyUtils getInstance() {
//		if (configuration == null) {
//			synchronized (lockObject) {
//				if (configuration == null) {
//					try {
//						configuration = new PropertyUtils();
//						configuration.configure();
//					} catch (Exception lExp) {
//						lExp.printStackTrace();
//						logger.error("Exception in getting PropertyUtils instance " + lExp);
//						configuration = null;
//					}
//				}
//			}
//		}
//		return configuration;
//	}
//	
//	private void configure() {
//		properties = new HashMap<String, String>();
////		try {
////			List<AppConfig> list = DatabaseUtils.getAppConfigs();
////			for (AppConfig appConfig : list) {
////				logger.debug("AppConfig [" + appConfig.getParamName() + ", " + appConfig.getParamValue() + "]");
////				properties.put(appConfig.getParamName(), appConfig.getParamValue());
////			}
////			logger.info("Loaded " + properties.size() + " properties from DB");
////		} catch (Exception e) {
////			logger.error("Exception loading configurations... " + e);
////		}
//	}
//	
//	private PropertyUtils(){		
//	}
//
//	public String getPropertyAsString(String key) {
//		return properties.get(key);
//	}
//
//	public int getPropertyAsInt(String key) {
//		String prop = getPropertyAsString(key);
//		if (prop != null) {
//			try {
//				return Integer.parseInt(prop);
//			} catch (Exception e) {
//				logger.error("Error while converting [" + prop + "] to int for property [" + key + "] ... " + e);
//			}
//		}
//		return 0;
//	}
//
//	public List<String> getPropertyAsList(String key) {
//		String value = getPropertyAsString(key);
//		logger.debug("PropertyUtils.getPropertyAsList() list " + key + "> " + value);
//		if (value != null) {
//			String[] array = value.split(",");
//			return Arrays.asList(array);
//		}
//		return new ArrayList<String>();
//	}
//
//}