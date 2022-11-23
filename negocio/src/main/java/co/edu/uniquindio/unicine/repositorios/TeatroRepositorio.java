package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepositorio extends JpaRepository<Teatro, Long> {

    @Query("select t from Teatro t where t.ciudad.id = :ciudadId")
    List<Teatro> obtenerTeatrosPorCiudad(Long ciudadId);
}
