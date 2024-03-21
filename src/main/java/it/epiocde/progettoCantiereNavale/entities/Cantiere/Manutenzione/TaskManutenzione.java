package it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TaskManutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;
    private String dettagli;
    private boolean completato;


}
