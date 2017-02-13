package com.sere.dispather;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.sere.config.Global;

/** 
 * ����ͼ�������api�ӿڣ���ȡ���ܻظ����� 
 * 
 */  
public class TulingApiProcess {  
    /** 
     * ����ͼ�������api�ӿڣ���ȡ���ܻظ����ݣ�������ȡ�Լ������� 
     * @param content 
     * @return 
     */  
    public String getTulingResult(String content){  
        /** �˴�Ϊͼ��api�ӿڣ�����key��Ҫ�Լ�ȥע�����룬����11111111���� */  
        String apiUrl = Global.getConfig("tuling_url")+"?key="+Global.getConfig("tuling_key");  
        String param = "";  
        try {  
            param = apiUrl+"&info="+URLEncoder.encode(content,"utf-8");  
        } catch (UnsupportedEncodingException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } //������תΪurl����  
          
        /** ����httpget���� */  
        HttpPost request = new HttpPost(param);  
        String result = "";  
        try {  
            HttpResponse response = HttpClients.createDefault().execute(request);  
            if(response.getStatusLine().getStatusCode()==200){  
                result = EntityUtils.toString(response.getEntity());  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        /** ����ʧ�ܴ��� */  
        if(null==result){  
            return "�Բ�����˵�Ļ�����̫�����ˡ���";  
        }  
          
        try {  
            JSONObject json = JSONObject.parseObject(result);  
            //��code=100000Ϊ�����ο�ͼ�������api�ĵ�  
            if(100000==Integer.valueOf(json.get("code").toString())){  
                result = json.getString("text");  
            }  
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
}  
