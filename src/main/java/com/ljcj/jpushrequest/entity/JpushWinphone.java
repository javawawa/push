package com.ljcj.jpushrequest.entity;

import lombok.Data;

@Data
public class JpushWinphone {

    //通知内容
    private String alert;

    //通知标题
    private String title;

    //点击打开的页面名称
    private String _open_page;

    //扩展字段
    private JPushExtras extras;

}
