package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.MedioPago;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import co.edu.uniquindio.unicine.repositorios.CompraRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {
    @Autowired
    private CompraRepositorio compraRepositorio;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprar(){
        Compra nuevaCompra = new Compra();
        long id = 12;
        nuevaCompra.setId(id);
        nuevaCompra.setFecha(LocalDateTime.now());
        nuevaCompra.setMedioPago(MedioPago.PSE);
        compraRepositorio.save(nuevaCompra);
        Compra compraAux = compraRepositorio.obtenerCompraId(id);
        Assertions.assertNotNull(compraAux);
    }
}