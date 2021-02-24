package java_error_exceptions.exceptions;

public class FacultyDoesNotHaveGroupsException extends Exception {
    public FacultyDoesNotHaveGroupsException(){
        super("Faculty must have group");
    }

    public FacultyDoesNotHaveGroupsException(String s) {
    }
}
