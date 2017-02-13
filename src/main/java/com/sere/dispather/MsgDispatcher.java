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
 * @Description: 消息业务处理分发器
 */
public class MsgDispatcher {
	public static String processMessage(Map<String, String> map) {
		String openid=map.get("FromUserName"); //用户 openid
		String mpid=map.get("ToUserName");   //公众号原始 ID
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
			System.out.println("==============这是文本消息！");

			//普通文本消息

			TextMessage txtmsg=new TextMessage();
			txtmsg.setToUserName(openid);
			txtmsg.setFromUserName(mpid);
			txtmsg.setCreateTime(new Date().getTime());
			txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
			    //txtmsg.setContent("你好，这里是个人账号！");
				String content = new TulingApiProcess().getTulingResult(map.get("Content"));
				txtmsg.setContent(content);
			    return MessageUtil.textMessageToXml(txtmsg);
			}
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
			System.out.println("==============这是图片消息！");
			NewsMessage newmsg=new NewsMessage();
			newmsg.setToUserName(openid);
			newmsg.setFromUserName(mpid);
			newmsg.setCreateTime(new Date().getTime());
			newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

			if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
			    System.out.println("==============这是图片消息！");
			    Article article=new Article();
			    article.setDescription("这是图文消息 1"); //图文消息的描述
			    article.setPicUrl(""); //图文消息图片地址
			    article.setTitle("图文消息 1");  //图文消息标题
			    article.setUrl("");  //图文 url 链接
			    List<Article> list=new ArrayList<Article>();
			    list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
			    newmsg.setArticleCount(list.size());
			    newmsg.setArticles(list);
			    return MessageUtil.newsMessageToXml(newmsg);
			}      
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
			System.out.println("==============这是链接消息！");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
			System.out.println("==============这是位置消息！");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
			System.out.println("==============这是视频消息！");
		}

		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
			System.out.println("==============这是语音消息！");
		}

		return null;
	}
}