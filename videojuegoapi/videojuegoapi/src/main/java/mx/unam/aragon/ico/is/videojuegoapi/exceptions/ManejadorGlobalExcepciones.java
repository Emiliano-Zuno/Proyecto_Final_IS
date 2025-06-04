package mx.unam.aragon.ico.is.videojuegoapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, String>> manejarErroresGenerales(Exception ex) {
        HashMap<String,String> errores = new HashMap<>();
        errores.put("mensaje", ex.getLocalizedMessage());
        errores.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> manejarErroresHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HashMap<String,String> errores = new HashMap<>();
        errores.put("mensaje", ex.getLocalizedMessage());
        errores.put("timestam", LocalDateTime.now().toString());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}



