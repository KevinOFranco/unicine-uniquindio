package co.edu.uniquindio.unicine.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
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
}
