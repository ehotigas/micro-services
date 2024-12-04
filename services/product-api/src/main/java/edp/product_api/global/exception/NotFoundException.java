package edp.product_api.global.exception;

public class NotFoundException extends HttpException {
    public NotFoundException(String message) {
        super(message, 404, "NotFoundException");
    }
}
