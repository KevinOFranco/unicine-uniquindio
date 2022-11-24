package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdminServicio adminServicio;
    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String email,password;

    @Getter @Setter
    private Persona persona;

    @Getter @Setter
    private String tipoSesion;

    @Getter @Setter
    private Ciudad ciudadSeleccionada;

    @PostConstruct
    public void inicializar(){
    autenticado = false;
    }

    public String iniciarSesionCliente(){

        if (!email.isEmpty() && !password.isEmpty() ){
            try {
               persona = clienteServicio.loguear( email, password);
               tipoSesion = "cliente";
               autenticado= true;
               return "/index?faces-redirect=true";
            }catch (Exception e){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String iniciarSesionAdmin(){

        if (!email.isEmpty() && !password.isEmpty() ){
            try {
                persona = adminServicio.login ( email, password);
                tipoSesion = "Admin";
                autenticado= true;
                return "/index?faces-redirect=true";
            }catch (Exception e){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String iniciarSesionAdminTeatro(){

        if (!email.isEmpty() && !password.isEmpty() ){
            try {
                persona = adminTeatroServicio.login ( email, password);
                tipoSesion = "Admin Teatro";
                autenticado= true;
                return "/index?faces-redirect=true";
            }catch (Exception e){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contraseña son necesarios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion(){

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

}
