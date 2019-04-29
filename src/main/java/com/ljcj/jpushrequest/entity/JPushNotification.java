package com.ljcj.jpushrequest.entity;

import lombok.Data;

/**
 * Notification信息对象
 */
@Data
public class JPushNotification {

    /**
     * alert 信息
     */
    private String alert;
    //安卓消息
    private JpushAndroid android;

    private JpushIos ios;//ios消息

    private JpushWinphone winphone;//winphone消息


    private String notificationTitle;  //推送标题

    private String notificationContent; //推送内容

    private JPushExtras jPushExtras; //附加字段



}
