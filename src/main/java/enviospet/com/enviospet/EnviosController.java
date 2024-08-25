package enviospet.com.enviospet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/envios")
public class EnviosController {

    // Lista privada de objetos Envios
    private List<Envios> envios = new ArrayList<>();

    // Constructor de la clase
    public EnviosController() {
        envios.add(new Envios(1, "Juan Perez", "Calle 123", 5.0, 1000.0));
        envios.add(new Envios(2, "Maria Lopez", "Calle 456", 10.0, 2000.0));
        envios.add(new Envios(3, "Carlos Ramirez", "Calle 789", 15.0, 3000.0));
    }

    // Métodos para consultar la lista de envíos
    @GetMapping("/listar")
    public List<Envios> listar() {
        return envios;
    }

    // Métodos para buscar un envío por ID
    @GetMapping("/buscar/{id}")
    public Envios buscarPorId(@PathVariable int id) {
        // Buscar el envío con el ID especificado
        Optional<Envios> envio = envios.stream().filter(e -> e.getId() == id).findFirst();
        // Devolver el envío si se encuentra, de lo contrario, devolver null
        return envio.orElse(null);
    }

    // Métodos para consultar la ubicación actual de un envío
    @GetMapping("/ubicacion/{id}")
    public String consultarUbicacionActual(@PathVariable int id) {
        Optional<Envios> envio = envios.stream().filter(e -> e.getId() == id).findFirst();
        // Devolver la dirección del envío si se encuentra, de lo contrario, devolver un mensaje de error
        return envio.map(Envios::getDireccion).orElse("Ubicación no encontrada");
    }

}
