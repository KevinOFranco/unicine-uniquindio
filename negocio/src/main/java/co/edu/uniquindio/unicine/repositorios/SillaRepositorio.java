package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillaRepositorio extends JpaRepository<Silla, Long> {
}
