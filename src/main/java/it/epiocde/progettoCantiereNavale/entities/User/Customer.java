package it.epiocde.progettoCantiereNavale.entities.User;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Reservation;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Review;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Customer extends User {
    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @OneToMany(mappedBy = "customer")
    private List<CustomerFeedback> customerFeedbacks;

    @OneToMany(mappedBy = "customer")
    private List<OrderCustomer> orders;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @OneToMany(mappedBy = "customer")
    private List<FatturaCliente> fatture;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Ship> ships;
}
