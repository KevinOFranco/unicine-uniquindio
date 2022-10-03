package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Compra  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne  (mappedBy = "compra")
    private CuponCliente cuponCliente;

    @ManyToOne
    private Cliente cliente;

    @OneToMany (mappedBy = "compra")
    private List<Entrada> entradas;
    @OneToMany (mappedBy = "compra")
    private List<CompraConfiteria> confiterias;
}
