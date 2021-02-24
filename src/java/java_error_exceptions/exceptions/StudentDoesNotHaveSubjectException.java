package java_error_exceptions.exceptions;

public class StudentDoesNotHaveSubjectException extends Exception {
    public StudentDoesNotHaveSubjectException() {
    }

    public StudentDoesNotHaveSubjectException(String message) {
        super(message);
    }

    public StudentDoesNotHaveSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentDoesNotHaveSubjectException(Throwable cause) {
        super(cause);
    }
}
