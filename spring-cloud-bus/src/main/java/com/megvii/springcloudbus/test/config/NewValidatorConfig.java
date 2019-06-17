package com.megvii.springcloudbus.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: NewValidatorConfig.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@Configuration
public class NewValidatorConfig {
    @Autowired
    private MessageSource messageSource;
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;

    }
}
