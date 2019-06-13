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
    /**
     * 因为是自己触发事件，但此处又自己监听，bus会识别，将此作为本地事件监听存在，
     */
    @EventListener
    public void onEvent(MyEvent event){
        System.out.printf("MyEvent - Source : %s , originService : %s, destinationService : %s\n",
                event.getSource(), event.getOriginService(), event.getDestinationService());
    }

}
