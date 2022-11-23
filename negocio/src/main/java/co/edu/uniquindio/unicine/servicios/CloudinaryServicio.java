package co.edu.uniquindio.unicine.servicios;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServicio {
    private Cloudinary cloudinary;

    private Map<String, String> config;

    public CloudinaryServicio(){
        config = new HashMap<>();
        config.put("cloud_name", "kefran4");
        config.put("api_key", "467944363973738");
        config.put("api_secret", "UA5EwxL4cMQekHOfDT0sJIfqvP0");
        cloudinary = new Cloudinary(config);
    }

    public Map subirImagen(File file, String carpeta) throws IOException {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", String.format("unicine/%s", carpeta)));
    }

    public Map eliminarImagen(String idImagen) throws IOException {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
}
