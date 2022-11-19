package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

public interface AdminServicio {

    Administrador login(String correo, String password) throws Exception;
    //CRUD ADMIN TEATRO
    AdministradorTeatro crearAdminTeatro(AdministradorTeatro adminTeatro) throws Exception;

    void eliminarAdminTeatro(long idAdmin) throws Exception;

    AdministradorTeatro actualizarAdminTeatro(AdministradorTeatro adminTeatro) throws Exception;

    AdministradorTeatro obtenerAdminTeatro(long idAdmin) throws Exception;

    //CRUD PELICULAS
    Pelicula crearPelicula(Pelicula pelicula) throws Exception;

    void eliminarPelicula(long idPelicula) throws Exception;

    Pelicula actualizarPelicula(Pelicula pelicula) throws Exception;

    Pelicula obtenerPelicula(long idPelicula) throws Exception;

    //CRUD CONFITERIA
    Confiteria crearConfiteria(Confiteria confiteria);

    void eliminarConfiteria(long idConfiteria);

    Confiteria actualizarConfiteria(Confiteria confiteria);

    Confiteria obtenerConfiteria(long id);

    //CRUD CUPONES
    Cupon crearCupon(Cupon cupon);

    void eliminarCupon(String codigoCupon);

    Cupon actualizarCupon(Cupon cupon);

    Cupon obtenerCupon(String codigoCupon);
}
