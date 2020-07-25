package com.lin.spring.ioc.support;

import com.lin.spring.ioc.annotation.Autowire;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * bean的依赖注入
 *
 * @Date 2020/7/15 21:44
 * @Author lbw
 **/
public class Populator {

    public Populator() {
    }

    public void populate(Map<String, Object> instanceMapping) {
        //首先判断ioc容器中是否有实例
        if (instanceMapping.isEmpty()) {
            return;
        }

        instanceMapping.entrySet().stream().forEach(entry -> {
            //获取对象的字段
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowire.class)) {
                    continue;
                }
                Autowire autowire = field.getAnnotation(Autowire.class);
                //后面的字段要注入的id value为空则按照类名 接口名自动注入
                String id = autowire.value();
                if ("".equals(id)) {
                    id = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    //反射注入
                    field.set(entry.getValue(), instanceMapping.get(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
