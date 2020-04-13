package org.example.controller.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private String URI = "http://localhost:8080/api/v1/notifications/send/";

    @GetMapping("/redirect")
    public ResponseEntity<Void> redirect() {
        log.info("Event was triggered, redirect to " + URI);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, URI)
                .build();
    }
}