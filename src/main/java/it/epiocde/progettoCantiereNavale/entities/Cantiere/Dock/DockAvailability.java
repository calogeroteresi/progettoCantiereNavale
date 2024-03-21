package it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "docks_availability")
public class DockAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dock_id")
    private Dock dock;

    @Column(name = "posti_occupati")
    private int postiOccupati;

    @Column(name = "posti_disponibili")
    private int postiDisponibili;

    private boolean disponibile;

    @Column(name = "in_manutenzione")
    private boolean inManutenzione;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @Column(name = "riduzione_capacita_dovuta_manutenzione")
    private boolean riduzioneCapacitaDovutaAllaManutenzione;

    @Column(name = "capacita_ridotta")
    private int capacitaRidotta;
}
