package com.sere.job;

import org.apache.log4j.Logger;

import com.sere.util.WeChatUtil;

public class WechatTokenJob {
	private static Logger logger = Logger.getLogger(WechatTokenJob.class);
    /**
     * @Description: ����ִ�л�ȡ token
     * @param    
     */
    public void workForToken() {
        try {
            WeChatUtil timer = new WeChatUtil();
            timer.getToken_getTicket();
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
}
