package com.example.gestion_citas_fisioterapeuta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestion_citas_fisioterapeuta/jugadores")
//@CrossOrigin(origins = {"http://localhost:3306","http://angular-gesiton-fisio.s3-website.eu-west-3.amazonaws.com"})
public class JugadorController {
	
	@Value("${file.upload-dir}")
	private String uploadDir;

	@Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Jugador> getJugadorById(@PathVariable Long id) {
        return jugadorRepository.findById(id);
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }
    
    /*@PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Jugador> createJugador(
            @RequestParam("file") MultipartFile file,
            @RequestParam("nombre") String nombre,
            @RequestParam("fechaNacimiento") String fechaNacimiento,
            @RequestParam("direccion") String direccion,
            @RequestParam("telefono") String telefono,
            @RequestParam("correoElectronico") String correoElectronico,
            @RequestParam("antecedentesEnfermedades") String antecedentesEnfermedades,
            @RequestParam("antecedentesLesiones") String antecedentesLesiones,
            @RequestParam("antecedentesQuirurgicos") String antecedentesQuirurgicos,
            @RequestParam("observacionesActuales") String observacionesActuales) {

        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // Definir la ruta de destino
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Guardar el archivo
            byte[] bytes = file.getBytes();
            Path path = uploadPath.resolve(file.getOriginalFilename());
            Files.write(path, bytes);

            // Crear el jugador
            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            jugador.setFechaNacimiento(fechaNacimiento);
            jugador.setDireccion(direccion);
            jugador.setTelefono(telefono);
            jugador.setCorreoElectronico(correoElectronico);
            jugador.setAntecedentesEnfermedades(antecedentesEnfermedades);
            jugador.setAntecedentesLesiones(antecedentesLesiones);
            jugador.setAntecedentesQuirurgicos(antecedentesQuirurgicos);
            jugador.setObservacionesActuales(observacionesActuales);
            jugador.setFotoPerfil(path.toString());

            Jugador createdJugador = jugadorRepository.save(jugador);
            return new ResponseEntity<>(createdJugador, HttpStatus.CREATED);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugadorDetails) {
    	Jugador jugador = jugadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jugador not found"));
    	jugador.setNombre(jugadorDetails.getNombre());
    	jugador.setFechaNacimiento(jugadorDetails.getFechaNacimiento());
    	jugador.setDireccion(jugadorDetails.getDireccion());
    	jugador.setTelefono(jugadorDetails.getTelefono());
    	jugador.setCorreoElectronico(jugadorDetails.getCorreoElectronico());
    	jugador.setAntecedentesEnfermedades(jugadorDetails.getAntecedentesEnfermedades());
    	jugador.setAntecedentesLesiones(jugadorDetails.getAntecedentesLesiones());
    	jugador.setAntecedentesQuirurgicos(jugadorDetails.getAntecedentesQuirurgicos());
    	jugador.setObservacionesActuales(jugadorDetails.getObservacionesActuales());
    	return jugadorRepository.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
    	jugadorRepository.deleteById(id);
    }
}