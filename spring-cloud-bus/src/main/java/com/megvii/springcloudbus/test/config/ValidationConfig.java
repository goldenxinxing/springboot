package com.megvii.springcloudbus.test.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.hibernate.validator.resourceloading.CachingResourceBundleLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.*;

import static org.hibernate.validator.messageinterpolation.AbstractMessageInterpolator.USER_VALIDATION_MESSAGES;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: ValidationConfig.java<br>
 * @Description: 本地国际化配置
 * @author: gaoxinxing
 */
//@Configuration
public class ValidationConfig implements WebMvcConfigurer {
    @Value("${spring.messages.basename:messages}")
    private String basename;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Validator getValidator() {
        /*// 解析配置值
        List<String> resourceBundles = Arrays.asList(
                StringUtils.commaDelimitedListToStringArray(
                        StringUtils.trimAllWhitespace(basename)));
        // 将validator提供的默认的配置作为一部分，避免原使用会出问题
        resourceBundles.add(USER_VALIDATION_MESSAGES);*/
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        //localValidatorFactoryBean.setMessageInterpolator(new MessageInterpolator());
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    private class MessageInterpolator extends ResourceBundleMessageInterpolator {

        public MessageInterpolator() {
            super(new CachingResourceBundleLocator(new MessageSourceResourceBundleLocator(messageSource)));

        }

        @Override
        public String interpolate(String message, Context context, Locale locale) {
            // 获取注解类型
            String annotationTypeName = context.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();

            // 根据注解类型获取自定义的消息Code
            String annotationDefaultMessageCode = VALIDATION_ANNATATION_DEFAULT_MESSAGES.get(annotationTypeName);
            if (null != annotationDefaultMessageCode && !message.startsWith("javax.validation")
                    && !message.startsWith("org.hibernate.validator.constraints")) {
                // 如果注解上指定的message不是默认的javax.validation或者org.hibernate.validator等开头的情况，
                // 则需要将自定义的消息Code拼装到原message的后面；
                message += "{" + annotationDefaultMessageCode + "}";
            }

            return super.interpolate(message, context, locale);
        }
    }

    private static final Map<String, String> VALIDATION_ANNATATION_DEFAULT_MESSAGES =
            new HashMap<String, String>(20) {{
                //put("Min", "validation.message.min");
                put("Min", "validation.message.min");
                put("NotNull", "validation.message.notNull");
            }};

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

}
