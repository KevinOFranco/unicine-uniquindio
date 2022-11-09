package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.repositorios.CuponRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class cuponTest {

    @Autowired
    private CuponRepositorio cuponRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCupon(){

        Cupon cupon = new Cupon();
        cupon.setCodigo("a001");
        cupon.setDescripcion("20% de descuento");
        cupon.setCriterio("Evento");
        cupon.setFechaVencimiento(LocalDate.now());
        cuponRepositorio.save(cupon);
        Assertions.assertNotNull(cuponRepositorio.buscarCuponId("a001"));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarCuponId(){

        Cupon cupon = cuponRepositorio.buscarCuponId("1");
        Assertions.assertNotNull(cupon);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCuponId(){

        cuponRepositorio.actualizarCupon("UnCriterio", "UnaDec", "1");
        Cupon cupon = cuponRepositorio.buscarCuponId("1");
        Assertions.assertEquals(cupon.getCriterio(), "unCriterio");
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCupon(){

        cuponRepositorio.eliminarCupon("1");
        Cupon cupon = cuponRepositorio.buscarCuponId("1");
        Assertions.assertNull(cupon);
    }
}
