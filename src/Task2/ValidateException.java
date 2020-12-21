package Task2;

public class ValidateException extends RuntimeException {
    private Code status;

    public ValidateException(String message, Code status) {
        super(message);
        this.status = status;
    }

    public Code getStatus() {
        return status;
    }
}
