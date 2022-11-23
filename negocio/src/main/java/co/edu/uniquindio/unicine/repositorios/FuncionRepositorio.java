package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepositorio extends JpaRepository<Funcion, Long> {

    //No repite registros. Si una pelicula esta en 2 funciones sale 1 vez.
    @Query("select distinct f.pelicula from Funcion f")
    List<Pelicula> obtenerPeliculasEnFuncion();

    @Query("select f from Funcion f where f.pelicula.nombre = :nombrePelicula")
    List<Funcion> obtenerFuncionesPorPelicula(String nombrePelicula);

    @Query("select f from Funcion f where f.sala.teatro.ciudad.id = :ciudadId and f.pelicula.id = :peliculaId")
    List<Funcion> obtenerFuncionesPorCiudadYPelicula(Long ciudadId, Long peliculaId);
}