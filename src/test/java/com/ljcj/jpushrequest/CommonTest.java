package com.ljcj.jpushrequest;

import com.ljcj.jpushrequest.entity.JPushPayload;
import com.ljcj.jpushrequest.entity.ResultMessage;
import com.ljcj.jpushrequest.utils.JPushUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommonTest {
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

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        JPushPayload jpushEntity = new JPushPayload();
        String apiURL = "https://api.huobi.pro/v1/common/symbols";
        HttpHeaders requestHeaders = new HttpHeaders();
        //base64
        JPushUtil jutil = new JPushUtil();
        ResultMessage re = new ResultMessage();
        String base64key = APP_KEY + ":" + MASTER_SECRET;
//        String base64AuthString = "Basic " + new BASE64Encoder().encodeBuffer(base64key.getBytes()).toString();
        String base64AuthString = "Basic ODRlNTAzZjEzMTY1OTY4ZjNiN2ZlZjY5OjUyYmY5Y2EwNTQ5NmM3NjRmZWI4OWZkYQ==";
        try {
//            requestHeaders.add("Authorization", base64AuthString);
            HttpEntity<JPushPayload> requestEntity = new HttpEntity<>(jpushEntity, requestHeaders);
            ResponseEntity<ResultMessage> responseEntity = restTemplate.getForEntity(apiURL, ResultMessage.class);
//            postForEntity(apiURL,requestEntity, ResultMessage.class);
            System.out.println(requestEntity);
        } catch (HttpStatusCodeException e) {
            Integer code = e.getRawStatusCode();
            re.setCode(code);
            re.setMessage("认证失败！");
        }
        System.out.println(re);
    }

    @Test
    public void TestRequest() {
        JPushPayload jpushEntity = new JPushPayload();
        String apiURL = "https://bjapi.push.jiguang.cn/v3/push";
        String base64key = APP_KEY + ":" + MASTER_SECRET;
        String encoding3 = Base64.getEncoder().encodeToString(base64key.getBytes(StandardCharsets.UTF_8));
        String base64AuthString = "Basic " + new BASE64Encoder().encodeBuffer(encoding3.getBytes()).toString();
//        String base64AuthString="Basic ODRlNTAzZjEzMTY1OTY4ZjNiN2ZlZjY5OjUyYmY5Y2EwNTQ5NmM3NjRmZWI4OWZkYQ==";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", base64AuthString);
//        jpushEntity.setPlatform("all");
//        jpushEntity.setAudience("all");
        String reqBody = "{    \"platform\": \"all\"," +
                "    \"audience\": \"all\"," +
                "    \"notification\": {" +
                "        \"android\": {" +
                "            \"alert\": \"Hi, JPush!\"," +
                "            \"title\": \"Send to Android\"," +
                "            \"builder_id\": 1," +
                "            \"large_icon\": \"http://www.jiguang.cn/largeIcon.jpg\"," +
                "            \"intent\": {" +
                "                \"url\": \"intent:#Intent;component=com.jiguang.push/com.example.jpushdemo.SettingActivity;end\"" +
                "            }," +
                "            \"extras\": {" +
                "                \"newsid\": 321" +
                "            }" +
                "        }," +
                "        \"ios\": {" +
                "            \"alert\": \"Hi, JPush!\"," +
                "            \"sound\": \"default\"," +
                "            \"badge\": \"+1\"," +
                "            \"extras\": {" +
                "                \"newsid\": 321" +
                "            }" +
                "        }" +
                "    }," +
                "    \"message\": {" +
                "        \"msg_content\": \"Hi,JPush\"," +
                "        \"content_type\": \"text\"," +
                "        \"title\": \"msg\"," +
                "        \"extras\": {" +
                "            \"key\": \"value\"" +
                "        }" +
                "    }" +
                "}";
        HttpEntity<String> formEntity = new HttpEntity<String>(reqBody, headers);

        String result = restTemplate.postForObject(apiURL, formEntity, String.class);
        System.out.println(result);
    }

    @Test
    public void testRobot() throws Exception{
        String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=5f4ce47b5a04dac6a45b3b84f8365a103733a5d4a6bc4e88cb931717150f4649";
        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(WEBHOOK_TOKEN);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"测试一下, 123\"}}";
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);

        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }
}
