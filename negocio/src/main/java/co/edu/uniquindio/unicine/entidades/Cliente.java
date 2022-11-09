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
public class Cliente extends Persona implements Serializable {
    private String username;
    private String imagenPerfil;

    @OneToMany (mappedBy = "cliente")
    @ToString.Exclude
    private List<Compra> compras;

    @OneToMany (mappedBy = "cliente")
    @ToString.Exclude
    private List<CuponCliente> cuponCliente;

    @OneToMany (mappedBy = "cliente")
    @ToString.Exclude
    private List<PeliculaFavorita> peliculaFavoritas;

    @Builder
    public Cliente(Long id, String nombre, String cedula, @Email String email, String password, LocalDate fechaNacimiento, Map<String, String> telefono, String username, String imagenPerfil) {
        super(id, nombre, cedula, email, password, fechaNacimiento, telefono);
        this.username = username;
        this.imagenPerfil = imagenPerfil;
    }

    @Builder
    public Cliente(String nombre, String cedula, @Email String email, String password, LocalDate fechaNacimiento) {
        super(nombre, cedula, email, password, fechaNacimiento);
    }
    @Builder
    public Cliente(String nombre, String cedula, @Email String email, String password, LocalDate fechaNacimiento, Map<String, String> telefono) {
        super(nombre, cedula, email, password, fechaNacimiento, telefono);
    }
}
