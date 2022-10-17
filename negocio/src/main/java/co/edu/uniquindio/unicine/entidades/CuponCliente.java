package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class CuponCliente implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne
    private Compra compra;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Cupon cupon;

    @Builder

    public CuponCliente(Compra compra, Cliente cliente, Cupon cupon) {
        this.compra = compra;
        this.cliente = cliente;
        this.cupon = cupon;
    }
}
