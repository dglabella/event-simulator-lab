package ar.edu.unsl.fmn.utils.exceptions;

public class OutOfRangeException extends RuntimeException {

    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
