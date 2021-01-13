package com.test.springboot.config;

import com.test.springboot.bean.Pet;
import com.test.springboot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    // add component to ioc, use method name as component bean id, return type is component type
    // , return value is component instance in ioc
    public User user01()
    {
        return new User ("zhangsan", 18);
    }

    @Bean("tom")
    public Pet tomcat()
    {
        return new Pet("tomcat");
    }
}
