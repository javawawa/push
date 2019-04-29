package com.ljcj.jpushrequest.entity;

import lombok.Data;

@Data
public class JPushExtras {

    private int pageType;  //推送落地页标识

    private String pageUrlForIOS = "";  //H5url

    private String pageUrlForAndroid = "";  //H5url

    private String pkid = "";  //主键参数

    private String categoryName = ""; //分类名

    private String news_id ; //news_id

    private String my_key ; //my_key

    private String type;

    private String id;



    public static enum PageTypeDesc {

        会员中心首页(1);

        public int value;
        private PageTypeDesc(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
