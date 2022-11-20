package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.EnviarEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EnviarEmail enviarEmail;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest(){
        Cliente cliente = Cliente.builder().username("Joha").cedula("6").fechaNacimiento(LocalDate.now()).nombre("Johana").email("johana@email.com").password("johana123").build();
        try {
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest (){

        try{
            long id = 1;
            Cliente cliente = clienteServicio.obtenerCliente(id);
            cliente.setNombre("Lucas");
            Cliente nuevo = clienteServicio.actualizarCliente(cliente);
            Assertions.assertEquals("Lucas", nuevo.getNombre());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest(){

        long id = 1;
        try {
            clienteServicio.eliminarCliente(id);
            Cliente eliminado = clienteServicio.obtenerCliente(id);
            Assertions.assertNull(eliminado);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ingresarClienteTest(){
        try {
            Cliente nuevo = clienteServicio.loguear("ana@email.com", "ana123");
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarCorreoPrueba(){
        enviarEmail.enviarEmail("Prube de correo","Hola, esto es una prueba", "kevino.francob@uqvirtual.edu.co");
    }
}
