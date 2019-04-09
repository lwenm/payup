package com.blackface.payup.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:lwenm
 * Description: http请求切面记录
 * Date:2019/4/9
 * Time:21:39
 **/

@Aspect
@Component
@Slf4j
public class HttpAspect {


//    @Before("execution(public * com.blackface.payup.controller.GirlController.girlList())")
    @Pointcut("execution(public * com.blackface.payup.controller.GirlController.*(..))")
    public void log(){
//          log.info("------------1--1--11-1------------");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        log.info("url={}", request.getRequestURL());

        //method
        log.info("method={}", request.getMethod());

        //ip
        log.info("ip={}", request.getRemoteAddr());

        //类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        Object[] objects = joinPoint.getArgs();
        String params = "***********" + joinPoint.getSignature().getName()+ "方法的参数  : ";
        for (Object object:objects){
            if (object != null) {
                //将对象转成json格式 并进行日志的打印
                String result = JSON.toJSONString(object);
//                log.info("请求" + controllerName + "类下" + method + "方法的参数为;" + result);
                params+=result+"  ";
            }
        }
        log.info(params);

    }

    @After("log()")
    public void doAfter() {
        log.info("----------------After--------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object.toString());
    }
}
