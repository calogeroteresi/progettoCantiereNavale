package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;

import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order_customer")
public class OrderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataOrdine;
    private double importoTotale;

    @OneToMany(mappedBy = "orderCustomer")
    private List<FatturaCliente> fatture;


    @ManyToMany
    @JoinTable(
            name = "order_service_offering",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "service_offering_id")
    )
    private List<ServiceOffering> serviceOfferings;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
