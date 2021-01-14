package com.test.springboot.config;

import com.test.springboot.bean.Car;
import com.test.springboot.bean.Person;
import com.test.springboot.bean.Pet;
import com.test.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

import java.util.Date;

/**
 * @Configuration class that mark with bean can register component to ioc, and default is singleton,
 *    full mode -> proxyBeanMethods = true
 *    lite mode -> proxyBeanMethods = false
 *    component dependent, if have then set to true else set to false
 *    full mode will ensure always check get from ioc, lite mode will direct return new instance
 *
 * @Import
 *    spring will directly add those class into ioc
 */
//@Import({User.class})
//@ConditionalOnBean(name = "tom") // will only add class bean if conditional bean is exist
@ImportResource("classpath:beans.xml") // import xml file defined bean into ioc
@Configuration(proxyBeanMethods = false) // proxyBeanMethods default is true
@EnableConfigurationProperties({Car.class}) // 1.开启属性配置，2.把这个Car组件自当注册进ioc, 有这个的话就不用再Car class放@Compoennt
public class MyConfig {

    //the order is matter on this version, tom bean need to be above first, then @ConditionalOnBean on below will work
    @Bean("tom")
    public Pet tomcat()
    {
        return new Pet("tomcat");
    }

    /**
     * no matter how matter at outside call this configuration class to get bean, it was still get from ioc
     * @return
     */
    @Primary
    @ConditionalOnBean( name = "tom") // will only add this bean if the conditional bean is exist
    @Bean // add component to ioc, use method name as component bean id, return type is component type return value is component instance in ioc
    public User user01()
    {
        User zhangsan = new User("zhangsan",10);
        // user component will depend on pet component if is full mode
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean
    public String string()
    {
        return "";
    }
//
//    @Bean
//    public Boolean booleanReturn()
//    {
//        Boolean bool = false;
//        return bool;
//    }
//
//    @Bean
//    public Date date()
//    {
//        return new Date();
//    }
}
