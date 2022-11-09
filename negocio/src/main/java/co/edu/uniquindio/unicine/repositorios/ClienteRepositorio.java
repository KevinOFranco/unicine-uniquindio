package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    //Borrar
    @Query("select cli.nombre, comp from Cliente cli left join cli.compras comp")
    List<Object[]> obtenerComprasClientes();

    @Query("select  c from Cliente c where c.email = ?1")
    Cliente obtener(String email);

    @Query("select  c from Cliente c where c.email = ?1")
    Optional<Cliente> verificarCorreo(String email);

    @Query("select c from Cliente c")
    List<Cliente> listarClientes();

    @Query("SELECT c.id FROM Cliente c WHERE c.email = :email AND c.password = :password")
    public long verificarCliente (String email, String password);

    @Query("select c from Cliente c where c.email = :correo and c.password = :password")
    Cliente comprobarLogin(String correo, String password);

    //R7
    @Transactional
    @Modifying
    @Query("update Cliente c set c.password = :newPassword where c.email = :email")
    void recuperarPassword(String newPassword, String email);

    @Transactional
    @Modifying
    @Query("delete from Cliente c where c.id = :id")
    void eliminarCliente(long id);

    @Query("select com from Cliente cli join cli.compras com where cli.id = :idCliente")
    List<Compra> obtenerComprasRealizadas(long idCliente);
}