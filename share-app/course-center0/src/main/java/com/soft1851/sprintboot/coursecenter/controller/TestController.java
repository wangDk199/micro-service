package com.soft1851.sprintboot.coursecenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author ke
 * @ClassName TestConroller
 * @Description TOOD
 * @Date 2020/9/23
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试
     *
     */
    @GetMapping("test")
    public List<ServiceInstance> getInstances() {
        return this.discoveryClient.getInstances("user-center");
    }

    @GetMapping("/call/hello")
    public String callUserCenter() {


        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        int i = new Random().nextInt(instances.size());
        String url = instances.get(i).getUri().toString();
        log.info("实例："+ url);
        String targetUrl = instances.stream()
                .map(instance -> instance.getUri().toString().substring(0, 23)+ new Random().nextInt(4) + "/user/hello")
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("当前没有实例："));
        log.info(targetUrl);
        log.info(targetUrl.substring(0, 23));
        return restTemplate.getForObject(targetUrl, String.class);
    }

    @GetMapping(value = "/call/ribbon")
    public String callByRibbon() {
        return restTemplate.getForObject("http://user-center/user/hello", String.class);
    }

}
