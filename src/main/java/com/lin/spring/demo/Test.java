package com.lin.spring.demo;

import com.lin.spring.ioc.BeanRegister;
import com.lin.spring.ioc.support.BeanDefinitionParser;
import sun.applet.Main;

/**
 * @Date 2020/7/15 20:08
 * @Author lbw
 **/
public class Test {

    public static void main(String[] args) {
        BeanDefinitionParser beanDefinitionParser = new BeanDefinitionParser();
        beanDefinitionParser.doRegister("com.lin.spring.demo");
    }
}
