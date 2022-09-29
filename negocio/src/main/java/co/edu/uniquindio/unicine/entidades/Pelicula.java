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
public class Pelicula  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nombre;
    @Enumerated (EnumType.STRING)
    private Genero genero;
    private String sinopsis;
    private String reparto;
    private String trailer;
    @Enumerated (EnumType.STRING)
    private Estado estado;
    private String imagen;
}
