package com.interceptor.webservice.controller;

import com.interceptor.webservice.config.interceptor.RestInterceptor;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechWorkController {

    @GetMapping("tech")
    public ResponseEntity<Object> changeTechWorkStatus(@PathParam("status") Boolean status) {
        RestInterceptor.changeTechnicalWorkStatus(status);
        return ResponseEntity.ok().build();
    }
}
