package com.xiafei.dubbo.learn.consumer;

import com.xiafei.dubbo.learn.sdk.UserServiceBo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/11/30</P>
 * <P>UPDATE DATE: 2018/11/30</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
public class TestXmlConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        System.out.println(context.getBean("userService", UserServiceBo.class).sayHello("齐霞飞"));

    }
}
