package edp.identity_server.global.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {
    private String message;
    private int statusCode;
    private String error;
}
