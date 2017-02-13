package com.sere.config;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.UUID;

import com.sere.util.WeChatUtil;


/**
 * ClassName: JSSDK_Config
 * @Description: �û�΢��ǰ��ҳ��� jssdk ����ʹ��
 */
public class JSSDK_Config {

    /**
     * @Description: ǰ�� jssdk ҳ��������Ҫ�õ������ò���
     * @param @return hashmap {appid,timestamp,nonceStr,signature}
     * @param @throws Exception   
     */
    public static HashMap<String, String> jsSDK_Sign(String url) throws Exception {
        String nonce_str = create_nonce_str();
        if(WeChatUtil.cache.get("timestamp") == null){
        	WeChatUtil.cache.put("timestamp",new Date().getTime());
        }
        	
        String timestamp = WeChatUtil.cache.get("timestamp").toString();
        String jsapi_ticket= WeChatUtil.cache.get("jsapi_ticket").toString();
        // ע���������������ȫ��Сд���ұ�������
        String  string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
                + "&timestamp=" + timestamp  + "&url=" + url;
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(string1.getBytes("UTF-8"));
        String signature = byteToHex(crypt.digest());
        HashMap<String, String> jssdk=new HashMap<String, String>();
        jssdk.put("appId", Global.getConfig("appID"));
        jssdk.put("timestamp", timestamp);
        jssdk.put("nonceStr", nonce_str);
        jssdk.put("signature", signature);
        return jssdk;

    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

}