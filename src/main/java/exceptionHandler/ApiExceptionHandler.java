package exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice todos os controllers teram erros tratados por essa classe

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

}
