package mx.unam.aragon.ico.is.videojuegoapi.controllers;

import mx.unam.aragon.ico.is.videojuegoapi.entities.Videojuego;
import mx.unam.aragon.ico.is.videojuegoapi.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/videojuegos")
public class VideojuegoRestController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/")
    public ResponseEntity <Iterable<Videojuego>> getVideojuego() {
        return new ResponseEntity<>(videojuegoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Videojuego> getVideojuego(@PathVariable Long clave) {
        Optional<Videojuego> tmp = videojuegoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Videojuego> createVideojuego(@RequestBody @Valid Videojuego videojuego) {
        return new ResponseEntity<>(videojuegoService.crear(videojuego), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> noExiste() {
        return new ResponseEntity<>("End Point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Videojuego> actualizaParcial(@PathVariable Long clave,@RequestBody Videojuego videojuego) {
        Videojuego tmp = videojuegoService.buscarPorId(clave).orElse(null);
        if (tmp != null) {
            if (videojuego.getNombre() != null) tmp.setNombre(videojuego.getNombre());
            if (videojuego.getDesarrollador() != null) tmp.setDesarrollador(videojuego.getDesarrollador());
            if (videojuego.getPlataforma() != null) tmp.setPlataforma(videojuego.getPlataforma());
            if (videojuego.getGenero() != null) tmp.setGenero(videojuego.getGenero());
            if (videojuego.getImagen() != null) tmp.setImagen(videojuego.getImagen());
            return new ResponseEntity<>(videojuegoService.actualizar(clave, tmp), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Videojuego> editar(@PathVariable Long clave,@RequestBody Videojuego videojuego) {
        Optional tmp = videojuegoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(videojuegoService.actualizar(clave, videojuego), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<Videojuego> eliminar(@PathVariable Long clave) {
        Videojuego tmp = videojuegoService.eliminar(clave);
        if (tmp != null) {
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
