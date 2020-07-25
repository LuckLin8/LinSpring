package com.lin.spring.mvc;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 定义Adapter 和 HandlerAdapter
 *
 * @Date: 2020/7/19 11:24
 * @Author: LBW
 **/
public class Handler {

    //调用具体的controller对象
    private Object controller;
    //和url进行匹配方法
    private Method method;
    //对应requestMapping的url正则
    private Pattern pattern;

    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
