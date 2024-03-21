package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Fattura;
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

    @OneToMany(mappedBy = "order")
    private List<Fattura> fatture;

}
