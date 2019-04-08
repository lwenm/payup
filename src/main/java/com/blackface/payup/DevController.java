package com.blackface.payup;

import com.blackface.payup.config.GirlPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:lwenm
 * Description:
 * Date:2019/4/8
 * Time:22:28
 **/
@RestController
@RequestMapping("up")
public class DevController {


    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlPropertiesConfig girlPropertiesConfig;



    @GetMapping("index")
    public String index(){


        return "{name:lwenm} ---  "+content+"   "+girlPropertiesConfig.getAge();
    }

}
