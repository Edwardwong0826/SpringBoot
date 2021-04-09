package com.test.springboot.controller;

import com.test.springboot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

// data response and content negotiation
// there is 15 type of return response support in spring
// content negotiation(browser default by request headers tell spring/server what kind of data can accept )
@Controller
public class ResponseTestController {

    // The response and type is handle via return value handlers by request mapping handler adapter
    // it will find what kind of methodHandler to use, in this case is response body method handler
    // and use interface MessageConverter to return the value

    // MessageConverter: see if support class convert to media type data
    // in this case the MessageConverter is MappingJackson2HttpMessage Converter to convert
    // object into JSON (use low level jackson - objectMapping) anything also can convert to JSON
    // example: canRead - JSON convert to person
    //        : canWrite - person convert to JSON
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson()
    {
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }
}
