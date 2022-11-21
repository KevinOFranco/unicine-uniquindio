package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminTeatroServicio {

    AdministradorTeatro login(String email, String clave) throws Exception;

    //CRUD TEATROS
    Teatro crearTeatro(Teatro teatro) throws Exception;

    void eliminarTeatro(long idTeatro) throws Exception;

    Teatro actualizarTeatro(Teatro teatro) throws Exception;

    Teatro obtenerTeatro(long idTeatro) throws Exception;

    List<Teatro> listarTeatros();

    //CRUD FUNCIONES
    Funcion crearFuncion(Funcion funcion) throws Exception;

    void eliminarFuncion(long idFuncion) throws Exception;

    Funcion actualizarFuncion(Funcion funcion) throws Exception;

    List<Funcion> listarFunciones();

    Funcion obtenerFuncion(long idFuncion) throws Exception;

    //CRUD SALAS
    Sala crearSala(Sala sala) throws Exception;

    void eliminarSala(int idSala) throws Exception;

    Sala actualizarSala(Sala sala) throws Exception;

    Sala obtenerSala(int idSala) throws Exception;

    List<Sala> listarSalas();

    Ciudad obtenerCiudad(Long idCiudad) throws Exception;

    List<Ciudad> listarCiudades();
}
