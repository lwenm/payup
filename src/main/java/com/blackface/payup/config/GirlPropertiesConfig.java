package com.blackface.payup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author:lwenm
 * Description: 女生属性配置
 * Date:2019/4/8
 * Time:22:37
 **/
@Component
@ConfigurationProperties(prefix = "girl")
@Data
public class GirlPropertiesConfig {

    /**
     * 罩杯
     */
    private String cupSize;


    /**
     * 年龄
     */
    private String age;



}
