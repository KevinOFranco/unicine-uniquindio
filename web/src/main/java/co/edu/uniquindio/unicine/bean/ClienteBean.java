package co.edu.uniquindio.unicine.bean;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
@Component
@ViewScoped
public class ClienteBean implements Serializable {
    @Getter @Setter
    private Cliente cliente;

    @Autowired
    private ClienteServicio clienteServicio;

    @Setter @Getter
    private String confirmacionPassword;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    public void registrarCliente(){
        try {
            if (confirmacionPassword.equals(cliente.getPassword())){
                clienteServicio.registrarCliente(cliente);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Usuario registrado");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }else {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Las contraseñas no coinciden");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }

    }

}