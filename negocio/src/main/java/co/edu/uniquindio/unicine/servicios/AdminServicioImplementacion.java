package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.AdministradorTeatroRepositorio;
import co.edu.uniquindio.unicine.repositorios.ConfiteriaRepositorio;
import co.edu.uniquindio.unicine.repositorios.CuponRepositorio;
import co.edu.uniquindio.unicine.repositorios.PeliculaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicioImplementacion implements AdminServicio{

    private final AdministradorTeatroRepositorio administradorTeatroRepositorio;
    private final PeliculaRepositorio peliculaRepositorio;

    private final CuponRepositorio cuponRepositorio;
    private final ConfiteriaRepositorio confiteriaRepositorio;

    public AdminServicioImplementacion(AdministradorTeatroRepositorio administradorTeatroRepositorio, PeliculaRepositorio peliculaRepositorio, CuponRepositorio cuponRepositorio, ConfiteriaRepositorio confiteriaRepositorio) {
        this.administradorTeatroRepositorio = administradorTeatroRepositorio;
        this.peliculaRepositorio = peliculaRepositorio;
        this.cuponRepositorio = cuponRepositorio;
        this.confiteriaRepositorio = confiteriaRepositorio;
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
        peliculaRepositorio.deleteById(idPelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        return null;
    }

    @Override
    public Pelicula obtenerPelicula(long idPelicula) throws Exception {
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        if (pelicula.isEmpty())
            throw new Exception("No se ha encontrado el administrador de teatro con ID:" + idPelicula);
        return pelicula.get();
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
        return confiteriaRepositorio.save(confiteria);
    }

    @Override
    public void eliminarConfiteria(long idConfiteria) {
        confiteriaRepositorio.deleteById(idConfiteria);
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
        return cuponRepositorio.save(cupon);
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

    @Override
    public List<Confiteria> listarConfiteria() {
        return confiteriaRepositorio.findAll();
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepositorio.listarPeliculas();
    }

    @Override
    public List<Cupon> listarCupones() {
        return cuponRepositorio.findAll();
    }

    @Override
    public List<Pelicula> obtenerPeliculasSimilares(String resultado) {
        return peliculaRepositorio.obtenerPeliculasSimilares(resultado);
    }

}
