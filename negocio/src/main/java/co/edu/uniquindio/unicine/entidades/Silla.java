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
public class Silla  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    private String ubicacion;

    @OneToOne (mappedBy = "silla")
    private Entrada entrada;

    @ManyToOne
    private Sala sala;

    @Builder

    public Silla(String ubicacion, Sala sala) {
        this.ubicacion = ubicacion;
        this.sala = sala;
    }
}
