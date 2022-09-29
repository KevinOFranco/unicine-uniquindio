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
public class Ciudad  implements Serializable {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String departamento;
    private String nombre;

}
