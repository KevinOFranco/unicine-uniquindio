package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.CuponCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponClienteRepositorio extends JpaRepository<CuponCliente, Long> {
}
