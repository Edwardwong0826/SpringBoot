package com.test.springboot.controller;

import com.test.springboot.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// using @RestContoller will automatically convert the response to JSON/XML , so no need explicitly add @ResponseBody in each request method
@RestController
public class ParameterTestController {

    /**
     * data binding: page sent request data(GET,POST) can be bind with object fields
     * @param person
     * @return
     */
    @GetMapping("/saveuser")
    public Person saveuser(Person person)
    {
        return person;
    }


    // the parameter is handled by the argument resolvers by request mapping handler adapter
    // there is 26 of type request argument can support in spring
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv, //must be string map for @PathVariable
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String,String> params,
                                      @CookieValue("_ga") CookieValue cookieValue)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv",pv);
        map.put("userAgent", userAgent);
        map.put("headers",header);

        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", cookieValue);

        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);

        return map;
    }
    // use ; in the path to indicate this is a matrix variable, and , when have many
    // 1. /cars/sell;low=34;brand=byd,audi,yd
    // 2. SpringBoot by default disabled usage of @MatrixVariable
    // 3. matrix variable need to have url path only can 解析
    // manual open : principle - for path handler, UrlPathHelper进行解析，
    // removeSemicolonContent
    @GetMapping("/cars/{path}")
    public Map carSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge)
    {

        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
