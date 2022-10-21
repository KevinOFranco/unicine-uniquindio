package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Sql ("classpath:dataset.sql")
    public void registrar(){
        Long guardado = clienteRepositorio.verificarCliente("ana@email.com", "ana123");

        Assertions.assertEquals(2, guardado);
    }
    @Test
    public void eliminar(){

    }

    public void actualizar(){

    }

    public void obtener(){

    }

    public void listar(){

    }
}
