package it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.enums.StatoFattura;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "fatture_clienti")
public class FatturaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFattura;
    private Date dataEmissione;
    private Double importoTotale;
    @Enumerated(EnumType.STRING)
    private StatoFattura stato;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderCustomer orderCustomer;

    @OneToMany(mappedBy = "fatturaCliente")
    private List<Pagamento> pagamenti;
}
