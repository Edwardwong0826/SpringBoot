package com.test.springboot.controller;

import com.test.springboot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

// data response and content negotiation
// there is 15 type of return response support in spring MVC
// content negotiation manager use content negotiation strategy to manage request, can by on header or others
// header content negotiation strategy(browser default by request headers tell spring/server what kind of data can accept )
@Controller
public class ResponseTestController {

    // The response and type is handle via return value handlers by request mapping handler adapter
    // it will find what kind of methodHandler to use, in this case is response body method handler
    // and use interface MessageConverter to return the value

    // MessageConverter: see if support class convert to media type data, there is 10 message converter for producible types
    //                 : it will get acceptable types from headers to iterate which message converter can match
    // in this case the MessageConverter is MappingJackson2HttpMessage Converter to convert
    // object into JSON (use low level jackson - objectMapping) anything also can convert to JSON
    // example: canRead - JSON convert to person
    //        : canWrite - person convert to JSON
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson()
    {
        // in the postman will return json by default due to accept header "/"
        // here will return xml because we want xml and weight is higher than json weight based on headers

        // If in browser want to change the return data type, need to use parameter content negotiation strategy
        // in application.properties need to enabled
        // spring.mvc.contentnegotiation.favor-parameter to true
        // http://localhost:8080/test/person?format=json or ?format=xml
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }
}
