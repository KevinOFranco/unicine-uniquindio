package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteServicio {
    Cliente loguear(String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    void recuperarClave(String clave, String claveConfirm, String email) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(long codigoCliente) throws Exception;

    List<Compra> listarHistorial(long codigoCliente);

    Compra hacerCompra(Compra compra);

    boolean redimirCupon (String codigoCupon);

    Cliente obtenerCliente (long id) throws Exception;

    Pelicula buscarPelicula(String nombrePelicula);

    Compra realizarCompra(Compra compra);

    //REDIMIR CUPON PENDIENTE

    List<Compra> listarComprasRealizadas();

    List<Funcion> listarFuncionesPorPelicula(String nombrePelicula);

    Ciudad obtenerGenero(long parseLong);

    List<Pelicula> listarPeliculasPorEstado(Estado cartelera);

    List<Pelicula> listarPeliculasPorEstadoYCiudad(Estado cartelera, Long idCiudad);
}
