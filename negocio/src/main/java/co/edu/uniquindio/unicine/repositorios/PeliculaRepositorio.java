package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {

    //R3, R9
    @Query("select p from Pelicula p where p.nombre = :nombre")
    Pelicula obtenerPorNombre(String nombre);



    @Query("select p from Pelicula p where p.id = :id")
    Pelicula obtenerPorId(long id);

    //R9
    @Transactional
    @Modifying
    @Query("update Pelicula set nombre = :nombre where id = :id")
    void actualizarPelicula(String nombre, long id);

    @Transactional
    @Modifying
    @Query("delete from Pelicula where id = :id")
    void borrarPelicula(long id);

    //R15
    @Query("select p from Pelicula p")
    List<Pelicula> listarPeliculas();
}