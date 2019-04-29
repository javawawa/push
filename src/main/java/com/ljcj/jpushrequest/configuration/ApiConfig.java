package com.ljcj.jpushrequest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.net.SocksProxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
@Configuration
public class ApiConfig {
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        SocketAddress address = new InetSocketAddress("174.128.226.105", 10086);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, address);
        factory.setProxy(proxy);
        //单位为ms
        factory.setReadTimeout(5000);
        //单位为ms
        factory.setConnectTimeout(5000);
        return factory;
    }


}
