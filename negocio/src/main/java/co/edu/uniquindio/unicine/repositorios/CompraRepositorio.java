package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Long> {

    //borrar
    @Query("select c from Compra c join c.entradas e where c.id = :idCompra")
    List<Entrada> obtenerEntradas(Long idCompra);

    @Query("select c from Compra c where c.id = :idCompra")
    Compra obtenerCompraId(Long idCompra);
}
