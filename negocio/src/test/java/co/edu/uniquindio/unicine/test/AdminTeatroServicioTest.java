package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AdminTeatroServicioTest {
    @Autowired
    AdminTeatroServicio adminTeatroServicio;

    //TEST PASED
    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        try {
            AdministradorTeatro adminTeatro = adminTeatroServicio.login("michael@email.com", "michael123");
            Assertions.assertNotNull(adminTeatro);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //TEST PASED
    @Test
    @Sql("classpath:dataset.sql")
    public void crearTeatro(){
        try{
            Teatro nuevoTeatro = Teatro.builder().nombre("Jupiter Plaza").direccion("cra12-15-25").ciudad(new Ciudad("Quindio", "Armenia")).build();
            Assertions.assertNotNull(adminTeatroServicio.crearTeatro(nuevoTeatro));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTeatro(){
        try{
            adminTeatroServicio.eliminarTeatro(1);
            Teatro teatroEliminado = adminTeatroServicio.obtenerTeatro(1);
            Assertions.assertNull(teatroEliminado);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarTeatro(){
        try{
            Teatro teatroEncontrado = adminTeatroServicio.obtenerTeatro(1);
            Assertions.assertNotNull(teatroEncontrado);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //NOT PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatros(){
        try{
            List<Teatro> teatros = adminTeatroServicio.listarTeatros();
            teatros.forEach(System.out::println);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTeatro(){
        try{
            Teatro teatro = adminTeatroServicio.obtenerTeatro(1);
            teatro.setNombre("Unicentenario");
            Teatro teatroNuevo = adminTeatroServicio.actualizarTeatro(teatro);
            Assertions.assertEquals("Unicentenario", teatroNuevo.getNombre());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //CRUD SALAS
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void crearSala(){
        try {
            Sala sala = Sala.builder().teatro(new Teatro()).build();
            Assertions.assertNotNull(adminTeatroServicio.crearSala(sala));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarSala(){
        try {
            adminTeatroServicio.eliminarSala(1);
            Sala salaEliminada = adminTeatroServicio.obtenerSala(1);
            Assertions.assertNull(salaEliminada);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    //TEST PASSED
    public void buscarSala(){
        try {
            Assertions.assertNotNull(adminTeatroServicio.obtenerSala(1));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSalas(){
        try {
            List<Sala> salas = adminTeatroServicio.listarSalas();
            for (Sala sala: salas) {
                System.out.println(sala.getId());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarSala(){
        try {
            Sala sala = adminTeatroServicio.obtenerSala(1);
            Teatro nuevoTeatro = new Teatro();
            nuevoTeatro.setNombre("Movistar");
            sala.setTeatro(nuevoTeatro);
            Sala nuevaSala = adminTeatroServicio.actualizarSala(sala);
            Assertions.assertEquals("Movistar", nuevaSala.getTeatro().getNombre());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //CRUD FUNCIONES
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void crearFuncion(){
        try {
            Funcion funcion = Funcion.builder().build();
            Assertions.assertNotNull(adminTeatroServicio.crearFuncion(funcion));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFuncion(){
        try {
            adminTeatroServicio.eliminarFuncion(1);
            Funcion funcion = adminTeatroServicio.obtenerFuncion(1);
            Assertions.assertNull(funcion);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void buscarFuncion(){
        try {
            Funcion funcion = adminTeatroServicio.obtenerFuncion(1);
            Assertions.assertNotNull(funcion);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void listarFunciones(){
        try {
            List<Funcion> funciones = adminTeatroServicio.listarFunciones();
            for (Funcion funcion : funciones) {
                System.out.println(funcion.getId());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //TEST PASSED
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarFuncion(){
        try {
            Funcion funcion = adminTeatroServicio.obtenerFuncion(1);
            funcion.setPrecio(3.5);
            Funcion funcionActualizada = adminTeatroServicio.actualizarFuncion(funcion);
            Assertions.assertEquals(3.5, funcionActualizada.getPrecio());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
