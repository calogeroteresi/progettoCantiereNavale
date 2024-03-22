package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.Notification;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.NotificationRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        try {
            Notification notification = notificationService.getNotificationById(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationRequest notificationRequest) {
        Notification createdNotification = notificationService.createNotification(notificationRequest);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody NotificationRequest notificationRequest) {
        try {
            Notification updatedNotification = notificationService.updateNotification(id, notificationRequest);
            return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        try {
            notificationService.deleteNotification(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
