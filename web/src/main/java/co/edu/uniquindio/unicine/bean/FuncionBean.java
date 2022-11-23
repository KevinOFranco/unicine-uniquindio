package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Cupon;
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
public class FuncionBean implements Serializable {
    @Getter @Setter
    private Cupon cupon;

    private String ruta = "../index.xhtml?faces-redirect=true";

    @Getter @Setter
    private List<Cupon> cupones;

    @Getter @Setter
    private List<Cupon> cuponesSeleccionados;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;
    @Autowired
    private AdminServicio adminServicio;

    private boolean editar;

    @PostConstruct
    public void init(){
        cupon = new Cupon();
        editar = false;
        cupones = adminServicio.listarCupones();
        cuponesSeleccionados = new ArrayList<>();
    }

    public void registrarCupon(){
        try {
                Cupon registro = adminServicio.crearCupon(cupon);
            if (!editar) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Cupon registrado");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
                cupones.add(registro);
            }else {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Cupon modificado");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
            cupon = new Cupon();
        }catch (Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
        }
    }

    public void eliminarCupones (){
        cuponesSeleccionados.forEach( teatroAux -> {
            try {
                adminServicio.eliminarCupon(teatroAux.getCodigo());
                cupones.remove(teatroAux);
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminación exitosa");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", facesMessage);
            }
        });
        cuponesSeleccionados.clear();
    }

    public String getMensajeEliminar(){
        if (cuponesSeleccionados.isEmpty())
            return "Eliminar";
        else
            return cuponesSeleccionados.size() == 1 ? "Eliminar 1 elemento" : "Eliminar " + cuponesSeleccionados.size() + " elementos";
    }

    public String getMensajeEditar(){
        return editar ? "Editar cupon" : "Crear cupon";
    }

    public void seleccionarCupon (Cupon cuponSeleccionado){
        cupon = cuponSeleccionado;
        editar = true;
    }

    public void crearDialog(){
        editar = false;
        cupon = new Cupon();
    }
}
