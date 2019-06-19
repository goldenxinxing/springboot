package com.megvii.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
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
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
public class TestApplication {
    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
}
