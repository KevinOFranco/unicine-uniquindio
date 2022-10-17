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
public class Entrada  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne
    private Silla silla;

    @ManyToOne
    private Funcion funcion;
    @ManyToOne
    private Compra compra;

    @Builder

    public Entrada(Silla silla, Funcion funcion) {
        this.silla = silla;
        this.funcion = funcion;
    }
}
