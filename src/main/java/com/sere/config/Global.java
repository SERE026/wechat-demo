package com.sere.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Global {

	private static final Logger LOG = LoggerFactory.getLogger(Global.class);

	private static Global global = new Global();

	private static String[] resourcePath = new String[] { "interface_url.properties", "wechat.properties" };

	/**
	 * 属性文件加载对象 PropertiesLoader
	 */
	private static PropertiesLoader propertiesLoader;

	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		if (propertiesLoader == null) {
			propertiesLoader = new PropertiesLoader(resourcePath);
		}
		return propertiesLoader.getProperty(key);
	}

	/**
	 * 失效配置
	 */
	public static void invalidate() {
		propertiesLoader = null;
		LOG.info("---------执行清空propertiesLoader操作---------");
	}

	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	public static String getFrontPath() {
		return getConfig("frontPath");
	}

	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		if ((!"true".equals(dm)) && (!"1".equals(dm)))
			return Boolean.valueOf(false);
		return Boolean.valueOf(true);
	}

	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		if ((!"true".equals(dm)) && (!"1".equals(dm)))
			return Boolean.valueOf(false);
		return Boolean.valueOf(true);
	}

	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception localException) {
		}
		return null;
	}

}
