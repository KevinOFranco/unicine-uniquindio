package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepositorio;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTeatroTest {

    @Autowired
    private AdministradorTeatroRepositorio administradorTeatroRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdminTeatro(){

        List<AdministradorTeatro> administradores = administradorTeatroRepositorio.listarAdminTeatro();
        Assertions.assertNotNull(administradores);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdminId(){

        AdministradorTeatro admin = administradorTeatroRepositorio.obtenerAdminPorId(1);
        Assertions.assertNotNull(admin);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdmin(){

        String nuevoNombre = "Alejandro";
        administradorTeatroRepositorio.actualizarAdmin(nuevoNombre, 1);
        Assertions.assertEquals(administradorTeatroRepositorio.obtenerAdminPorId(1).getNombre(), nuevoNombre);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void borrarAdmin(){

        long idAdminTeatro = 1;
        administradorTeatroRepositorio.eliminarAdminteatro(idAdminTeatro);
        Assertions.assertNull(administradorTeatroRepositorio.obtenerAdminPorId(idAdminTeatro));
    }
}