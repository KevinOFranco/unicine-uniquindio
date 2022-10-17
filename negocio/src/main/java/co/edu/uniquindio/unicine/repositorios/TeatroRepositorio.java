package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeatroRepositorio extends JpaRepository<Teatro, Long> {
}
