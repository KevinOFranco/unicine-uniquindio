package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repositorios.ClienteRepositorio;
import co.edu.uniquindio.unicine.repositorios.CompraRepositorio;
import co.edu.uniquindio.unicine.repositorios.CuponRepositorio;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImplementacion implements ClienteServicio{

    private ClienteRepositorio clienteRepositorio;
    private EnviarEmail enviarEmail;
    private CompraRepositorio compraRepositorio;
    private PeliculaRepositorio peliculaRepositorio;
    private CuponRepositorio cuponRepositorio;

    public ClienteServicioImplementacion(ClienteRepositorio clienteRepositorio, EnviarEmail enviarEmail, CompraRepositorio compraRepositorio, PeliculaRepositorio peliculaRepositorio, CuponRepositorio cuponRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.enviarEmail = enviarEmail;
        this.compraRepositorio = compraRepositorio;
        this.peliculaRepositorio = peliculaRepositorio;
        this.cuponRepositorio = cuponRepositorio;
    }

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
    public void recuperarClave(String clave, String claveConfirm, String email) throws Exception {

        if (clave != claveConfirm)
            throw new Exception("Las claves no coinciden.");
        clienteRepositorio.recuperarPassword(clave, email);
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
    public void eliminarCliente(long codigoCliente) throws Exception {
        Optional<Cliente> cliente = clienteRepositorio.findById(codigoCliente);
        if (cliente.isEmpty())
            throw new Exception("No existe el cliente");
        clienteRepositorio.deleteById(codigoCliente);
    }

    @Override
    public List<Compra> listarHistorial(long codigoCliente) {

        return clienteRepositorio.obtenerComprasRealizadas(codigoCliente);
    }

    @Override
    public Compra hacerCompra(Compra compra) {

        return compraRepositorio.save(compra);
    }

    //PENDIENTE!!
    @Override
    public boolean redimirCupon(String codigoCupon) {

        return false;
    }

    @Override
    public Cliente obtenerCliente(long id) throws Exception {

        Optional<Cliente> clienteBuscado = clienteRepositorio.findById(id);
        if (clienteBuscado.isEmpty())
            throw new Exception("No se ha encontrado el cliente con ID:" + id);
        return clienteBuscado.get();
    }

    @Override
    public Pelicula buscarPelicula(String nombrePelicula) {
        Pelicula pelicula = peliculaRepositorio.obtenerPorNombre(nombrePelicula);
        return pelicula;
    }

    @Override
    public Compra realizarCompra(Compra compra) {

        return compraRepositorio.save(compra);
    }

    @Override
    public List<Compra> listarComprasRealizadas() {

        return compraRepositorio.findAll();
    }
}