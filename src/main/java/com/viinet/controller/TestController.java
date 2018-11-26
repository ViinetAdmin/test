package com.viinet.controller;

import com.viinet.component.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    public String testRestTemplate() throws Exception{
        long start = System.currentTimeMillis();
        int count = 100000;
        for(int i=0; i<count; i++) {
            asyncService.sendRequest();
        }
        System.out.println("it takes " + (System.currentTimeMillis() - start) + " ms");
        return "SUCCESS";
    }


    @GetMapping("foo")
    public String foo() {
        return "foo";
    }

    @GetMapping("bar")
    public String bar() {
        return "bar";
    }

}
