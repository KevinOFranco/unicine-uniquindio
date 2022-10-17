package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.PeliculaFavorita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaFavoritaRepositorio extends JpaRepository<PeliculaFavorita, Long> {
}
