/**
 * App 拦截器
 * @author sere
 */

package com.sere.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 系统拦截器
 * 
 * @version 2015-07-14
 */
public class GlobalInterceptor implements HandlerInterceptor {

	private static Logger LOG = LoggerFactory
			.getLogger(GlobalInterceptor.class);



	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		response.setHeader("progma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Content-Type", "text/plain charset=UTF-8");
		
		
		if(handleOption(request,response)){
			return true;
		}

//		Map<String,String> properties = PackageHTTPParamUtil.req2Map(request); // 参数Map
//		LOG.info("请求参数：==>>{}",BeanUtils.map2String(properties));

		//充值无需检查协议版本号、交易号、app版本、加密方式、编码
		String uri = request.getRequestURI();
		String uriPrefix = request.getContextPath();
		
//		String token  = properties.get("token");  // 从header中取
		
//		Object obj = SessionManager.getAttribute(token);
		
		if(uri.equals("/") || StringUtils.startsWith(uri,uriPrefix+"/js/")
				|| StringUtils.startsWith(uri,uriPrefix+"/images/")
				|| StringUtils.startsWith(uri,uriPrefix+"/css/")
				|| StringUtils.startsWith(uri,uriPrefix+"/servlet/")
				|| StringUtils.startsWith(uri,uriPrefix+"/f/")
				|| StringUtils.startsWith(uri,uriPrefix+"/login")
				|| StringUtils.startsWith(uri,uriPrefix+"/index")
				|| StringUtils.startsWith(uri,uriPrefix+"/register"))
		{
			
		}else{
			
			//TODO 验签
			return true;
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
	
	private boolean handleOption(HttpServletRequest request,
			HttpServletResponse response) {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "version,token,codetype,signtype,codeType,signType,IMSI,IMEI,browsor,imei,imsi,DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type");
		response.addHeader("Access-Control-Max-Age", "3456000");
		if (request.getMethod().equals("OPTIONS")) {
			response.addHeader("Content-Length", "0");
			response.setStatus(204);
            return true;
		}
		return false;
	}

}
