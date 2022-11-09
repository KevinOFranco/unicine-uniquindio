package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConfiteriaRepositorio extends JpaRepository<Confiteria, Long> {

    @Query("select c from Confiteria c")
    List<Confiteria> listarConfiteria();

    @Query("select c from Confiteria c where c.id = :idConfiteria")
    Confiteria buscarConfiteriaId(long idConfiteria);

    @Transactional
    @Modifying
    @Query("update Confiteria c set c.imagen = :imagen, c.precio = :precio where c.id = :idConfiteria")
    void actualizarConfiteria(String imagen, double precio, long idConfiteria);

    @Transactional
    @Modifying
    @Query("delete from Confiteria c where c.id = :idConfiteria")
    void eliminarConfiteria(long idConfiteria);
}
