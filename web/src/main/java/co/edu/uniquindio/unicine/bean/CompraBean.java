package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
public class CompraBean implements Serializable {

    @Value("#{param['funcion_id']}")
    private String funcionId;

    @Autowired
    private AdminServicio adminServicio;

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;

    @Getter @Setter
    private Funcion funcion;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Teatro> teatros;

    @Getter @Setter
    private List<Funcion> funciones;

    @Getter @Setter
    private List<Silla> sillas;

    @Getter @Setter
    private List<Confiteria> confiteria;

    @Getter @Setter
    private List<Confiteria> confiteriaSeleccionada;

    @Getter @Setter
    private List<MedioPago> mediosDePago;

    @Getter @Setter
    private Ciudad ciudad;

    @Getter @Setter
    private MedioPago medioDePago;

    @PostConstruct
    public void init(){
        try {
            if (funcionId != null && !funcionId.isEmpty()){
                funcion = adminTeatroServicio.obtenerFuncion(Long.parseLong(funcionId));
                ciudades = adminTeatroServicio.listarCiudades();
                sillas = funcion.getSala().getSillas();
                confiteria = adminServicio.listarConfiteria();
                mediosDePago = Arrays.asList(MedioPago.values());
                teatros = new ArrayList<>();
                funciones = new ArrayList<>();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void actualizarFunciones (){
        if (ciudad != null){

        }
    }

    public String comprar(Funcion funcion){
        if (funcion != null)
            return "/compra?faces-redirect=true&amp;funcion_id=" + funcion.getId();
        return "";
    }
}
