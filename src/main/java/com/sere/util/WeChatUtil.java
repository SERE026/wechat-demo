package com.sere.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.sere.config.Global;

/**
 * ClassName: WeChatTask
 * 
 * @Description: 微信两小时定时任务体
 */
public class WeChatUtil {
	
	private static Logger logger = Logger.getLogger(WeChatUtil.class);
	
	public static Map<String,Object> cache = new ConcurrentHashMap<String,Object>();
	
	/**
	 * @Description: 任务执行体 获取公众号的access_token和ticket
	 * @param @throws
	 *            Exception
	 */
	public void getToken_getTicket() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", Global.getConfig("appID"));
		params.put("secret", Global.getConfig("appsecret"));
		String jstoken = HttpUtils.sendGet(Global.getConfig("token_url"), params);
		
		logger.info("获取token返回结果：>>>>"+jstoken);
		// 获取到 token 并赋值保存
		
		String access_token = JSONObject.parseObject(jstoken).getString("access_token");
		cache.put("access_token", access_token);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				+ "token 为==============================" + access_token);
		
		 //获取 jsticket 的执行体
        params.clear();
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        String jsticket = HttpUtils.sendGet(Global.getConfig("ticket_url"), params);
        String jsapi_ticket = JSONObject.parseObject(jsticket).getString("ticket"); 
        logger.info("获取ticket返回结果：>>>>"+jsticket);
        cache.put("jsapi_ticket", jsapi_ticket); // 获取到 js-SDK 的 ticket 并赋值保存

        System.out.println("jsapi_ticket================================================" + jsapi_ticket);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token 为=============================="+access_token);
	}
	
	
	public static String getWechatByCode(String code) throws Exception{
		//https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "authorization_code");
		params.put("appid", Global.getConfig("appID"));
		params.put("secret", Global.getConfig("appsecret"));
		params.put("code", code);
		String result = HttpUtils.sendPost(Global.getConfig("access_token_url"), params);
		
		logger.info("获取token返回结果：>>>>"+result);
		// 获取到 token 并赋值保存
		return result;
	}
}
