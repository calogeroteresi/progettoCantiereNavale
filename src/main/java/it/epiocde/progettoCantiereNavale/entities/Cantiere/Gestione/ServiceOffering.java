package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Reservation;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "service_offerings")
public class ServiceOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String description;

    private Double price;

    @OneToMany(mappedBy = "serviceOffering")
    private List<IncidentReport> incidentReports;

    @OneToMany(mappedBy = "serviceOffering")
    private List<Notification> notifications;

    @ManyToMany
    @JoinTable(
            name = "order_service_offering",
            joinColumns = @JoinColumn(name = "service_offering_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderCustomer> orderCustomers;


    @OneToMany(mappedBy = "serviceOffering")
    private List<Reservation> reservations;


    @OneToMany(mappedBy = "serviceOffering")
    private List<CustomerFeedback> customerFeedbacks;

    @OneToMany(mappedBy = "serviceOffering")
    private List<Review> reviews;
}
