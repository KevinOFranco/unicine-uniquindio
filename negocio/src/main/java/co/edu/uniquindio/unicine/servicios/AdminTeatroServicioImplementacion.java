package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repositorios.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTeatroServicioImplementacion implements AdminTeatroServicio{

    private final AdministradorTeatroRepositorio administradorTeatroRepositorio;
    private final TeatroRepositorio teatroRepositorio;
    private final SalaRepositorio salaRepositorio;
    private final FuncionRepositorio funcionRepositorio;
    private final CiudadRepositorio ciudadRepositorio;

    public AdminTeatroServicioImplementacion(AdministradorTeatroRepositorio administradorTeatroRepositorio, TeatroRepositorio teatroRepositorio, SalaRepositorio salaRepositorio, FuncionRepositorio funcionRepositorio, CiudadRepositorio ciudadRepositorio) {
        this.administradorTeatroRepositorio = administradorTeatroRepositorio;
        this.teatroRepositorio = teatroRepositorio;
        this.salaRepositorio = salaRepositorio;
        this.funcionRepositorio = funcionRepositorio;
        this.ciudadRepositorio = ciudadRepositorio;
    }

    @Override
    public AdministradorTeatro login(String email, String clave) throws Exception {

        AdministradorTeatro adminTeatro = administradorTeatroRepositorio.login(email, clave);
        if (adminTeatro == null)
            throw new Exception("Los datos de acceso son incorrectos");
        return adminTeatro;
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) throws Exception {
        return teatroRepositorio.save(teatro);
    }

    @Override
    public void eliminarTeatro(long idTeatro) throws Exception {
        Optional<Teatro> teatro = teatroRepositorio.findById(idTeatro);
        if(teatro.isEmpty())
            throw new Exception("Este teatro no existe.");
        teatroRepositorio.deleteById(idTeatro);
    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {

        Optional<Teatro> teatroAux = teatroRepositorio.findById(teatro.getId());
        if (teatroAux.isEmpty())
            throw new Exception("Este teatro no existe.");
        return teatroRepositorio.save(teatro);
    }

    @Override
    public Teatro obtenerTeatro(long idTeatro) throws Exception {

        Optional<Teatro> teatro = teatroRepositorio.findById(idTeatro);
        if (teatro.isEmpty())
            throw new Exception("No se ha encontrado el teatro con ID:" + idTeatro);
        return teatro.get();
    }

    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepositorio.findAll();
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) throws Exception {

        return funcionRepositorio.save(funcion);
    }

    @Override
    public void eliminarFuncion(long idFuncion) throws Exception {
        Optional<Funcion> funcion = funcionRepositorio.findById(idFuncion);
        if (funcion.isEmpty())
            throw new Exception("Esta funcion no existe.");
        funcionRepositorio.deleteById(idFuncion);
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {

        Optional<Funcion> funcionAux = funcionRepositorio.findById(funcion.getId());
        if(funcionAux.isEmpty())
            throw new Exception("Esta funcion no existe");
        return funcionRepositorio.save(funcion);
    }

    @Override
    public List<Funcion> listarFunciones() {
        return funcionRepositorio.findAll();
    }

    @Override
    public Funcion obtenerFuncion(long idFuncion) throws Exception {

        Optional<Funcion> funcion = funcionRepositorio.findById(idFuncion);
        if (funcion.isEmpty())
            throw new Exception("No se ha encontrado la funcion con ID:" + idFuncion);
        return funcion.get();
    }

    @Override
    public Sala crearSala(Sala sala) throws Exception {
        return salaRepositorio.save(sala);
    }

    @Override
    public void eliminarSala(int idSala) throws Exception {

        Optional<Sala> salaAux = salaRepositorio.findById(idSala);
        if (salaAux.isEmpty())
            throw new Exception("Esta sala no existe.");
        salaRepositorio.deleteById(idSala);
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {

        Optional<Sala> salaAux = salaRepositorio.findById(sala.getId());
        if (salaAux.isEmpty())
            throw new Exception("Esta sala no existe.");
        return salaRepositorio.save(sala);
    }

    @Override
    public Sala obtenerSala(int idSala) throws Exception {

        Optional<Sala> sala = salaRepositorio.findById(idSala);
        if (sala.isEmpty())
            throw new Exception("No se ha encontrado la sala con ID:" + idSala);
        return sala.get();
    }

    @Override
    public List<Sala> listarSalas() {
        return salaRepositorio.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Long idCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepositorio.findById(idCiudad);
        if (ciudad.isEmpty())
            throw new Exception("No se ha encontrado la ciudad con ID:" + idCiudad);
        return ciudad.get();
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepositorio.findAll();
    }
}
