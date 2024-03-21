package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer_feedback")
public class CustomerFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commento;
    private int valutazione;
    private Date dataFeedback;
}
