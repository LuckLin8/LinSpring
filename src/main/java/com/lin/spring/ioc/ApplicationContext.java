package com.lin.spring.ioc;

import java.util.Map;

/**
 * ApplicationContext主要定义获取bean的方法，根据id，或者全部获取
 *
 * @Author lbw
 * @Date 21:17 2020/7/14
 **/
public interface ApplicationContext {

    /**
     * @Author lbw
     * @Description 根据id获取bean实例
     * @Date 21:19 2020/7/14
     * @Param [id]
     * @return java.lang.Object
     **/
    Object getBean(String id);

    /**
     * @Author lbw
     * @Description 根据id获取特定类型的bean完成强转
     * @Date 21:20 2020/7/14
     * @Param [id, clazz]
     * @return T
     **/
    <T>T getBean(String id,Class<T> clazz);

    /**
     * @Author lbw
     * @Description 获取工厂中的所有bean
     * @Date 21:20 2020/7/14
     * @Param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> getBeans();


}
