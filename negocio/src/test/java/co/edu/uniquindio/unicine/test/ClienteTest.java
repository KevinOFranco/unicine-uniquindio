package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void registrar(){
        LocalDate fecha = LocalDate.now();
        Cliente cliente = new Cliente("Juan", "123", "a@a.com", "pass", fecha);
        Cliente guardado = clienteRepositorio.save(cliente);

        Assertions.assertEquals("123", guardado.getCedula());
    }

    public void eliminar(){

    }

    public void actualizar(){

    }

    public void obtener(){

    }

    public void listar(){

    }
}
