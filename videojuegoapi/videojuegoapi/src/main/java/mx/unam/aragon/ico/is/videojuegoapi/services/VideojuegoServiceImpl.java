package mx.unam.aragon.ico.is.videojuegoapi.services;

import mx.unam.aragon.ico.is.videojuegoapi.entities.Videojuego;
import mx.unam.aragon.ico.is.videojuegoapi.repositories.VideojuegoRepository;
import mx.unam.aragon.ico.is.videojuegoapi.services.interfaces.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Override
    public Optional<Videojuego> buscarPorId(Long id) {
        return videojuegoRepository.findById(id);
    }

    @Override
    public Iterable<Videojuego> listar() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Videojuego crear(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    @Override
    public Videojuego actualizar(Long id, Videojuego videojuego) {
        Optional<Videojuego> videojuegoActual = videojuegoRepository.findById(id);
        if (videojuegoActual.isPresent()) {
            Videojuego videojuegoActualizar = videojuegoActual.get();
            videojuegoActualizar.setNombre(videojuego.getNombre());
            videojuegoActualizar.setDesarrollador(videojuego.getDesarrollador());
            videojuegoActualizar.setGenero(videojuego.getGenero());
            videojuegoActualizar.setPlataforma(videojuego.getPlataforma());
            videojuegoActualizar.setImagen(videojuego.getImagen());
            return videojuegoRepository.save(videojuegoActualizar);
        } else {
            return null;
        }
    }

    @Override
    public Videojuego eliminar(Long id) {
        Optional<Videojuego> optional = videojuegoRepository.findById(id);
        if (optional.isPresent()) {
            Videojuego tmp = optional.get();
            videojuegoRepository.deleteById(id);
            return tmp;
        }
        return null;
    }

}
