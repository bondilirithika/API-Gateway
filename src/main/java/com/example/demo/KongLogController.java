package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KongLogController {

    @PostMapping("/kong-logs")
    public ResponseEntity<Void> receiveLog(@RequestBody Map<String, Object> log) {
        System.out.println("🔵 Kong Log Received:");
        log.forEach((k, v) -> System.out.println(k + ": " + v));
        return ResponseEntity.ok().build();
    }
}


