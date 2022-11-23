package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.Estado;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.servicios.CloudinaryServicio;
import co.edu.uniquindio.unicine.servicios.PeliculaServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.*;

@Component
@ViewScoped
public class PeliculaBean implements Serializable {
    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Autowired
    private AdminServicio adminServicio;

    @Autowired
    private PeliculaServicio peliculaServicio;

    @Autowired
    private CloudinaryServicio cloudinaryServicio;

    @Getter @Setter
    private List<Genero> generos;

    private Map<String, String> imagenes;

    @Getter @Setter
    private List<Pelicula> peliculas;

    @Getter @Setter
    private List<Pelicula> peliculasSeleccionadas;

    private boolean editar;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
        peliculas = adminServicio.listarPeliculas();
        peliculasSeleccionadas = new ArrayList<>();
        generos = Arrays.asList(Genero.values());
        imagenes = new HashMap<>();
        editar = false;
    }

    public void registrarPelicula(){
        try {
            if (!imagenes.isEmpty()){
                pelicula.setImagenes(imagenes);
                pelicula.setEstado(Estado.Cartelera);
                peliculaServicio.crearPelicula(pelicula);

                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Pelicula registrada");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }else{
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario subir una imagen");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }

        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
    }

    public void subirImagenes(FileUploadEvent event){
        try {
            UploadedFile imagen = event.getFile();
            File imagenFile = convertirUploadedFile(imagen);
            Map resultado = cloudinaryServicio.subirImagen(imagenFile,"peliculas");
            imagenes.put(resultado.get("public_id").toString(),resultado.get("url").toString());
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
    }

    private File convertirUploadedFile(UploadedFile imagen) throws IOException {
        File file = new File(imagen.getFileName());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getContent());
        fos.close();
        return file;
    }

    public String getMensajeEditar(){
        return editar ? "Editar teatro" : "Crear teatro";
    }

    public void eliminarPeliculas (){
        peliculasSeleccionadas.forEach( teatroAux -> {
            try {
                adminTeatroServicio.eliminarTeatro(teatroAux.getId());
                peliculas.remove(teatroAux);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminación exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        });
        peliculasSeleccionadas.clear();
    }

    public String getMensajeEliminar(){
        if (peliculasSeleccionadas.isEmpty())
            return "Eliminar";
        else
            return peliculasSeleccionadas.size() == 1 ? "Eliminar 1 elemento" : "Eliminar " + peliculasSeleccionadas.size() + " elementos";
    }

    public void seleccionarPelicula (Pelicula peliculaSeleccionada){
        pelicula = peliculaSeleccionada;
        editar = true;
    }

    public void crearPeliculaDialog(){
        editar = false;
        pelicula = new Pelicula();
    }
}