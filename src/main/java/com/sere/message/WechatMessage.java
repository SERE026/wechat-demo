package com.sere.message;

public class WechatMessage extends BaseMessage{  
      
	
    private String Event = "";  //事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String EventKey = "";  //事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String Ticket = "";   //二维码的ticket，可用来换取二维码图片
    private String Latitude = "";  //地理位置纬度
    private String Longitude = "";  //地理位置经度
    private String Precision = "";  //地理位置精度
    
    /**
     * 图片消息
     */
    private String PicUrl="";  
    
    /**
     * 视频/小视频消息
     */
    private String MediaId = ""; // 视频/语音 消息媒体 id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId = ""; // 视频消息缩略图的媒体 id，可以调用多媒体文件下载接口拉取数据
    
    
    private String Format="";  //语音格式   
    
    /**
     * 链接消息
     */
    private String Title = "";// 消息标题
    private String Description = ""; // 消息描述
    private String Url = ""; // 消息链接
    
    /**
     * 地理位置信息
     */
   
    private String Location_X = "";   // 地理位置维度   
    private String Location_Y = "";   // 地理位置经度   
    private String Scale = "";  // 地图缩放大小   
    private String Label = "";  // 地理位置信息   
  
    /**文本消息内容*/   
    private String Content="";  
    
    
    private String Recognition="";  
      
    public String getRecognition() {  
        return Recognition;  
    }  
    public void setRecognition(String recognition) {  
        Recognition = recognition;  
    }  
    public String getFormat() {  
        return Format;  
    }  
    public void setFormat(String format) {  
        Format = format;  
    }  
    public String getContent() {  
        return Content;  
    }  
    public void setContent(String content) {  
        Content = content;  
    }  
    public String getLocation_X() {  
        return Location_X;  
    }  
    public void setLocation_X(String locationX) {  
        Location_X = locationX;  
    }  
    public String getLocation_Y() {  
        return Location_Y;  
    }  
    public void setLocation_Y(String locationY) {  
        Location_Y = locationY;  
    }  
    public String getScale() {  
        return Scale;  
    }  
    public void setScale(String scale) {  
        Scale = scale;  
    }  
    public String getLabel() {  
        return Label;  
    }  
    public void setLabel(String label) {  
        Label = label;  
    }  
    public String getTitle() {  
        return Title;  
    }  
    public void setTitle(String title) {  
        Title = title;  
    }  
    public String getDescription() {  
        return Description;  
    }  
    public void setDescription(String description) {  
        Description = description;  
    }  
    public String getUrl() {  
        return Url;  
    }  
    public void setUrl(String url) {  
        Url = url;  
    }  
    public String getPicUrl() {  
        return PicUrl;  
    }  
    public void setPicUrl(String picUrl) {  
        PicUrl = picUrl;  
    }  
    public String getMediaId() {  
        return MediaId;  
    }  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
    public String getEventKey() {  
        return EventKey;  
    }  
    public void setEventKey(String eventKey) {  
        EventKey = eventKey;  
    }  
    public String getTicket() {  
        return Ticket;  
    }  
    public void setTicket(String ticket) {  
        Ticket = ticket;  
    }  
    public String getLatitude() {  
        return Latitude;  
    }  
    public void setLatitude(String latitude) {  
        Latitude = latitude;  
    }  
    public String getLongitude() {  
        return Longitude;  
    }  
    public void setLongitude(String longitude) {  
        Longitude = longitude;  
    }  
    public String getPrecision() {  
        return Precision;  
    }  
    public void setPrecision(String precision) {  
        Precision = precision;  
    }  
    public String getEvent() {  
        return Event;  
    }  
    public void setEvent(String event) {  
        Event = event;  
    }
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}  
     
}  
