package com.lin.spring.ioc.support;

import com.lin.spring.ioc.BeanRegister;

import java.util.List;

/**
 * 创建bean并且加入到容器工厂
 *
 *
 * @Date 2020/7/15 21:33
 * @Author lbw
 **/
public class BeanCreater {

    private BeanRegister register;

    public BeanCreater(BeanRegister register) {
        this.register = register;
    }

    public void create(List<BeanDefinition> bds) {
        for (BeanDefinition bd : bds){
            doCreate(bd);
        }
    }

    private void doCreate(BeanDefinition bd) {
        Object instance = bd.getInstance();
        this.register.registInstanceMapping(bd.getId(),instance);
    }
}
