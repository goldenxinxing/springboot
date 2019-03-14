package foo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerA {
    /**
     * 相机删除的topic
     */
    private static final String CAMERA_DELETE_TOPIC = "camera_delete_topic1";
    /**
     * 相机删除的key
     */
    private static final String CAMERA_DELETE_KEY = "camera_delete_key1";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String produceMsg(Long cId){
        rabbitTemplate.convertAndSend(CAMERA_DELETE_TOPIC, CAMERA_DELETE_KEY, cId);
        return "success";
    }
}
