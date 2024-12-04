package edp.microservices.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edp.microservices.global.exception.ExceptionResponseDto;
import edp.microservices.global.exception.InternalServerErrorException;
import edp.microservices.global.exception.NotFoundException;


@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponseDto handleNotFoundException(NotFoundException e) {
        return new ExceptionResponseDto(e.getMessage(), e.getStatusCode(), e.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponseDto handleInternalServerErrorException(InternalServerErrorException e) {
        return new ExceptionResponseDto(e.getMessage(), e.getStatusCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponseDto handleDefaultException(Exception e) {
        return new ExceptionResponseDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "InternalServerErrorException");
    }
}
