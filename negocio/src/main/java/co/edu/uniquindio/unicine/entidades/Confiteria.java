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
public class Confiteria  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    private String titulo;
    @Column (nullable = false)
    private String descripcion;
    @Column (nullable = false)
    @PositiveOrZero
    private Double precio;
    @Column (nullable = false)
    private String imagen;

    @OneToMany (mappedBy = "confiteria")
    @ToString.Exclude
    private List<CompraConfiteria> confiterias;

    @Builder
    public Confiteria(String titulo, String descripcion, Double precio, String imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }
}
