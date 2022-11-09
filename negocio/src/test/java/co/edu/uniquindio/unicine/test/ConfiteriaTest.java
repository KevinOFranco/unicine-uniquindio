package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.repositorios.ConfiteriaRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConfiteriaTest {

    @Autowired
    private ConfiteriaRepositorio confiteriaRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearConfiteria(){
        Confiteria confiteria = new Confiteria();
        long id = 5;
        confiteria.setId(id);
        confiteria.setTitulo("Nachos");
        confiteria.setPrecio(12.3);
        confiteria.setImagen("nachos.jpg");
        confiteria.setDescripcion("Nachos con queso");
        confiteriaRepositorio.save(confiteria);
        Assertions.assertNotNull(confiteriaRepositorio.buscarConfiteriaId(id));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConfiteria(){

        List<Confiteria> confiterias = confiteriaRepositorio.listarConfiteria();
        Assertions.assertNotNull(confiterias);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarConfiteria(){

        long id = 1;
        confiteriaRepositorio.actualizarConfiteria("nachos.png", 12.5, id);
        Confiteria confiAux = confiteriaRepositorio.buscarConfiteriaId(id);
        Assertions.assertEquals(confiAux.getPrecio(), 12.5);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConfiteria(){

        long id = 1;
        confiteriaRepositorio.eliminarConfiteria(id);
        Confiteria confiteria = confiteriaRepositorio.buscarConfiteriaId(id);
        Assertions.assertNull(confiteria);
    }
}
