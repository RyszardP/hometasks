package java_error_exceptions.init;

import java_error_exceptions.entity.University;
import java_error_exceptions.exceptions.*;

public abstract class UniversityInitializer {
    protected University university;

    public UniversityInitializer() {
        university = new University();
    }

    protected abstract void setFaculties();

    protected abstract void setGroups() throws UniversityDoesNotHaveFacultiesException;

    protected abstract void setStudents() throws UniversityDoesNotHaveFacultiesException, FacultyDoesNotHaveGroupsException, GroupDoesNotHaveStudentException;

    protected abstract void setScores() throws UniversityDoesNotHaveFacultiesException, FacultyDoesNotHaveGroupsException,
            GroupDoesNotHaveStudentException, StudentDoesNotHaveSubjectException, ScoresMustBeInRangeException;

    public University initializeUniversity() throws UniversityDoesNotHaveFacultiesException,
            FacultyDoesNotHaveGroupsException, GroupDoesNotHaveStudentException, StudentDoesNotHaveSubjectException,
            ScoresMustBeInRangeException {
        setFaculties();
        setGroups();
        setStudents();
        setScores();
        return university;
    }
}
