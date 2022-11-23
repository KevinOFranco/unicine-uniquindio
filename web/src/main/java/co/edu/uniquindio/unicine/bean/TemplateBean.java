package co.edu.uniquindio.unicine.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class TemplateBean {

    @Getter
    @Setter
    private String busqueda;

    public String buscar(){
        if (!busqueda.isEmpty())
            return "/resultado_busqueda?faces-redirect=true&amp;resultado=" + busqueda;
        return "";
    }
}
