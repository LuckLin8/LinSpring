package com.lin.spring.ioc;

import com.lin.spring.ioc.support.BeanDefinition;

import java.util.List;

/**
 * BeanRegiser定义向工厂注册bean和BeanDefinition
 *
 * @Author lbw
 * @Date 22:00 2020/7/14
 **/
public interface BeanRegister {


    /**
     * @Author lbw
     * @Description 向工厂内注册BeanDefinition
     * @Date 22:04 2020/7/14
     * @Param [bds]
     * @return void
     **/
    void registBeanDefinition(List<BeanDefinition> bds);

    /**
     * @Author lbw
     * @Description 向工厂内注册bean实例
     * @Date 22:04 2020/7/14
     * @Param [id, instance]
     * @return void
     **/
    void registInstanceMapping(String id, Object instance);
}
