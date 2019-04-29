package com.ljcj.jpushrequest.entity;

import lombok.Data;

@Data
public class JpushAndroid {

    public class JpushIntent{
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    //通知内容
    private String alert;

    //通知标题
    private String title;

    //通知栏样式 ID
    private Integer builder_id;

    //通知栏展示优先级 默认为 0，范围为 -2～2 ，
    private Integer priority;

    //通知栏条目过滤或排序
    private String category;

    //通知栏样式类型 默认为 0，还有 1，2，3 可选，用来指定选择哪种通知栏样式，其他值无效。有三种可选分别为 bigText=1，Inbox=2，bigPicture=3。
    private Integer style;

    //通知提醒方式  可选范围为 -1～7 ，对应 Notification.DEFAULT_ALL = -1 或者 Notification.DEFAULT_SOUND = 1, Notification.DEFAULT_VIBRATE = 2, Notification.DEFAULT_LIGHTS = 4 的任意 “or” 组合。默认按照 -1 处理。
    private Integer alert_type;

    //大文本通知栏样式
    private String big_text;

    // 文本条目通知栏样式
//    private JpushInbox inbox;

    //扩展字段
    private JPushExtras extras;

    //通知栏大图标
    private String large_icon;

    //大图片通知栏样式
    private String big_pic_path;

    //指定跳转页面
    private JpushIntent intent;




}
