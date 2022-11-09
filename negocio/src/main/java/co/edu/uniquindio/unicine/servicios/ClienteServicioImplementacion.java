package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImplementacion implements ClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public Cliente loguear(String correo, String password) throws Exception{
        Cliente cliente = clienteRepositorio.comprobarLogin(correo, password);

        if (cliente == null){
            throw new Exception("Los datos son incorrectos");
        }

        return cliente;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        Optional<Cliente> clienteAux = clienteRepositorio.verificarCorreo(cliente.getEmail());
        if (!clienteAux.isEmpty()){
            throw new Exception("Correo ya registrado");
        }
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        Optional<Cliente> guardado = clienteRepositorio.findById(cliente.getId());

        if (guardado.isEmpty()){
            throw new Exception("No existe el cliente");
        }

        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Long codigoCliente) throws Exception {
        Optional<Cliente> guardado = clienteRepositorio.findById(codigoCliente);

        if (guardado.isEmpty()){
            throw new Exception("No existe el cliente");
        }

        clienteRepositorio.delete(guardado.get());
    }

    @Override
    public List<Cliente> listarClientes() {
        return null;
    }

    @Override
    public List<Cliente> listrarHistorial(Long codigoCliente) {
        return null;
    }

    @Override
    public Compra hacerCompra(Compra compra) {
        return null;
    }

    @Override
    public boolean redimirCupon(String codigoCupon) {
        return false;
    }
}