package com.ljcj.jpushrequest.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JPushUtil {

    public static Log log = LogFactory.getLog(JPushUtil.class);

    /**
     * 极光push- AppKey
     */
    @Value("${jpush.app_key}")
    private String APP_KEY;

    /**
     * 极光push- MasterSecret
     */
    @Value("${jpush.master_secret}")
    private String MASTER_SECRET;

    public String getAPP_KEY() {
        return APP_KEY;
    }

    public void setAPP_KEY(String APP_KEY) {
        this.APP_KEY = APP_KEY;
    }

    public String getMASTER_SECRET() {
        return MASTER_SECRET;
    }

    public void setMASTER_SECRET(String MASTER_SECRET) {
        this.MASTER_SECRET = MASTER_SECRET;
    }

    /**
     * 极光push- APNS开发环境（TRUE-生产环境，FALSE-开发环境）
     */
    @Value("${jpush.apns_production}")
    private static String APNS_PRODUCTION;

    /**
     * 极光push- 调用推送消息时，设置保留的时长（格式：60 * 60 * 24 one day）
     */
    @Value("${jpush.time_to_live}")
    private static long TIME_TO_LIVE;


    public static long sendCount = 0;


//    /**
//     * 初始化JPushClient
//     *
//     * @return
//     */
//    public static void createCustomClient() {
//        ClientConfig clientConfig = ClientConfig.getInstance();
//        clientConfig.setApnsProduction(Boolean.valueOf(APNS_PRODUCTION));    // development env
//        clientConfig.setTimeToLive(TIME_TO_LIVE);
//        jPushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
//    }


//    /**
//     * 批量推送
//     * 注：由于免费版极光限制了单次别名推送名单上限1000个，这里做了分批次推送
//     * @param jPushPayload
//     * @throws Exception
//     */
//    public static boolean sendPushes(JPushPayload jPushPayload) throws Exception{
//        if (jPushClient == null) {
//            createCustomClient();
//        }
//        final boolean flag = false;
//        List<List<String>> partition = Lists.partition(Lists.newArrayList(jPushPayload.getAliases()), 1000);
//        for (List<String> aliase : partition) {
//            jPushPayload.setAliases(aliase);
//            final PushPayload payload = buildPushObject(jPushPayload);
//            Thread thread = new Thread() {
//                public void run() {
//                    long start = System.currentTimeMillis();
//                    try {
//                        PushResult result = jPushClient.sendPush(payload);
//                        log.info("JPush success and got result - " + result);
//                    } catch (APIConnectionException e) {
//                        log.error("JPush Connection error. Should retry later. ", e);
//                        log.error("JPush Sendno: " + payload.getSendno());
//                    } catch (APIRequestException e) {
//                        log.error(" JPush Error response from JPush server. Should review and fix it. ", e);
//                        log.info("JPush Error：HTTP Status: " + e.getStatus() + "Error Code: " + e.getErrorCode() +
//                                "Error Message: " + e.getErrorMessage() + "Msg ID: " + e.getMsgId() +
//                                "Sendno: " + payload.getSendno());
//                    }
//                    System.out.println("耗时" + (System.currentTimeMillis() - start) + "毫秒 sendCount:" + (++sendCount));
//                }
//            };
//            thread.start();
//        }
//        return false;
//    }
//
//    /**
//     * * 批量推送(定时)
//     * 注：由于免费版极光限制了单次别名名单推送上限1000个，这里做了分批次推送
//     * @param name：定时任务自定义名
//     * @param time：格式 2017-02-01 12:22:00
//     * @param jPushPayload
//     * @throws Exception
//     */
//    public static void sendPushesSchedule(final String name, final String time, JPushPayload jPushPayload) throws Exception {
//        if (jPushClient == null) {
//            createCustomClient();
//        }
//        List<List<String>> partition = Lists.partition(Lists.newArrayList(jPushPayload.getAliases()), 1000);
//        for (List<String> aliase : partition) {
//            jPushPayload.setAliases(aliase);
//            final PushPayload payload = buildPushObject(jPushPayload);
//            Thread thread = new Thread() {
//                public void run() {
//                    long start = System.currentTimeMillis();
//                    try {
//                        ScheduleResult result = jPushClient.createSingleSchedule(name, time, payload);
//                        log.info("JPush success and got result - " + result);
//                    } catch (APIConnectionException e) {
//                        log.error("JPush Connection error. Should retry later. ", e);
//                        log.error("JPush Sendno: " + payload.getSendno());
//                    } catch (APIRequestException e) {
//                        log.error(" JPush Error response from JPush server. Should review and fix it. ", e);
//                        log.info("JPush Error：HTTP Status: " + e.getStatus() + "Error Code: " + e.getErrorCode() +
//                                "Error Message: " + e.getErrorMessage() + "Msg ID: " + e.getMsgId() +
//                                "Sendno: " + payload.getSendno());
//                    }
//                    System.out.println("耗时" + (System.currentTimeMillis() - start) + "毫秒 sendCount:" + (++sendCount));
//                }
//            };
//            thread.start();
//        }
//    }
//
//    /**
//     * JPUSH推送 - 立即
//     * 注：由于免费版极光限制了单次别名推送上限1000，这里适合别名单推名单在1000个以内
//     * 1000以上使用批量推送方法
//     * @param jPushPayload
//     * @return
//     * @throws Exception
//     */
//    public static boolean sendPush(JPushPayload jPushPayload) throws Exception {
//        if (jPushClient == null) {
//            createCustomClient();
//        }
//        if (jPushPayload.getjPushNotification() == null && jPushPayload.getjPushMessage() == null) {
//            return false;
//        }
//        PushPayload payload = buildPushObject(jPushPayload);
//        try {
//            PushResult result = jPushClient.sendPush(payload);
//            log.info("JPush success and got result - " + result);
//            return true;
//        } catch (APIConnectionException e) {
//            log.error("JPush Connection error. Should retry later. ", e);
//            log.error("JPush Sendno: " + payload.getSendno());
//            return false;
//        } catch (APIRequestException e) {
//            log.error(" JPush Error response from JPush server. Should review and fix it. ", e);
//            log.info("JPush Error：HTTP Status: " + e.getStatus() + "Error Code: " + e.getErrorCode() +
//                    "Error Message: " + e.getErrorMessage() + "Msg ID: " + e.getMsgId() +
//                    "Sendno: " + payload.getSendno());
//            return false;
//        }
//    }
//
//    /**
//     * JPUSH推送- 定时
//     * 注：由于免费版极光限制了单次别名推送上限1000，这里适合别名单推名单在1000个以内
//     * 1000以上使用批量推送方法
//     * @param name：定时任务自定义名
//     * @param time：格式 2017-02-01 12:22:00
//     * @param jPushPayload
//     * @return
//     * @throws Exception
//     */
//    public static boolean sendPushSchedule(String name, String time, JPushPayload jPushPayload) throws Exception {
//        if (jPushClient == null) {
//            createCustomClient();
//        }
//        if (jPushPayload.getjPushNotification() == null && jPushPayload.getjPushMessage() == null) {
//            return false;
//        }
//        PushPayload payload = buildPushObject(jPushPayload);
//        try {
//            ScheduleResult result = jPushClient.createSingleSchedule(name, time, payload);
//            log.info("schedule result is " + result);
//            return true;
//        } catch (APIConnectionException e) {
//            log.error("Connection error. Should retry later. ", e);
//            return false;
//        } catch (APIRequestException e) {
//            log.error(" JPush Error response from JPush server. Should review and fix it. ", e);
//            log.info("JPush Error：HTTP Status: " + e.getStatus() + "Error Code: " + e.getErrorCode() +
//                    "Error Message: " + e.getErrorMessage() + "Msg ID: " + e.getMsgId() +
//                    "Sendno: " + payload.getSendno());
//            return false;
//        }
//    }
//
//    /**
//     * 自定义推送对象
//     *
//     * @param jPushPayload
//     * @return
//     * @throws Exception
//     */
//    public static PushPayload buildPushObject(JPushPayload jPushPayload) throws Exception{
//        PushPayload.Builder pushBuilder = PushPayload.newBuilder();
//        //设置推送平台
//        if (JPushPayload.PlatformDesc.安卓.getValue().equals(jPushPayload.getPlatform())) {
//            pushBuilder.setPlatform(Platform.android());
//        } else if (JPushPayload.PlatformDesc.IOS.getValue().equals(jPushPayload.getPlatform())) {
//            pushBuilder.setPlatform(Platform.ios());
//        } else {
//            pushBuilder.setPlatform(Platform.android_ios());
//        }
//        //设置推送观众
//        if (JPushPayload.AudienceDesc.别名.getValue().equals(jPushPayload.getAudience())) {
//            pushBuilder.setAudience(Audience.alias(jPushPayload.getAliases()));
//        } else if (JPushPayload.AudienceDesc.标签.getValue().equals(jPushPayload.getAudience())) {
//            pushBuilder.setAudience(Audience.tag(jPushPayload.getTags()));
//        } else {
//            pushBuilder.setAudience(Audience.all());
//        }
//        //设置推送通知
//        if (jPushPayload.getjPushNotification() != null) {
//            Map notificationExtras = new HashMap<String, String>();
//            if (jPushPayload.getjPushNotification().getjPushExtras() != null) {
//
//                notificationExtras = new BeanUtilsBean().describe(jPushPayload.getjPushNotification().getjPushExtras());
//                notificationExtras.remove("class");
//            }
//            pushBuilder.setNotification(Notification.newBuilder()
//                    .setAlert(jPushPayload.getjPushNotification().getNotificationContent())
//                    .addPlatformNotification(AndroidNotification.newBuilder()
//                            .setTitle(jPushPayload.getjPushNotification().getNotificationTitle())
//                            .addExtras(notificationExtras).build())
//                    .addPlatformNotification(IosNotification.newBuilder()
////                            .incrBadge(1)
//                            .autoBadge()
//                            .addExtras(notificationExtras)
//                            .addExtra("title",jPushPayload.getjPushNotification().getNotificationTitle()).build())
//                    .build());
//        }
//
//        //设置自定义消息
//        if (jPushPayload.getjPushMessage() != null) {
//            Map messageExtras = new HashMap<String, String>();
//            if (jPushPayload.getjPushMessage().getjPushExtras() != null) {
//                messageExtras = new BeanUtilsBean().describe(jPushPayload.getjPushMessage().getjPushExtras());
//                messageExtras.remove("class");
//            }
//            pushBuilder.setMessage(Message.newBuilder()
//                    .setMsgContent(jPushPayload.getjPushMessage().getMsgContent())
//                    .setTitle(jPushPayload.getjPushMessage().getMsgTitle())
//                    .addExtras(messageExtras)
//                    .build());
//        }
//        return pushBuilder.build();
//    }
}
