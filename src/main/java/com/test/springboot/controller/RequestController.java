package com.test.springboot.controller;

import com.test.springboot.exception.UserExceedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request)
    {
        request.setAttribute("msg","success...");
        request.setAttribute("code",200);
        return "forward:/success"; //转发到 /success 请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code,
                          HttpServletRequest request)
    {
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        if(map.size()>2)
        {
            throw new UserExceedException();
        }

        return map;
    }

    // Map, Model and HttpServletRequest also can put data into HttpServletRequest
    // Cookie can set browser cookie data
    @GetMapping("/params")
    public String testParam(Map<String,Object> map, Model model, HttpServletRequest request, HttpServletResponse reponse)
    {
        map.put("hello", "world666");
        model.addAttribute("world","hello666");
        request.setAttribute("message", "HelloWorld!");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        reponse.addCookie(cookie);
        return "forward:/success";
    }

}
