package com.sere.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sere.config.JSSDK_Config;
import com.sere.dispather.EventDispatcher;
import com.sere.dispather.MsgDispatcher;
import com.sere.util.MessageUtil;
import com.sere.util.SignUtil;
import com.sere.util.WeChatUtil;

@Controller
@RequestMapping("/wechat")
public class WechatController {
	private static Logger logger = Logger.getLogger(WechatController.class);

	/**
	 * 
	 * @Description: 用于接收 get 参数，返回验证参数
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 * @param @param
	 *            signature
	 * @param @param
	 *            timestamp
	 * @param @param
	 *            nonce
	 * @param @param
	 *            echostr
	 */
	@RequestMapping(value = "security", method = RequestMethod.GET)
	public void security(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {
		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				PrintWriter out = response.getWriter();
				out.print(echostr);
				out.close();
			} else {
				logger.info("这里存在非法请求！");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	/**
	 * @Description: 接收微信端消息处理并做分发
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 */
	@RequestMapping(value = "security", method = RequestMethod.POST)
	public void security(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			String msgtype = map.get("MsgType");
			String result = "";
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
				result = EventDispatcher.processEvent(map); // 进入事件处理
			} else {
				result = MsgDispatcher.processMessage(map); // 进入消息处理
			}
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "config", method = RequestMethod.POST)
	public Map<String,String> config(String url,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(url);
        Map<String, String> configMap = null;
		try {
			configMap = JSSDK_Config.jsSDK_Sign(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return configMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "getUser", method = RequestMethod.POST)
	public String getUser(String code,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(code);
        String result = "";
		try {
			 result = WeChatUtil.getWechatByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
	}
}