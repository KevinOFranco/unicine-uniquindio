package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.*;
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
public class ConfiteriaBean implements Serializable {

    @Getter @Setter
    private Confiteria confiteria;

    @Getter @Setter
    private List<Confiteria> confiterias;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Autowired
    private AdminServicio adminServicio;

    @Autowired
    private CloudinaryServicio cloudinaryServicio;

    @Getter @Setter
    private List<Genero> generos;

    private Map<String, String> imagenes;

    @Getter @Setter
    private List<Pelicula> peliculas;

    @Getter @Setter
    private List<Confiteria> confiteriasSeleccionadas;

    private boolean editar;

    @PostConstruct
    public void init(){
        confiteria = new Confiteria();
        peliculas = adminServicio.listarPeliculas();
        confiterias = adminServicio.listarConfiteria();
        confiteriasSeleccionadas = new ArrayList<>();
        generos = Arrays.asList(Genero.values());
        imagenes = new HashMap<>();
        editar = false;
    }

    public void registrarConfiteria(){
        try {
                confiteria.setImagen("imagenes");
                adminServicio.crearConfiteria(confiteria);
                if (!editar) {
                    confiterias.add(confiteria);

                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Confiteria registrada");
                    FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
                }else{
                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Confiteria modificada");
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
            Map resultado = cloudinaryServicio.subirImagen(imagenFile,"confiteria");
            //imagenes.put(resultado.get("public_id").toString(),resultado.get("url").toString());
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
        return editar ? "Editar confiteria" : "Crear confiteria";
    }

    public void eliminarConfiteria (){
        confiteriasSeleccionadas.forEach( confiteraiAux -> {
            try {
                adminServicio.eliminarConfiteria(confiteraiAux.getId());
                confiterias.remove(confiteraiAux);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminación exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        });
        confiteriasSeleccionadas.clear();
    }

    public String getMensajeEliminar(){
        if (confiteriasSeleccionadas.isEmpty())
            return "Eliminar";
        else
            return confiteriasSeleccionadas.size() == 1 ? "Eliminar 1 elemento" : "Eliminar " + confiteriasSeleccionadas.size() + " elementos";
    }

    public void seleccionarConfiteria (Confiteria confiteriaSeleccionada){
        confiteria = confiteriaSeleccionada;
        editar = true;
    }

    public void crearConfiteriaDialog(){
        editar = false;
        confiteria = new Confiteria();
    }
}