package edp.identity_server.global.exception;


public class NotFoundException extends HttpException {
    public NotFoundException(String message) {
        super(message, 404, "NotFoundException");
    }
}
