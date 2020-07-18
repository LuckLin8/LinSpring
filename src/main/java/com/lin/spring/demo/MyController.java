package com.lin.spring.demo;

import com.lin.spring.ioc.BeanRegister;
import com.lin.spring.ioc.annotation.Autowire;
import com.lin.spring.ioc.annotation.Controller;
import com.lin.spring.ioc.support.BeanDefinitionParser;
import sun.applet.Main;

/**
 * @Date 2020/7/15 20:08
 * @Author lbw
 **/
@Controller
public class MyController {

    @Autowire("myService")
    private MyService myService;

    public void test(){
        myService.say("helloworld");
    }
}
