package com.ljcj.jpushrequest.entity;

import lombok.Data;

@Data
public class JpushIos {

    //通知内容
    private String alert;

    //通知提示声音或警告通知
    private String sound;

    //应用角标
    private Integer badge;

    //推送唤醒
//    private boolean content_available;

    //通知扩展
//    private boolean mutable_content;

    private String category;

    //扩展字段
    private JPushExtras extras;



}
