package org.example.controller.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Notification;
import org.example.service.consumer.NotificationImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private NotificationImplService notificationService;

    @Autowired
    public void setNotificationService(NotificationImplService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        List<Notification> notifications = this.notificationService.findAll();
        return ResponseEntity
                .ok(notifications);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notification>> getById(@PathVariable String id) {
        log.info("fetching notification with id {}", id);
        Optional<Notification> notification = this.notificationService.findById(id);
        if (notification.isEmpty()) {
            log.error("notification with id {} not found.", id);
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity
                .ok(notification);
    }
}
