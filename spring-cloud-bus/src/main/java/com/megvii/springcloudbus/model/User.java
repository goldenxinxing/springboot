package com.megvii.springcloudbus.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Package: com.megvii.springcloudbus.model<br>
 * @ClassName: User.java<br>
 * @Description: TODO
 * @author: gaoxinxing
 */
@Data
public class User {
    @NotNull(message = "name不能为空")
    private String name;

    private String number;
    @Min(value = 100, message = "{age}{validation.message.min}")
    private int age;
}
