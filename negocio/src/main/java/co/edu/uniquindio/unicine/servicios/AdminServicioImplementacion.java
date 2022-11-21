package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServicioImplementacion implements AdminServicio{

    private final AdministradorTeatroRepositorio administradorTeatroRepositorio;

    public AdminServicioImplementacion(AdministradorTeatroRepositorio administradorTeatroRepositorio) {
        this.administradorTeatroRepositorio = administradorTeatroRepositorio;
    }

    @Override
    public Administrador login(String correo, String password) throws Exception {
        return null;
    }

    @Override
    public AdministradorTeatro crearAdminTeatro(AdministradorTeatro adminTeatro) throws Exception {
        return null;
    }

    @Override
    public void eliminarAdminTeatro(long idAdmin) throws Exception {

    }

    @Override
    public AdministradorTeatro actualizarAdminTeatro(AdministradorTeatro adminTeatro) throws Exception {
        return null;
    }

    @Override
    public AdministradorTeatro obtenerAdminTeatro(long idAdmin) throws Exception {
        Optional<AdministradorTeatro> adminBuscado = administradorTeatroRepositorio.findById(idAdmin);
        if (adminBuscado.isEmpty())
            throw new Exception("No se ha encontrado el administrador de teatro con ID:" + idAdmin);
        return adminBuscado.get();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) throws Exception {
        return null;
    }

    @Override
    public void eliminarPelicula(long idPelicula) throws Exception {

    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        return null;
    }

    @Override
    public Pelicula obtenerPelicula(long idPelicula) throws Exception {
        return null;
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
        return null;
    }

    @Override
    public void eliminarConfiteria(long idConfiteria) {

    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) {
        return null;
    }

    @Override
    public Confiteria obtenerConfiteria(long id) {
        return null;
    }

    @Override
    public Cupon crearCupon(Cupon cupon) {
        return null;
    }

    @Override
    public void eliminarCupon(String codigoCupon) {

    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) {
        return null;
    }

    @Override
    public Cupon obtenerCupon(String codigoCupon) {
        return null;
    }
}
