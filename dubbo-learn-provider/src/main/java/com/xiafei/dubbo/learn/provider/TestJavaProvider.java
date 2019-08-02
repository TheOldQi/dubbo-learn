package com.xiafei.dubbo.learn.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.xiafei.dubbo.learn.sdk.UserServiceBo;

/**
 * <P>Description: java方式发布提供者. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/11/30</P>
 * <P>UPDATE DATE: 2018/11/30</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
public class TestJavaProvider {

    public static void main(String[] args) throws InterruptedException {

        UserServiceBo userServiceBo = new UserServiceImpl();

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20800);

        ServiceConfig<UserServiceBo> serviceBoServiceConfig = new ServiceConfig<>();
        serviceBoServiceConfig.setApplication(applicationConfig);
        serviceBoServiceConfig.setProtocol(protocolConfig);
        serviceBoServiceConfig.setRegistry(registryConfig);
        serviceBoServiceConfig.setInterface(UserServiceBo.class);
        serviceBoServiceConfig.setRef(userServiceBo);
        serviceBoServiceConfig.setVersion("1.0.0");
        serviceBoServiceConfig.setGroup("dubbo");

        serviceBoServiceConfig.export();

        Thread.currentThread().join();

    }
}
