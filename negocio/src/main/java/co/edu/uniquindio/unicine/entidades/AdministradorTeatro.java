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
public class AdministradorTeatro extends Persona implements Serializable {

    @OneToMany (mappedBy = "administradorTeatro")
    private List<Teatro> teatros;
}
