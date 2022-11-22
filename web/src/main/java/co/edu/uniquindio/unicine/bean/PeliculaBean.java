package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.Estado;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.PeliculaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
public class PeliculaBean implements Serializable {
    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private PeliculaServicio peliculaServicio;

    @Getter @Setter
    private List<Genero> generos;


    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
        generos = Arrays.asList(Genero.values());
    }

    public void registrarPelicula(){
        try {
            pelicula.setImagen("");
            pelicula.setEstado(Estado.Cartelera);
            peliculaServicio.crearPelicula(pelicula);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Pelicula registrada");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
    }

}