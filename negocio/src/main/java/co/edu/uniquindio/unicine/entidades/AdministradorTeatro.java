package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdministradorTeatro extends Persona implements Serializable {

    @OneToMany (mappedBy = "administradorTeatro")
    private List<Teatro> teatros;
    @Builder
    public AdministradorTeatro(String nombre, String cedula, @Email String email, String password, LocalDate fechaNacimiento, Map<String, String> telefono, List<Teatro> teatros) {
        super(nombre, cedula, email, password, fechaNacimiento, telefono);
        this.teatros = teatros;
    }
}
