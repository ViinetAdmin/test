package com.viinet.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableAsync
public class AsyncService {

    @Autowired
    RestTemplate restTemplate;

    private final static String url = "http://127.0.0.1:5556/advertise/test/1";

    @Async("asyncThreadPoolTaskExecutor")
    public void sendRequest() throws Exception {
        System.out.println("current thread name -1: " + Thread.currentThread().getName());
        int count = 1000;
        for(int i=0; i<count; i++) {
            restTemplate.getForEntity(url, null);
        }

    }


}
