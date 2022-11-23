package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {


    @Value("#{param['resultado']}")
    private String resultado;

    @Getter @Setter
    private List<Pelicula> peliculas;

    @Autowired
    private AdminServicio adminServicio;

    @PostConstruct
    public void init(){
        if (!resultado.isEmpty()) {
            System.out.println(resultado);
            peliculas = adminServicio.obtenerPeliculasSimilares("%"+resultado+"%");
        }
    }

}
