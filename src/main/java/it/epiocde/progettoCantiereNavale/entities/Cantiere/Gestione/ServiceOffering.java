package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_offerings")
public class ServiceOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    private String descrizione;

    private Double prezzo ;

}
