package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeliculaServicioImplementacion implements PeliculaServicio{

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) throws Exception {
        return peliculaRepositorio.save(pelicula);
    }
}
