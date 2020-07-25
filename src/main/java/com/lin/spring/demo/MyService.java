package com.lin.spring.demo;

import com.lin.spring.ioc.annotation.Component;

/**
 * @Date 2020/7/18 17:26
 * @Author lbw
 **/
@Component("myService")
public class MyService {

    public void say(String s) {
        System.out.println(s);
    }
}
