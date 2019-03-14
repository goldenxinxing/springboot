package foo.rmq.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class RabbitConfiguration {
    public static final String TOPIC = "${megvii.vsr.rabbit.batch.camera.clean.rmqTopic:camera_delete_topic1}";
    public static final String KEY = "${megvii.vsr.rabbit.batch.camera.clean.rmqKey:camera_delete_key1}";

    @Bean("batch_clean_camera_listener")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            MessageConverter converter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                6,
                new BasicThreadFactory.Builder()
                        .namingPattern("clean-camera-handler-pool-%d")
                        .daemon(true)
                        .build()
        );

        factory.setTaskExecutor(executor);

        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(20);
        factory.setPrefetchCount(3);

        factory.setMessageConverter(converter);

        return factory;
    }
}
