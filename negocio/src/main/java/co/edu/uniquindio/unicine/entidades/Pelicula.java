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
public class Pelicula  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    @ElementCollection
    @Enumerated (EnumType.STRING)
    private List<Genero> genero;

    @Lob
    private String sinopsis;

    @Lob
    private String reparto;

    private String trailer;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Estado estado;

    @Column (nullable = false)
    private String imagen;

    @OneToMany (mappedBy = "pelicula")
    @ToString.Exclude
    private List<Funcion> funciones;

    @OneToMany (mappedBy = "pelicula")
    @ToString.Exclude
    private List<PeliculaFavorita> peliculaFavoritas;

    @Builder
    public Pelicula(String nombre, String sinopsis, String reparto, String trailer, Estado estado, String imagen) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.trailer = trailer;
        this.estado = estado;
        this.imagen = imagen;
    }
}
