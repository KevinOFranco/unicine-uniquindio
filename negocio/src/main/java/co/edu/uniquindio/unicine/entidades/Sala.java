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
public class Sala  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    private Teatro teatro;

    @OneToMany (mappedBy = "sala")
    @ToString.Exclude
    private List<Funcion> funciones;

    @OneToMany (mappedBy = "sala")
    @ToString.Exclude
    private List<Silla> sillas;

    @Builder

    public Sala(Teatro teatro) {
        this.teatro = teatro;
    }
}
