package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.repositorios.FuncionRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {
    @Autowired
    FuncionRepositorio funcionRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFunciones(){
        List<Funcion> funciones = funcionRepositorio.findAll();

        funciones.forEach(o -> System.out.println(o.getPelicula().getNombre()));
    }
}
