package com.sere.message;

public class WechatMessage extends BaseMessage{  
      
	
    private String Event = "";  //�¼����ͣ�subscribe(����)��unsubscribe(ȡ������)
    private String EventKey = "";  //�¼�KEYֵ��qrscene_Ϊǰ׺������Ϊ��ά��Ĳ���ֵ
    private String Ticket = "";   //��ά���ticket����������ȡ��ά��ͼƬ
    private String Latitude = "";  //����λ��γ��
    private String Longitude = "";  //����λ�þ���
    private String Precision = "";  //����λ�þ���
    
    /**
     * ͼƬ��Ϣ
     */
    private String PicUrl="";  
    
    /**
     * ��Ƶ/С��Ƶ��Ϣ
     */
    private String MediaId = ""; // ��Ƶ/���� ��Ϣý�� id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
    private String ThumbMediaId = ""; // ��Ƶ��Ϣ����ͼ��ý�� id�����Ե��ö�ý���ļ����ؽӿ���ȡ����
    
    
    private String Format="";  //������ʽ   
    
    /**
     * ������Ϣ
     */
    private String Title = "";// ��Ϣ����
    private String Description = ""; // ��Ϣ����
    private String Url = ""; // ��Ϣ����
    
    /**
     * ����λ����Ϣ
     */
   
    private String Location_X = "";   // ����λ��ά��   
    private String Location_Y = "";   // ����λ�þ���   
    private String Scale = "";  // ��ͼ���Ŵ�С   
    private String Label = "";  // ����λ����Ϣ   
  
    /**�ı���Ϣ����*/   
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
