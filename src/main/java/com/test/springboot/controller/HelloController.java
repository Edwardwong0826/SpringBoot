package com.test.springboot.controller;

import com.test.springboot.bean.Car;
import com.test.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/user")
    public String getUser()
    {
        return "GET-张三";
    }

    @PostMapping("/user")
    public String saveUser()
    {
        return "POST-张三";
    }

    @PutMapping("/user")
    public String putUser()
    {
        return "PUT-张三";
    }

    @DeleteMapping("/user")
    public String deleteUser()
    {
        return "DELETE-张三";
    }
}
