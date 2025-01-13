package com.interceptor2.interceptor_time.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {

    @GetMapping("/holis")
    public ResponseEntity<?> init(HttpServletRequest request){

        Map<String, Object> holisMap= new HashMap<>();
        holisMap.put("saludo","Bienvenidos lcdsm");
        holisMap.put("hora",new Date());
        holisMap.put("msg", request.getAttribute("msg"));

        return ResponseEntity.ok(holisMap);
    }
}
