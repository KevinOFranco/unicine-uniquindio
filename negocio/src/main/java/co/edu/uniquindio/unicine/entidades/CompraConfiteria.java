package co.edu.uniquindio.unicine.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class CompraConfiteria implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    @Positive
    private Integer unidades;
    @Column (nullable = false)
    @PositiveOrZero
    private Double precio;

    @ManyToOne
    private Compra compra;
    @ManyToOne
    private Confiteria confiteria;
}
