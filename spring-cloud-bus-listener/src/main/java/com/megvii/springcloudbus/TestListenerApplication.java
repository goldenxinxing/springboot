package com.megvii.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Package: com.megvii.springcloudbus<br>
 * @ClassName: TestApplication.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@SpringBootApplication
@EnableEurekaClient
public class TestListenerApplication {
    public static void main(String[] args){
        SpringApplication.run(TestListenerApplication.class, args);
    }
}
