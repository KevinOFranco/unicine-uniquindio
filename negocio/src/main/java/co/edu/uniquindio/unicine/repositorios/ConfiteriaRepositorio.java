package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiteriaRepositorio extends JpaRepository<Confiteria, Long> {
}
