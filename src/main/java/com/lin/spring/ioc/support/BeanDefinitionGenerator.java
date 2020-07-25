package com.lin.spring.ioc.support;


import com.lin.spring.ioc.annotation.Component;
import com.lin.spring.ioc.annotation.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/7/15 20:27
 * @Author lbw
 **/
public class BeanDefinitionGenerator {

    public static List<BeanDefinition> generate(String className) {
        try {
            Class clazz = Class.forName(className);
            String[] ids = generateIds(clazz);
            if (ids == null) {
                return null;
            }
            List<BeanDefinition> list = new ArrayList<BeanDefinition>();
            for (String id : ids) {
                list.add(new BeanDefinition(id, clazz));
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成id数组
     * 1.带有@Controller 注解但是注解value没给值,@Controller一般没有
     * 接口定义,用类的全名作为id返回ids长度为1
     * 2.@Component没有value获取所有的实现的接口,接口名为id,返回ids数组
     * 长度是实现的接口个数
     * 3.@Component 有value 返回id=value
     * 4.不带容器要实例化的注解  null
     *
     * @return java.lang.String
     * @Author lbw
     * @Description
     * @Date 20:47 2020/7/15
     * @Param [clazz]
     **/
    private static String[] generateIds(Class clazz) {
        String ids[] = null;
        if (clazz.isAnnotationPresent(Controller.class)) {
            ids = new String[]{clazz.getName()};
        } else if (clazz.isAnnotationPresent(Component.class)) {
            Component component = (Component) clazz.getAnnotation(Component.class);
            String value = component.value();
            if (!"".equals(value)) {
                ids = new String[]{value};
            } else {
                Class<?>[] interfaces = clazz.getInterfaces();
                ids = new String[interfaces.length];
                //如果这个类实现了接口，就用接口类型作为id
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = interfaces[i].getName();
                }
            }
        }
        return ids;
    }


}
