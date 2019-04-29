package com.ljcj.jpushrequest.entity;

/**
 * message信息对象
 */
public class JPushMessage {

    private String msg_content; //message内容

    private String msgTitle;  //message标题

    private String content_type;  //消息内容类型

    private JPushExtras jPushExtras; //message附加内容

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public JPushExtras getjPushExtras() {
        return jPushExtras;
    }

    public void setjPushExtras(JPushExtras jPushExtras) {
        this.jPushExtras = jPushExtras;
    }
}
