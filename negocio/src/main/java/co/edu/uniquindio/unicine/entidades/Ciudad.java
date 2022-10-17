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
public class Ciudad  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    private String departamento;
    @Column (nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Teatro> teatros;

    @Builder

    public Ciudad(String departamento, String nombre) {
        this.departamento = departamento;
        this.nombre = nombre;
    }
}
