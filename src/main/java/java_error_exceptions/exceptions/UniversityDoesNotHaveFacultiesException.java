package java_error_exceptions.exceptions;

public class UniversityDoesNotHaveFacultiesException extends Exception {

    public UniversityDoesNotHaveFacultiesException(String message){
        super(message);
    }

    public UniversityDoesNotHaveFacultiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityDoesNotHaveFacultiesException(Throwable cause) {
        super(cause);
    }
}
