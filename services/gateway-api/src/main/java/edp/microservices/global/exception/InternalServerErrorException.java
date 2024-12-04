package edp.microservices.global.exception;

public class InternalServerErrorException extends HttpException {
    public InternalServerErrorException(String message) {
        super(message, 500, "InternalServerErrorException");
    }
}
