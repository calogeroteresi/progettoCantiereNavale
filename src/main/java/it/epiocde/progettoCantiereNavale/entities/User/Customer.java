package it.epiocde.progettoCantiereNavale.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Customer extends User{
    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @Column(name = "tipo_cliente")
    private String tipoCliente;
}
