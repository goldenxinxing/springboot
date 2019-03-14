package foo.rmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit 序列化 反序列化
 *
 * @author yanglongfei
 */
@Configuration
public class RabbitConfig {

  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter(new ObjectMapper());
  }
}
