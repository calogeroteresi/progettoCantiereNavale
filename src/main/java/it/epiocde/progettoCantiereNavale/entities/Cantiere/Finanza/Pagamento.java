package it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pagamenti")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metodoPagamento;
    private String statoPagamento;
    private Date dataPagamento;
    private Double importoPagato;

    @ManyToOne
    @JoinColumn(name = "fattura_cliente_id")
    private FatturaCliente fatturaCliente;

    @ManyToOne
    @JoinColumn(name = "fattura_fornitore_id")
    private FatturaFornitore fatturaFornitore;
}
