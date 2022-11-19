package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import org.springframework.stereotype.Service;

@Service
public class AdminServicioImplementacion implements AdminServicio{
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
        return null;
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
