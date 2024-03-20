package it.epiocde.progettoCantiereNavale.entities.Ship;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Caratteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ship", referencedColumnName = "id")
    private Ship ship;

    @ElementCollection
    @CollectionTable(name = "equipaggiamenti_elettrici")
    @Column(name = "equipaggiamento")
    private List<String> equipaggiamentiElettrici;

    @ElementCollection
    @CollectionTable(name = "elettronici")
    @Column(name = "elettronico")
    private List<String> elettronici;

    @ElementCollection
    @CollectionTable(name = "equipaggiamenti_interni")
    @Column(name = "equipaggiamento")
    private List<String> equipaggiamentiInterni;

    @ElementCollection
    @CollectionTable(name = "dotazioni_esterne")
    @Column(name = "dotazione")
    private List<String> dotazioniEsterne;

    @Column(name = "certificazione_ce")
    private String certificazioneCE;

    @Column(name = "cabine")
    private int cabine;

    @Column(name = "doppio_ancoraggio")
    private int doppioAncoraggio;

    @Column(name = "cuccette_doppie")
    private int cuccetteDoppie;

    @Column(name = "cuccette_singole")
    private int cuccetteSingole;

    @Column(name = "locale_wc_bagni")
    private int localeWCBagni;

    @Column(name = "numero_massimo_passeggeri")
    private int numeroMassimoPasseggeri;

    @Column(name = "posti_a_sedere")
    private int postiASedere;

    @Column(name = "serbatoio_acqua")
    private String serbatoioAcqua;

    @Column(name = "forma_scafo")
    private String formaScafo;

    @Column(name = "mulinello")
    private String mulinello;

    @Column(name = "garanzia_scafo")
    private String garanziaScafo;
}
