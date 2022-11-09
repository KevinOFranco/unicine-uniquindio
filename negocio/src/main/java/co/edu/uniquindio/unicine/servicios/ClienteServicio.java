package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteServicio {
    Cliente loguear(String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(Long codigoCliente) throws Exception;

    List<Cliente> listarClientes();

    List<Cliente> listrarHistorial(Long codigoCliente);

    Compra hacerCompra(Compra compra);

    boolean redimirCupon (String codigoCupon);


}
