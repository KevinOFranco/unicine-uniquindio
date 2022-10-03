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
public class Teatro  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String Direccion;

    @ManyToOne
    private Ciudad ciudad;
    @ManyToOne
    private AdministradorTeatro administradorTeatro;

    @OneToMany (mappedBy = "teatro")
    private List<Sala> salas;
}
