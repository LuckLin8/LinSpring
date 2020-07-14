package com.lin.spring.ioc.support;

import com.lin.spring.ioc.ApplicationContext;
import com.lin.spring.ioc.BeanRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2020/7/14 22:21
 * @Author lbw
 **/
public class AnnotationApplicaitonContext implements ApplicationContext , BeanRegister {

    private Map<String,Object> instanceMapping = new ConcurrentHashMap<String, Object>();

    //保存所有bean的信息，主要包含bean的类型，id信息
    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();

    //配置文件的config，这里直接使用properties
    private Properties config = new Properties();

    
    public Object getBean(String id) {

        return null;
    }

    public <T> T getBean(String id, Class<T> clazz) {
        return null;
    }

    public Map<String, Object> getBeans() {
        return null;
    }

    public void registBeanDefinition(List<BeanDefinition> bds) {

    }

    public void registInstanceMapping(String id, Object instance) {

    }
}
