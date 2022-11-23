package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Estado;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Getter @Setter
    private List<Pelicula> carteleras;

    @Getter @Setter
    private List<Pelicula> preventas;
    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Ciudad ciudad;

    private List<String> imagenes;

    @PostConstruct
    public void init(){
        carteleras = clienteServicio.listarPeliculasPorEstado(Estado.Cartelera);
        preventas = clienteServicio.listarPeliculasPorEstado(Estado.Preventa);
        ciudades = adminTeatroServicio.listarCiudades();
        imagenes = new ArrayList<>();
    }

    public void seleccionarCiudad (){
        if (ciudad != null){
            carteleras = clienteServicio.listarPeliculasPorEstadoYCiudad(Estado.Cartelera, ciudad.getId());
            preventas = clienteServicio.listarPeliculasPorEstadoYCiudad(Estado.Preventa, ciudad.getId());
        }
    }

}