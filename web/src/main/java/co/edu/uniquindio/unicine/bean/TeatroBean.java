package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class TeatroBean implements Serializable {
    @Getter @Setter
    private Teatro teatro;

    private String ruta = "../index.xhtml?faces-redirect=true";

    @Getter @Setter
    private List<Teatro> teatros;

    @Getter @Setter
    private List<Teatro> teatrosSeleccionados;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    private boolean editar;

    @PostConstruct
    public void init(){
        teatro = new Teatro();
        editar = false;
        ciudades = adminTeatroServicio.listarCiudades();
        teatros = adminTeatroServicio.listarTeatros();
        teatrosSeleccionados = new ArrayList<>();
    }

    public void registrarTeatro(){
        try {
            if (!editar){
                teatro.setAdministradorTeatro(adminServicio.obtenerAdminTeatro(6));
                Teatro registro = adminTeatroServicio.crearTeatro(teatro);
                teatros.add(registro);
                teatro = new Teatro();

                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Teatro registrado");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
            else {
                adminTeatroServicio.actualizarTeatro(teatro);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Teatro actualizado");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
    }

    public void eliminarTeatros (){
        teatrosSeleccionados.forEach( teatroAux -> {
            try {
                adminTeatroServicio.eliminarTeatro(teatroAux.getId());
                teatros.remove(teatroAux);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminación exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        });
        teatrosSeleccionados.clear();
    }

    public String getMensajeEliminar(){
        if (teatrosSeleccionados.isEmpty())
            return "Eliminar";
        else
            return teatrosSeleccionados.size() == 1 ? "Eliminar 1 elemento" : "Eliminar " + teatrosSeleccionados.size() + " elementos";
    }

    public String getMensajeEditar(){
        return editar ? "Editar teatro" : "Crear teatro";
    }

    public void seleccionarTeatro (Teatro teatroSeleccionado){
        teatro = teatroSeleccionado;
        editar = true;
    }

    public void crearTeatroDialog(){
        editar = false;
        teatro = new Teatro();
    }
}
