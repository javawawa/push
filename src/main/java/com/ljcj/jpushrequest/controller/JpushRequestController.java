package com.ljcj.jpushrequest.controller;

import com.alibaba.fastjson.JSON;
import com.ljcj.jpushrequest.entity.JPushPayload;
import com.ljcj.jpushrequest.entity.JpushReturn;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequestMapping("/jpush")
@RestController
public class JpushRequestController {

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        // Do any additional configuration here
//        return builder.build();
//    }
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

    @RequestMapping(value = "/JpushByPost",method = RequestMethod.POST)
    public JpushReturn JpushByPost(@RequestBody JPushPayload jpushEntity) {
        String apiURL = "https://bjapi.push.jiguang.cn/v3/push";
        HttpHeaders requestHeaders = new HttpHeaders();
        JpushReturn re = new JpushReturn();
        String base64key =APP_KEY+":"+MASTER_SECRET;
        String base64AuthString = "Basic " + Base64.getEncoder().encodeToString(base64key.getBytes(StandardCharsets.UTF_8));
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", base64AuthString);
        try {
            String JpushJson = JSON.toJSONString(jpushEntity);
            HttpEntity<String> formEntity = new HttpEntity<String>(JpushJson, headers);
            String responseEntity = restTemplate.postForObject(apiURL, formEntity, String.class);
            re=JSON.parseObject(responseEntity,JpushReturn.class);
            re.setMessage("推送成功");
            return re;
        }catch (HttpStatusCodeException e){
            Integer code = e.getRawStatusCode();
            String responseBodyAsString = e.getResponseBodyAsString();
            JpushReturn res =  JSON.parseObject(responseBodyAsString,JpushReturn.class);
            res.setMessage("推送失败");
            return res;
        }

    }

}
