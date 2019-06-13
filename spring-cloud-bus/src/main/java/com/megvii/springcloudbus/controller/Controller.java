package com.megvii.springcloudbus.controller;

import com.megvii.test.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.megvii.springcloudbus.test.config<br>
 * @ClassName: Controller.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@RestController
@RequestMapping("test")
public class Controller {
    /**
     * 事件发布器（通过实现 ApplicationEventPublisherAware 实现自动装载）
     * 补充: AnnotationConfigApplicationContext 是 ApplicationEventPublisher 的一种具体实现
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 应用上下文（通过实现 ApplicationContextAware 实现自动装载）
     */
    @Autowired
    private ApplicationContext applicationContext;

    @ResponseBody
    @PostMapping("send")
    public String send(String msg, @RequestParam(value = "destination", required = false, defaultValue = "**") String destination){
        //获取应用id
        String serviceInstanceId = applicationContext.getId();
        //新建 自定义事件 对象
        MyEvent event = new MyEvent(msg, serviceInstanceId, destination);
        event.setMessage(msg);
        //发布事件
        applicationContext.publishEvent(event);
        return "success";
    }
}
