package com.lin.spring.ioc.support;

import com.lin.spring.ioc.ApplicationContext;
import com.lin.spring.ioc.BeanRegister;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2020/7/14 22:21
 * @Author lbw
 **/
public class AnnotationApplicationContext implements ApplicationContext, BeanRegister {

    private Map<String, Object> instanceMapping = new ConcurrentHashMap<String, Object>();

    //保存所有bean的信息，主要包含bean的类型，id信息
    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
    //配置文件的config，这里直接使用properties
    private Properties config = new Properties();

    public AnnotationApplicationContext(String localtion) {
        InputStream is = null;
        try {

            //定位
            is = this.getClass().getClassLoader().getResourceAsStream(localtion);

            //载入
            config.load(is);

            //注册
            register();

            //实例化
            createBean();

            //注入
            populate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return void
     * @Author lbw
     * @Description 调用具体的委派的注入类进行注入
     * @Date 22:48 2020/7/14
     * @Param []
     **/
    private void populate() {
        Populator populator = new Populator();
        populator.populate(instanceMapping);
    }

    /**
     * @return void
     * @Author lbw
     * @Description 调用具体的创建对象进行创建bean
     * @Date 22:51 2020/7/14
     * @Param []
     **/
    private void createBean() {
        BeanCreater creater = new BeanCreater(this);
        creater.create(beanDefinitions);
    }

    /**
     * @return void
     * @Author lbw
     * @Description 调用具体的注册对象注册bean信息
     * @Date 22:52 2020/7/14
     * @Param []
     **/
    private void register() {
        BeanDefinitionParser parser = new BeanDefinitionParser(this);
        parser.parse(config);
    }

    @Override
    public Object getBean(String id) {
        return instanceMapping.get(id);
    }

    @Override
    public <T> T getBean(String id, Class<T> clazz) {
        return (T) instanceMapping.get(id);
    }

    @Override
    public Map<String, Object> getBeans() {
        return instanceMapping;
    }

    @Override
    public void registBeanDefinition(List<BeanDefinition> bds) {
        beanDefinitions.addAll(bds);
    }

    @Override
    public void registInstanceMapping(String id, Object instance) {
        instanceMapping.put(id, instance);
    }

    public Properties getConfig() {
        return this.config;
    }
}
