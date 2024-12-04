package edp.product_api.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edp.product_api.global.exception.ExceptionResponseDto;
import edp.product_api.global.exception.InternalServerErrorException;
import edp.product_api.global.exception.NotFoundException;


@ControllerAdvice
public class ExceptionHandlingController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponseDto handleNotFoundException(NotFoundException e) {
        return new ExceptionResponseDto(
            e.getMessage(),
            e.getStatusCode(),
            e.getError()
        );
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponseDto handleInternalServerErrorException(InternalServerErrorException e) {
        return new ExceptionResponseDto(
            e.getMessage(),
            e.getStatusCode(),
            e.getError()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponseDto handleHttpException(Exception e) {
        return new ExceptionResponseDto(
            e.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "InternalServerError"
        );
    }
}
