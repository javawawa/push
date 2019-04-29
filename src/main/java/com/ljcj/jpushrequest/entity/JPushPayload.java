package com.ljcj.jpushrequest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Jpush用于传递数据的实体对象
 */
@ToString
public class JPushPayload {

    private JPushMessage message;

    private JPushNotification notification;

    private String platform; //推送平台
    @Getter
    @Setter
    private Object audience; //推送观众

    private Collection<String> aliases; //别名

    private Collection<String> tags; //标签

    private String isTiming;  //是否定时发送

    private String time;  //定时时间 格式：2018-11-21 12:10:00



    public JPushPayload() {
    }

    public JPushMessage getMessage() {
        return message;
    }

    public void setMessage(JPushMessage message) {
        this.message = message;
    }

    public JPushNotification getNotification() {
        return notification;
    }

    public void setNotification(JPushNotification notification) {
        this.notification = notification;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsTiming() {
        return isTiming;
    }

    public void setIsTiming(String isTiming) {
        this.isTiming = isTiming;
    }

    public Collection<String> getAliases() {
        return aliases;
    }

    public void setAliases(Collection<String> aliases) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String aliase: aliases) {
            if ( aliase.indexOf(",") != -1 ){
                String[] aliasesStr = aliase.split(",");
                for (String value:aliasesStr){
                    if ( !value.trim().equals("") ){
                        arrayList.add(value);
                    }
                }
            }else {
                arrayList.add(aliase);
            }
        }
        this.aliases = arrayList;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String tag: tags) {
            if ( tag.indexOf(",") != -1 ){
                String[] tagStr = tag.split(",");
                for (String value:tagStr){
                    if ( !value.trim().equals("") ){
                        arrayList.add(value);
                    }
                }
            }else {
                arrayList.add(tag);
            }
        }
        this.tags = arrayList;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }




    public static enum AudienceDesc {
        别名("1"),标签("2"),所有人("0");
        public String value;
        private AudienceDesc(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum PlatformDesc {
        安卓("1"),IOS("2"),所有平台("0");
        public String value;
        private PlatformDesc(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum isTimingDesc {
        立即("0"),定时("1");
        public String value;
        private isTimingDesc(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
