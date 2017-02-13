package com.sere.dispather;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sere.message.resp.Image;
import com.sere.message.resp.ImageMessage;
import com.sere.util.HttpPostUploadUtil;
import com.sere.util.MessageUtil;

/**
 * ClassName: EventDispatcher
 * @Description: �¼���Ϣҵ��ַ���
 */
public class EventDispatcher {
    public static String processEvent(Map<String, String> map) {
    	String openid = map.get("FromUserName"); // �û� openid
    	String mpid = map.get("ToUserName"); // ���ں�ԭʼ ID
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //��ע�¼�
            System.out.println("==============���ǹ�ע�¼���");
            ImageMessage imgmsg = new ImageMessage();
            imgmsg.setToUserName(openid);
            imgmsg.setFromUserName(mpid);
            imgmsg.setCreateTime(new Date().getTime());
            imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
            if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // ��ע�¼�
                System.out.println("==============���ǹ�ע�¼���");
                Image img = new Image();
                HttpPostUploadUtil util=new HttpPostUploadUtil();
                String filepath="H:\\1.jpg";  
                Map<String, String> textMap = new HashMap<String, String>();  
                textMap.put("name", "testname");  
                Map<String, String> fileMap = new HashMap<String, String>();  
                fileMap.put("userfile", filepath); 
                String mediaidrs = util.formUpload(textMap, fileMap);
                System.out.println(mediaidrs);
                String mediaid=JSONObject.parseObject(mediaidrs).getString("media_id");
                img.setMediaId(mediaid);
                imgmsg.setImage(img);
                return MessageUtil.imageMessageToXml(imgmsg);
            }
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //ȡ����ע�¼�
            System.out.println("==============����ȡ����ע�¼���");
        }

//        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //ɨ���ά���¼�
//            System.out.println("==============����ɨ���ά���¼���");
//        }

//        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //λ���ϱ��¼�
//            System.out.println("==============����λ���ϱ��¼���");
//        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //�Զ���˵�����¼�
            System.out.println("==============�����Զ���˵�����¼���");
        }

//        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //�Զ���˵� View �¼�
//            System.out.println("==============�����Զ���˵� View �¼���");
//        }

        return null;
    }
}
