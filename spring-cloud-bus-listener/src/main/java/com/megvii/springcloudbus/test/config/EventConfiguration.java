package com.megvii.springcloudbus.test.config;

import com.megvii.test.MyEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: EventConfiguration.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@Configuration
@RemoteApplicationEventScan("com.megvii")
public class EventConfiguration {
    /* 严禁使用如下方式 */
    /*@StreamListener(SpringCloudBusClient.INPUT)
    public void onEvent(MyEvent event){
        System.out.printf("MyEvent - Source : %s , originService : %s, destinationService : %s\n");
    }*/

    @EventListener
    public void onEvent(MyEvent event){
        System.out.printf("Listener1 - Source : %s , originService : %s, destinationService : %s\n",
                event.getMessage(), event.getOriginService(), event.getDestinationService());
    }
}
