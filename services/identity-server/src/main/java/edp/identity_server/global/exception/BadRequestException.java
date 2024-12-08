package edp.identity_server.global.exception;

public class BadRequestException extends HttpException {
    public BadRequestException(String message) {
        super(message, 400, "BadRequestException");
    }
}
