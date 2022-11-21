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

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;
    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @PostConstruct
    public void init(){
        teatro = new Teatro();
        ciudades = adminTeatroServicio.listarCiudades();
    }

    public String registrarTeatro(){
        try {
            teatro.setAdministradorTeatro(adminServicio.obtenerAdminTeatro(6));
            adminTeatroServicio.crearTeatro(teatro);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Teatro registrado");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            return ruta;
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
        return "";
    }
}
