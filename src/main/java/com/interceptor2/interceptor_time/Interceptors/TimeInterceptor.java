package com.interceptor2.interceptor_time.Interceptors;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class TimeInterceptor implements HandlerInterceptor{

    @Value("${config.Open}")
    private Integer open;

    @Value("${config.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY); 
        System.out.println("hora del dia "+h);
        if(h>=open && h<close){
            StringBuilder msg = new StringBuilder("Aca estamos....en horario de atencion...asi que..");
            msg.append("holis...");
            msg.append(h);
            request.setAttribute("msg", msg.toString());
            return true;    
        }

            ObjectMapper om = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
            StringBuilder msg = new StringBuilder("Aca estamos....cerrando...asi que.. ");
            msg.append(" largate... ");
            msg.append(close);
            map.put("msg", msg.toString());
            response.setContentType("app/json");
            response.setStatus(401);
            response.getWriter().write(om.writeValueAsString(map));
            return false;
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    
    
}
