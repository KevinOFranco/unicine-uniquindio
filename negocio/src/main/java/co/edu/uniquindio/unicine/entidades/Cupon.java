package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Cupon  implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String criterio;
    private String descripcion;
    @Column (nullable = false)
    @PositiveOrZero
    private Byte porcentajeDescuento;
    @Column (nullable = false)
    private LocalDate fechaVencimiento;

    @OneToMany (mappedBy = "cupon")
    private List<CuponCliente> cuponClientes;
}
