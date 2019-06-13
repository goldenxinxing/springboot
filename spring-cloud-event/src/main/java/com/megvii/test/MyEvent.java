package com.megvii.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @Package: com.megvii.springcloudbus.test.event<br>
 * @ClassName: MyEvent.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
//@JsonTypeName
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@Data
public class MyEvent extends RemoteApplicationEvent {
    private static final long serialVersionUID = -1624266233141574546L;
    private String message;
    public MyEvent(){}
    public MyEvent(Object source, String originService,
                   String destinationService){
        super(source, originService, destinationService);
    }
}
