package nube.tp.pagos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
   @ExceptionHandler(value = ControllerException.class)
   public ResponseEntity<Object> exception(ControllerException exception) {
      return new ResponseEntity<>(exception.message, exception.status);
   }
}