package com.xiafei.dubbo.learn.provider;

import com.xiafei.dubbo.learn.sdk.UserServiceBo;
import org.springframework.stereotype.Component;

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
@Component("userService")
public class UserServiceImpl implements UserServiceBo {

    @Override
    public String sayHello(final String name) {
        return name;
    }
}
