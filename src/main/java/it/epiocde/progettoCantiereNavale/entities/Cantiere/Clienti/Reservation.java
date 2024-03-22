package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;


import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.DockAvailability;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataPrenotazione;
    private Date dataInizio;
    private Date dataFine;
    private boolean confermata;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dock_availability_id")
    private DockAvailability dockAvailability;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;
}
