package com.megvii.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

/**
 * @Package: com.megvii.springcloudbus<br>
 * @ClassName: TestApplication.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@SpringBootApplication
@EnableEurekaClient
@PropertySource(value = "ValidationMessages.properties", encoding = "UTF-8")
public class TestApplication {
    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
}
