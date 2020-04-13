package org.example.service.consumer;

import org.example.model.Notification;
import org.example.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationImplService implements ImplService<Notification> {

    private NotificationRepository notificationRepository;

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> findAll() {
        return this.notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(String id) {
        return this.notificationRepository.findById(id);
    }
}
