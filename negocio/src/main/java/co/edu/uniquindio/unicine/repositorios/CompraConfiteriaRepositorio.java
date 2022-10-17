package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.CompraConfiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraConfiteriaRepositorio extends JpaRepository<CompraConfiteria, Long> {
}
