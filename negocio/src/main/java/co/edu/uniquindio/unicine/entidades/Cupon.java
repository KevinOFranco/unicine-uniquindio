package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;

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
    private String codigoCupon;
    @PositiveOrZero
    private Byte porcentajeDescuento;
    private LocalDate fechaVencimiento;

}
