package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class PeliculaFavorita  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Pelicula pelicula;
    @ManyToOne
    private Cliente cliente;

    @Builder

    public PeliculaFavorita(Pelicula pelicula, Cliente cliente) {
        this.pelicula = pelicula;
        this.cliente = cliente;
    }
}
