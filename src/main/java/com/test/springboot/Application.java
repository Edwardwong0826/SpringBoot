package com.test.springboot;


import com.test.springboot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Application {

	// we can also use cmd to execute the jar generated by maven clean, go to the folder and java jar xxxxxx.jar
	public static void main(String[] args)
	{
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		String[] names = run.getBeanDefinitionNames();
		for(String name: names)
		{
			System.out.println(name);
		}

//		Pet tom01 = run.getBean("tom", Pet.class);
//		Pet tom02 = run.getBean("tom", Pet.class);
//
//		System.out.println("component: " + (tom01 == tom02));

		// if @Configuration(proxyBeanMethods = true), then is proxy object call method
		MyConfig configBean = run.getBean(MyConfig.class);
		System.out.println(configBean);

//		User user = configBean.user01();
//		Pet tomcat = configBean.tomcat();
//
//		User user01 = run.getBean("user01", User.class);
//		Pet tomcat1 = run.getBean("tomcat", Pet.class);
//
//		System.out.println(user01.getPet() == tomcat1);


		boolean tom = run.containsBean("tom");
		System.out.println("tom: " + tom);

		boolean user01 = run.containsBean("user01");
		System.out.println("user01: " + user01);

		boolean haha = run.containsBean("haha");
		boolean hehe = run.containsBean("hehe");

		System.out.println("haha: "+haha);
		System.out.println("hehe: "+hehe);



	}

}
