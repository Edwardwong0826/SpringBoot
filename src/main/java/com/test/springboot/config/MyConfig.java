package com.test.springboot.config;

import com.test.springboot.bean.Pet;
import com.test.springboot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
//ConditionalOnBean(name = "tom") // will only add class bean if conditional bean is exist
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    /**
     * no matter how matter at outside call this configuration class to get bean, it was still get from ioc that one
     * @return
     */
    @ConditionalOnMissingBean(name = "tom") // will only add this bean if the conditional bean is exist
    @Bean // add component to ioc, use method name as component bean id, return type is component type return value is component instance in ioc
    public User user01()
    {
        User zhangsan = new User("zhangsan",10);
        // user component will depend on pet component if is full mode
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcat()
    {
        return new Pet("tomcat");
    }
}
