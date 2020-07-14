package com.lin.spring.ioc.support;

/**
 * @Date 2020/7/14 22:28
 * @Author lbw
 **/
public class BeanDefinition {
    private String id;
    private Class clazz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Object getInstance(){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
