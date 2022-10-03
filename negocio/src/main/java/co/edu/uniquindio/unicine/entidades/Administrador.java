package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

}
