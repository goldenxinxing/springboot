package foo.rmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static foo.rmq.config.RabbitConfiguration.KEY;
import static foo.rmq.config.RabbitConfiguration.TOPIC;

@Service
public class ConsumerA {
    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = KEY, durable = "true"),
            exchange = @Exchange(value = TOPIC, type = ExchangeTypes.TOPIC, durable = "true"),
            key = KEY),
            containerFactory = "batch_clean_camera_listener"
    )
    public void print(Long cameraId){
        System.out.println(String.format("clean camera %d :begin", cameraId));
        if(cameraId == 1266){
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("test");
        }

        System.out.println(String.format("clean camera %d :end", cameraId));
    }
}
