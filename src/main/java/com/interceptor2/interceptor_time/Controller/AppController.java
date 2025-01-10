package com.interceptor2.interceptor_time.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/holis")
    public ResponseEntity<?> init(){

        Map<String, Object> holisMap= new HashMap<>();
        holisMap.put("saludo","Bienvenidos lcdsm");
        holisMap.put("hora",new Date());

        return ResponseEntity.ok(holisMap);
    }
}
