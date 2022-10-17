package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column (nullable = false)
    private LocalDateTime fecha;

    @OneToOne  (mappedBy = "compra")
    private CuponCliente cuponCliente;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private MedioPago medioPago;

    @ManyToOne
    private Cliente cliente;

    @OneToMany (mappedBy = "compra")
    @ToString.Exclude
    private List<Entrada> entradas;
    @OneToMany (mappedBy = "compra")
    @ToString.Exclude
    private List<CompraConfiteria> confiterias;

    @Builder

    public Compra(CuponCliente cuponCliente, MedioPago medioPago, Cliente cliente, List<Entrada> entradas, List<CompraConfiteria> confiterias) {
        this.fecha = LocalDateTime.now();
        this.cuponCliente = cuponCliente;
        this.medioPago = medioPago;
        this.cliente = cliente;
        this.entradas = entradas;
        this.confiterias = confiterias;
    }
}
