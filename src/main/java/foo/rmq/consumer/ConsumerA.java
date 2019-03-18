package foo.rmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static foo.rmq.config.RabbitConfiguration.KEY;
import static foo.rmq.config.RabbitConfiguration.TOPIC;

@Service
public class ConsumerA {
    private static AtomicInteger exceptionNum = new AtomicInteger(0);
    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = KEY, durable = "true"),
            exchange = @Exchange(value = TOPIC, type = ExchangeTypes.TOPIC, durable = "true"),
            key = KEY),
            containerFactory = "batch_clean_camera_listener"
    )
    @RabbitHandler
    public void print(Long cameraId, Channel channel, Message message){
        System.out.println(String.format("clean camera %d :begin", cameraId));
        if(cameraId == 1266){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("total num:%d", exceptionNum.incrementAndGet()));
            //throw new RuntimeException("test");
        }

//        try {
//            //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
//            //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//            //ack返回false，并重新回到队列，api里面解释得很清楚
//            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//            //拒绝消息
//            //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(String.format("clean camera %d :end", cameraId));
    }
}
