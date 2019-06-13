package com.megvii.springcloudbus.test.config;

import com.megvii.test.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: MyEventListener.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
//@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.printf("MyEvent - Source : %s , originService : %s, destinationService : %s\n",
                event.getMessage(), event.getOriginService(), event.getDestinationService());
    }
}
