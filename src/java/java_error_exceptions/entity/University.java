package java_error_exceptions.entity;

import java_error_exceptions.exceptions.UniversityDoesNotHaveFacultiesException;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String title;
    private final ArrayList<Faculty> faculties = new ArrayList<>();

    public University() {
    }

    public University(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Faculty> getFaculties() throws UniversityDoesNotHaveFacultiesException {
        if (faculties.isEmpty()) {
            throw new UniversityDoesNotHaveFacultiesException("University does not have faculty");
        }
        return faculties;
    }

    public void setFaculty(Faculty faculty) {
        faculties.add(faculty);
    }


}
