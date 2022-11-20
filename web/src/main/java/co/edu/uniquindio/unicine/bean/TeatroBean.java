package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class TeatroBean implements Serializable {
    @Getter @Setter
    private Teatro teatro;

    private String ruta = "../index.xhtml";

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    public String registrarTeatro(){
        try {
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
