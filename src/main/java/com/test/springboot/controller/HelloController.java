package com.test.springboot.controller;

import com.test.springboot.bean.Car;
import com.test.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    Person person;

    @RequestMapping("/car")
    public Car car()
    {
        return car;
    }

    @RequestMapping("/hello")
    public String handle1()
    {
        return "HelloWorld";
    }

    @RequestMapping("/person")
    public Person person()
    {
        return person;
    }
}
