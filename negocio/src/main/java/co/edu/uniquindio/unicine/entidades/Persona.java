package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)//Comparte atributos de herencia
@MappedSuperclass //Hereda
@Getter
@Setter
@NoArgsConstructor //Constructor sin atributos
@AllArgsConstructor //Contructor con todos atributos
@ToString
@EqualsAndHashCode (onlyExplicitlyIncluded = true) //Define explicitamente atributos para equals
public class Persona implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Genera el id sin repetir
    @EqualsAndHashCode.Include
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column (unique = true, nullable = false)
    private String cedula;
    @Email //Compara que el email coincida
    @Column (unique = true, nullable = false) //El atributodebe ser unico y obligatorio
    private String email;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private LocalDate fechaNacimiento;
    @ElementCollection //Crea una tabla con la lista
    private Map<String,String> telefono;
}
