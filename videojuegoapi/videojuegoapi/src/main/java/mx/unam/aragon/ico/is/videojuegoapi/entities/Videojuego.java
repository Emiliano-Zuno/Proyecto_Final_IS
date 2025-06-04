package mx.unam.aragon.ico.is.videojuegoapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table (name="videojuegos")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clave;
    @Column(name = "Titulo", nullable = false)
    @NotBlank(message = "No se acaptan blancos")
    @NotNull(message = "No se acepta null")
    private String nombre;
    @Column(name = "Empresa", nullable = false, length = 20)
    private String desarrollador;
    @Column(name = "Consola", nullable = false, length = 20)
    private String plataforma;
    @Column(name = "Tipo", nullable = false, length = 20)
    private String genero;
    @Column(name = "Portada", nullable = true, insertable = false, columnDefinition = " VARCHAR(500) DEFAULT 'https://storage.googleapis.com/proudcity/mebanenc/uploads/2021/03/placeholder-image.png'")
    private String imagen;

    public Videojuego() {
    }

    public Videojuego(Long clave, String nombre, String desarrollador, String plataforma, String genero, String imagen) {
        this.clave = clave;
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.plataforma = plataforma;
        this.genero = genero;
        this.imagen = imagen;
    }

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", genero='" + genero + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
