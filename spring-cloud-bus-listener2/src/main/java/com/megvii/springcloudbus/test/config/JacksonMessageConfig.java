package com.megvii.springcloudbus.test.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @Package: com.megvii.framework.autoconfigure.jackson<br>
 * @ClassName: JacksonMessageConfig.java<br>
 * @Description: jackson配置类
 * @author: gaoxinxing
 */
//@Configuration
public class JacksonMessageConfig implements Jackson2ObjectMapperBuilderCustomizer {

    /*@Bean
    @Primary
    public ObjectMapper jacksonObjectMapper(Module... modules) {
        ObjectMapper mapper = new ObjectMapper();
        // null值不输出，使用默认值
        mapper.setPropertyInclusion(
                JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.USE_DEFAULTS));
        // 序列化：空对象不报错
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化：对于不存在的属性不影响反序列化过程
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.registerModules(modules);
        return mapper;
    }*/

    //@Bean
    public JavaTimeModule javaTimeModule() {
        return new JavaTimeModule();
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder
                .failOnUnknownProperties(false)
                .failOnEmptyBeans(false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .featuresToEnable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);

    }
}
