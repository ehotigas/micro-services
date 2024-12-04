package edp.microservices.global.exception;


public class HttpException extends RuntimeException {
    private String message;
    private String error;
    private int statusCode;

    public HttpException(String message, int statusCode, String error) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }
}
