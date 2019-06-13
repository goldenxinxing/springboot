package com.megvii.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package: com.megvii.springcloudbus<br>
 * @ClassName: TestApplication.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@SpringBootApplication
@EnableEurekaClient
public class TestListener2Application {
    public static void main(String[] args){
        SpringApplication.run(TestListener2Application.class, args);
    }
}
