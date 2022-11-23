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

@Component
@ViewScoped
public class DetallePeliculaBean implements Serializable {

    @Value("#{param['pelicula_id']}")
    private String peliculaId;

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private Pelicula pelicula;

    @PostConstruct
    public void init(){
        try {
            if (peliculaId != null && !peliculaId.isEmpty()){
                pelicula = adminServicio.obtenerPelicula(Long.parseLong(peliculaId));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
