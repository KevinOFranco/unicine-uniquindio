package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetallePeliculaBean implements Serializable {

    @Value("#{param['pelicula_id']}")
    private String peliculaId;

    @Autowired
    private AdminServicio adminServicio;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Getter @Setter
    private Pelicula pelicula;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Teatro> teatros;

    @Getter @Setter
    private List<Funcion> funciones;

    @Getter @Setter
    private Ciudad ciudad;

    @PostConstruct
    public void init(){
        try {
            if (peliculaId != null && !peliculaId.isEmpty()){
                pelicula = adminServicio.obtenerPelicula(Long.parseLong(peliculaId));
                ciudades = adminTeatroServicio.listarCiudades();
                teatros = new ArrayList<>();
                funciones = new ArrayList<>();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void actualizarFunciones (){
        if (ciudad != null){
            funciones = adminTeatroServicio.obtenerFuncionesPorCiudadYPelicula(ciudad, pelicula);
            teatros = adminTeatroServicio.obtenerTeatrosPorCiudad(ciudad);
        }
    }

    public String comprar(Funcion funcion){
        if (funcion != null)
            return "/compra?faces-redirect=true&amp;funcion_id=" + funcion.getId();
        return "";
    }
}
