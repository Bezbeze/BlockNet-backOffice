package AuthBackOffice.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import AuthBackOffice.dto.response.GeneralErrorResponseValidation;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	GeneralErrorResponseValidation handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		List<String> messages = ex.getAllErrors().stream().map(e->e.getDefaultMessage()).toList();
		return  new GeneralErrorResponseValidation(null, messages);
	}

}
