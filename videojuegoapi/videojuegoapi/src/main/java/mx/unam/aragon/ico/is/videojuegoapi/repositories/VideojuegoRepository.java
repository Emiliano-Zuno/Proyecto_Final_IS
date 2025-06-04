package mx.unam.aragon.ico.is.videojuegoapi.repositories;

import mx.unam.aragon.ico.is.videojuegoapi.entities.Videojuego;
import org.springframework.data.repository.CrudRepository;

public interface VideojuegoRepository extends CrudRepository<Videojuego, Long> {
    public Videojuego findVideojuegoByClave(Long clave);
    public Videojuego deleteByClave(Long clave);
}
