package com.sere.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sere.util.WeChatUtil;

@Controller
public class IndexController {
	
	private static Logger LOG = Logger.getLogger(IndexController.class);
	
	Map<String,String> cache = new HashMap<String,String>(); 

	@RequestMapping("/index")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,String> map = req2Map(request);
		
		cache.putAll(map);
		
		LOG.info("请求参数：==>>"+map2String(cache));
		
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        /** 读取接收到的xml消息 */  
        StringBuffer sb = new StringBuffer();  
        InputStream is = request.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  
        BufferedReader br = new BufferedReader(isr);  
        String s = "";  
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
        String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据  
        
        LOG.info("XML消息：>>"+xml);
		
		String echostr = request.getParameter("echostr");
		PrintWriter pw = response.getWriter();
		pw.write(echostr);
	}
	
	@RequestMapping("/cache")
	@ResponseBody
	public Map<String,Object> getCache(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String,String> map = req2Map(request);
		LOG.info("请求参数：==>>"+map2String(map));
		
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        return WeChatUtil.cache;
	}
	
	public static Map<String,String> req2Map(HttpServletRequest request){
        // 参数Map
        Map<String,String[]> properties = request.getParameterMap();
        // 返回值Map
        Map<String,String> returnMap = new HashMap<String,String>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry<?, ?>) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        
        return returnMap;
	}
	
	public static String map2String(Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = map.get(key);
			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}
}
