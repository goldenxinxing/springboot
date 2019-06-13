package com.megvii.springcloudbus.test.config;

import com.megvii.test.MyEvent;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: EventConfiguration.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@Configuration
@RemoteApplicationEventScan("com.megvii.*")
public class EventConfiguration {
    /*@StreamListener(SpringCloudBusClient.INPUT)
    public void onEvent(MyEvent event){
        System.out.printf("MyEvent - Source : %s , originService : %s, destinationService : %s\n",
                event.getMessage(), event.getOriginService(), event.getDestinationService());
    }*/
    @EventListener
    public void onEvent(MyEvent event){
        System.out.printf("Listener2 -  MyEvent - Source : %s , originService : %s, destinationService : %s\n",
                event.getMessage(), event.getOriginService(), event.getDestinationService());
    }
    /*@Bean
    public MyEventListener myEventListener(){
        return new MyEventListener();
    }*/
}
