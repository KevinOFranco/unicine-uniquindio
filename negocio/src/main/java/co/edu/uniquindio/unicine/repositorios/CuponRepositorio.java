package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CuponRepositorio extends JpaRepository<Cupon, String> {

    @Query("select c from Cupon c")
    List<Cupon> listarCupones();
    @Query("select c from Cupon c where c.codigo = :idCupon")
    Cupon buscarCuponId(String idCupon);

    @Transactional
    @Modifying
    @Query("update Cupon c set c.criterio = :criterio, c.descripcion = :desc where c.codigo = :codigo")
    void actualizarCupon(String criterio, String desc, String codigo);

    @Transactional
    @Modifying
    @Query("delete from Cupon c where c.codigo = :codigo")
    void eliminarCupon(String codigo);

    //Borrar
    @Query("select cup from Cliente cli join cli.cuponCliente cup where cli.email = :email")
    List<Cupon> obtenerCuponesCorreo(String email);
}
