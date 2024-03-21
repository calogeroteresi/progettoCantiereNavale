package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "security_logs")
@Data
public class SecurityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private String action;

    private String description;

}
