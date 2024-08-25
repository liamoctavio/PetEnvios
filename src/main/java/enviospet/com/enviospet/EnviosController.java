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

    private List<Envios> envios = new ArrayList<>();

    public EnviosController() {
        envios.add(new Envios(1, "Juan Perez", "Calle 123", 5.0, 1000.0));
        envios.add(new Envios(2, "Maria Lopez", "Calle 456", 10.0, 2000.0));
        envios.add(new Envios(3, "Carlos Ramirez", "Calle 789", 15.0, 3000.0));
    }

    @GetMapping("/listar")
    public List<Envios> listar() {
        return envios;
    }

    @GetMapping("/buscar/{id}")
    public Envios buscarPorId(@PathVariable int id) {
        Optional<Envios> envio = envios.stream().filter(e -> e.getId() == id).findFirst();
        return envio.orElse(null);
    }

    @GetMapping("/ubicacion/{id}")
    public String consultarUbicacionActual(@PathVariable int id) {
        Optional<Envios> envio = envios.stream().filter(e -> e.getId() == id).findFirst();
        return envio.map(Envios::getDireccion).orElse("Ubicación no encontrada");
    }

}
