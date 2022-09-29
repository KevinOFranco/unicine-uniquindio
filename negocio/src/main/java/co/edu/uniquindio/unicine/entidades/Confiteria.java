package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Confiteria  implements Serializable {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String imagen;

}
