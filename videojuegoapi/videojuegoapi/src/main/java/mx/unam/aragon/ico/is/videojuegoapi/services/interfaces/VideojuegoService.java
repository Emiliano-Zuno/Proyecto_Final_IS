package mx.unam.aragon.ico.is.videojuegoapi.services.interfaces;

import mx.unam.aragon.ico.is.videojuegoapi.entities.Videojuego;

import java.util.List;
import java.util.Optional;

public interface VideojuegoService {
    public abstract Optional<Videojuego> buscarPorId(Long id);
    public abstract Iterable<Videojuego> listar();
    public abstract Videojuego crear(Videojuego videojuego);
    public abstract Videojuego actualizar(Long id, Videojuego videojuego);
    public abstract Videojuego eliminar(Long id);
}
