package com.megvii.springcloudbus.test.config;

import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: Config.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@Configuration
public class Config {
    @Bean
    public LocaleResolver localeResolver(WebMvcProperties webMvcProperties){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(webMvcProperties.getLocale());
        return sessionLocaleResolver;
    }
}
