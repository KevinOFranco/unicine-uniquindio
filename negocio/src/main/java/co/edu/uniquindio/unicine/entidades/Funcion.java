package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Funcion  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    @PositiveOrZero
    private Double precio;

    @ManyToOne
    private Sala sala;
    @ManyToOne
    private Horario horario;
    @ManyToOne
    private Pelicula pelicula;

    @OneToMany (mappedBy = "funcion")
    @ToString.Exclude
    private List<Entrada> entradas;

    @Builder
    public Funcion(Double precio, Sala sala, Horario horario, Pelicula pelicula) {
        this.precio = precio;
        this.sala = sala;
        this.horario = horario;
        this.pelicula = pelicula;
    }
}
