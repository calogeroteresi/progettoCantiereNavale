package it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dettagli_acquisti")
public class DettaglioAcquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ricevuta_id")
    private Ricevuta ricevuta;

    private String nomeMateriale;
    private int quantita;
    private double prezzoUnitario;

    @Enumerated(EnumType.STRING)
    private TipoArticolo tipo;
}
