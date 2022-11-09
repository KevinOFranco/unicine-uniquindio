package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Estado;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    //Gestion peliculas --------------------------------------------------------------
    @Test
    @Sql("classpath:dataset.sql")
    public void crearPelicula(){
        Pelicula pelicula = new Pelicula();
        long id = 6;
        pelicula.setId(id);
        pelicula.setNombre("La momia");
        pelicula.setEstado(Estado.Cartelera);
        pelicula.setGenero(Genero.TERROR);
        pelicula.setImagen("momia.jpg");
        peliculaRepositorio.save(pelicula);
        Pelicula peliculaAux = peliculaRepositorio.obtenerPorNombre("La momia");
        Assertions.assertNotNull(peliculaAux);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaPorNombre(){

        Pelicula pelicula = peliculaRepositorio.obtenerPorNombre("Avatar");
        Assertions.assertNotNull(pelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPelicula(){

        String nuevoNombre = "Batman";
        peliculaRepositorio.actualizarPelicula(nuevoNombre, 1);
        Assertions.assertEquals(nuevoNombre, peliculaRepositorio.obtenerPorId(1).getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculas(){

        List<Pelicula> peliculas = peliculaRepositorio.listarPeliculas();
        peliculas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void borrarPelicula(){

        peliculaRepositorio.borrarPelicula(1);
        Assertions.assertNull(peliculaRepositorio.obtenerPorId(1));
    }
}