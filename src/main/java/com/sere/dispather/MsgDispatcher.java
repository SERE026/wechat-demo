package com.sere.dispather;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sere.message.resp.Article;
import com.sere.message.resp.NewsMessage;
import com.sere.message.resp.TextMessage;
import com.sere.util.MessageUtil;

/**
 * ClassName: MsgDispatcher
 * 
 * @Description: ��Ϣҵ����ַ���
 */
public class MsgDispatcher {
	public static String processMessage(Map<String, String> map) {
		String openid=map.get("FromUserName"); //�û� openid
		String mpid=map.get("ToUserName");   //���ں�ԭʼ ID
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
			System.out.println("==============�����ı���Ϣ��");

			//��ͨ�ı���Ϣ

			TextMessage txtmsg=new TextMessage();
			txtmsg.setToUserName(openid);
			txtmsg.setFromUserName(mpid);
			txtmsg.setCreateTime(new Date().getTime());
			txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
			    //txtmsg.setContent("��ã������Ǹ����˺ţ�");
				String content = new TulingApiProcess().getTulingResult(map.get("Content"));
				txtmsg.setContent(content);
			    return MessageUtil.textMessageToXml(txtmsg);
			}
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // ͼƬ��Ϣ
			System.out.println("==============����ͼƬ��Ϣ��");
			NewsMessage newmsg=new NewsMessage();
			newmsg.setToUserName(openid);
			newmsg.setFromUserName(mpid);
			newmsg.setCreateTime(new Date().getTime());
			newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

			if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // ͼƬ��Ϣ
			    System.out.println("==============����ͼƬ��Ϣ��");
			    Article article=new Article();
			    article.setDescription("����ͼ����Ϣ 1"); //ͼ����Ϣ������
			    article.setPicUrl(""); //ͼ����ϢͼƬ��ַ
			    article.setTitle("ͼ����Ϣ 1");  //ͼ����Ϣ����
			    article.setUrl("");  //ͼ�� url ����
			    List<Article> list=new ArrayList<Article>();
			    list.add(article);     //���﷢�͵��ǵ�ͼ�ģ������Ҫ���Ͷ�ͼ���������� list �м����� Article ���ɣ�
			    newmsg.setArticleCount(list.size());
			    newmsg.setArticles(list);
			    return MessageUtil.newsMessageToXml(newmsg);
			}      
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // ������Ϣ
			System.out.println("==============����������Ϣ��");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // λ����Ϣ
			System.out.println("==============����λ����Ϣ��");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // ��Ƶ��Ϣ
			System.out.println("==============������Ƶ��Ϣ��");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // ������Ϣ
			System.out.println("==============����������Ϣ��");
		}

		return null;
	}
}