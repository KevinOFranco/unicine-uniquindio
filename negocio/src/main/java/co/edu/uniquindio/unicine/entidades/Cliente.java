package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {
    private String username;
    private String imagenPerfil;


}
