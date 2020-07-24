package com.lin.spring.demo;

import com.lin.spring.ioc.ApplicationContext;
import com.lin.spring.ioc.annotation.Autowire;
import com.lin.spring.ioc.annotation.Controller;
import com.lin.spring.ioc.support.AnnotationApplicationContext;

/**
 * @Date 2020/7/15 20:08
 * @Author lbw
 * 测试
 **/
@Controller
public class MyController {

    @Autowire("myService")
    private MyService myService;

    public void test(){
        myService.say("helloworld");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("applicationContext.properties");
        MyController controller = context.getBean("com.lin.spring.demo.MyController",MyController.class);
        controller.test();
    }
}
