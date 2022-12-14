package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

    @ElementCollection
    @Column (nullable = false)
    private Map<String, String> imagenes;

    @OneToMany (mappedBy = "pelicula")
    @ToString.Exclude
    private List<Funcion> funciones;

    @OneToMany (mappedBy = "pelicula")
    @ToString.Exclude
    private List<PeliculaFavorita> peliculaFavoritas;

    @Builder
    public Pelicula(String nombre, String sinopsis, String reparto, String trailer, Estado estado) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.trailer = trailer;
        this.estado = estado;
    }

    public String getImagenPrincipal (){
        if (!imagenes.isEmpty()){
            return imagenes.get(imagenes.keySet().toArray()[0].toString());
        }
        return "";
    }
}
