package com.lin.spring.ioc.support;

import com.lin.spring.ioc.BeanRegister;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * 完成扫描包下bean信息的解析注册
 *
 * @Date 2020/7/15 19:48
 * @Author lbw
 **/
public class BeanDefinitionParser {
    //配置扫描包的key
    public static final String SCAN_PACKAGE = "scanPackage";
    //容器注册对象
    private BeanRegister register;

    public BeanDefinitionParser(BeanRegister register) {
        this.register = register;
    }

    public void parse(Properties properties) {
        //获取要扫描的包
        String packageName = properties.getProperty(SCAN_PACKAGE);
        //执行注册
        doRegister(packageName);
    }

    private void doRegister(String packageName) {
        //获取此包下的绝对路径
        URL url = getClass().getClassLoader().getResource("./" + packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        //循环遍历获取所有java文件
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                //文件夹：递归执行
                doRegister(packageName + "." + file.getName());
            } else {
                //处理文件名获取java类名，在运行时获得的是class文件
                String className = packageName + "." + file.getName().replaceAll(".class", "").trim();
                //调用BeanDefinitionGenerator.generate(className)方法,来处理
                //1.类带有容器要处理的注解,则解析id生成BeanDefinition集合返回
                //2.不带有需要处理的注解   直接返回null
                List<BeanDefinition> definitions = BeanDefinitionGenerator.generate(className);
                if (definitions == null) {
                    continue;
                }
                this.register.registBeanDefinition(definitions);
            }
        }
    }


}
