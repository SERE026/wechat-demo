package com.sere.dispather;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sere.message.WechatMessage;

public class ReceiveXmlProcess {
	/**
	 * ����΢��xml��Ϣ
	 * 
	 * @param strXml
	 * @return
	 */
	public WechatMessage getMsgEntity(String strXml) {
		WechatMessage msg = null;
		try {
			if (strXml.length() <= 0 || strXml == null)
				return null;

			// ���ַ���ת��ΪXML�ĵ�����
			Document document = DocumentHelper.parseText(strXml);
			// ����ĵ��ĸ��ڵ�
			Element root = document.getRootElement();
			// �������ڵ��������ӽڵ�
			Iterator<?> iter = root.elementIterator();

			// �������н��
			msg = new WechatMessage();
			// ���÷�����ƣ�����set����
			// ��ȡ��ʵ���Ԫ����
//			Class<?> c = Class.forName("com.sere.message.ReceiveMessage");
//			msg = (ReceiveMessage) c.newInstance();// �������ʵ��Ķ���

			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				// ��ȡset�����еĲ����ֶΣ�ʵ��������ԣ�
				Field field = msg.getClass().getDeclaredField(ele.getName());
				// ��ȡset������field.getType())��ȡ���Ĳ�����������
				Method method = msg.getClass().getDeclaredMethod("set" + ele.getName(), field.getType());
				// ����set����
				method.invoke(msg, ele.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("xml ��ʽ�쳣: " + strXml);
			e.printStackTrace();
		}
		return msg;
	}
}