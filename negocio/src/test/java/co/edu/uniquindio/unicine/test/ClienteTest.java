package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){
        Long guardado = clienteRepositorio.verificarCliente("ana@email.com", "ana123");
        Assertions.assertEquals(2, guardado);
    }
    @Test
    public void eliminar(){

        clienteRepositorio.eliminarCliente(1);
        long id = 1;
        Assertions.assertNull(clienteRepositorio.findById(id).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Cliente> clientes = clienteRepositorio.listarClientes();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPorCorreo(){
        Cliente cliente = clienteRepositorio.obtener("juan@email.com");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarLogin(){
        Cliente cliente = clienteRepositorio.comprobarLogin("michael", "1234");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginador(){
        List<Cliente> clientes = clienteRepositorio.findAll(PageRequest.of(0,2)).toList();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarPasswod(){

        String newPassword = "1234";
        String confirm = "1234";
        if (newPassword.equals(confirm)){ //Simulacion de confirmacion
            clienteRepositorio.recuperarPassword(newPassword, "juan@email.com");
            Assertions.assertEquals(clienteRepositorio.obtener("juan@email.com").getPassword(), newPassword);
        }
        Assertions.assertNotEquals(newPassword, clienteRepositorio.obtener("juan@email.com"));
    }
}