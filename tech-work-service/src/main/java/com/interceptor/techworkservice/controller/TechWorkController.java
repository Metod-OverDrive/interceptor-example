package com.interceptor.techworkservice.controller;

import com.interceptor.techworkservice.model.TechWorkMessage;
import com.interceptor.techworkservice.service.TechWorkService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class TechWorkController {

    private final TechWorkService techWorkService;

    @GetMapping
    public ResponseEntity<?> setTechWorkStatus(@PathParam("status") Boolean status) {
        if (status != null)
        {
            TechWorkMessage message = new TechWorkMessage();
            message.setStatus(status);
            message.setTime(LocalDateTime.now());
            techWorkService.sendTechWorkStatus(message);
            return ResponseEntity.ok(message);

        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

}
