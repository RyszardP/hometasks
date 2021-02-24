package java_error_exceptions.exceptions;

public class GroupDoesNotHaveStudentException extends Exception {
    public GroupDoesNotHaveStudentException() {
        super("Students must be in the group");
    }

    public GroupDoesNotHaveStudentException(String s) {
    }
}
