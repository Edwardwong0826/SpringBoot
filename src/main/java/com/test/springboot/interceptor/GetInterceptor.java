package com.test.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// interceptor need to be add/in IOC container
// according current request, find HandlerExecutionChain (those can handle and handler interceptor)
// based on sequence to execute all interceptor preHandle method
// 1. if current interceptor preHandle return true, only continue next preHandle
// 2. if current interceptor return false, direct triggerAfterCompletion method and
//    descending order execute all executed interceptor afterCompletion method
// 3. if any interceptor execute return false, directly step out, not invoke target method
// descending order execute all interceptor postHandler method
// above step got any exception will direct triggerAfterCompletion
public class GetInterceptor implements HandlerInterceptor {

    // target method before execution
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        return true;
    }

    // target method after execution
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    // target method finish execution
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
