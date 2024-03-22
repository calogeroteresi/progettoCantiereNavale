package it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.Notification;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.NotificationRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepository;

    public Notification getNotificationById(Long id) throws NotFoundException {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.isEmpty()) {
            throw new NotFoundException("Notification not found with ID: " + id);
        }
        return optionalNotification.get();
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification createNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        mapNotificationRequestToEntity(notificationRequest, notification);
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, NotificationRequest notificationRequest) throws NotFoundException {
        Notification notification = getNotificationById(id);
        mapNotificationRequestToEntity(notificationRequest, notification);
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) throws NotFoundException {
        Notification notification = getNotificationById(id);
        notificationRepository.delete(notification);
    }

    private void mapNotificationRequestToEntity(NotificationRequest request, Notification entity) {
        entity.setMessage(request.getMessage());
        entity.setCreatedAt(request.getCreatedAt());
        // Aggiungi altre associazioni qui se necessario
    }
}
