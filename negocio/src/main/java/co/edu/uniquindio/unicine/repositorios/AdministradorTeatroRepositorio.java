package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AdministradorTeatroRepositorio extends JpaRepository<AdministradorTeatro, Long> {

    @Query("select a from AdministradorTeatro a")
    List<AdministradorTeatro> listarAdminTeatro();

    @Query("select a from AdministradorTeatro a where a.id = :id")
    AdministradorTeatro obtenerAdminPorId(long id);

    @Transactional
    @Modifying
    @Query("update AdministradorTeatro set nombre = :nombre where id = :id")
    void actualizarAdmin(String nombre, long id);

    @Transactional
    @Modifying
    @Query("delete from AdministradorTeatro a where a.id = :idAminTeatro")
    void eliminarAdminteatro(long idAminTeatro);
}
