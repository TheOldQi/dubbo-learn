package com.xiafei.dubbo.learn.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.xiafei.dubbo.learn.sdk.UserServiceBo;

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
public class TestJavaConsumer {


    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);

        ReferenceConfig<UserServiceBo> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setId("userService");
        referenceConfig.setInterface(UserServiceBo.class);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");

        System.out.println(referenceConfig.get().sayHello("齐霞飞java"));

    }
}
