package java_error_exceptions.init;

import java_error_exceptions.entity.Faculty;
import java_error_exceptions.entity.Group;
import java_error_exceptions.entity.Student;
import java_error_exceptions.entity.Subject;
import java_error_exceptions.exceptions.*;

public class Initializer extends UniversityInitializer {

    @Override
    protected void setFaculties() {
        university.setFaculty(new Faculty("Organic Substances Technology Faculty"));
        university.setFaculty(new Faculty("Chemical Technology and Engineering Faculty"));
        university.setFaculty(new Faculty("Faculty of Print Technology and Media Communications"));
        university.setFaculty(new Faculty("Forestry Faculty"));
    }

    @Override
    protected void setGroups() throws UniversityDoesNotHaveFacultiesException {
        university.getFaculties().get(0).setGroup("OST1");
        university.getFaculties().get(0).setGroup("OST2");
        university.getFaculties().get(0).setGroup("OST3");
        university.getFaculties().get(1).setGroup("ChTEF1");
        university.getFaculties().get(1).setGroup("ChTEF2");
        university.getFaculties().get(1).setGroup("ChTEF3");
        university.getFaculties().get(2).setGroup("FoPT1");
        university.getFaculties().get(2).setGroup("FoPT2");
        university.getFaculties().get(2).setGroup("FoPT3");
        university.getFaculties().get(3).setGroup("FF1");
        university.getFaculties().get(3).setGroup("FF2");
        university.getFaculties().get(3).setGroup("FF3");
    }

    @Override
    protected void setStudents() throws UniversityDoesNotHaveFacultiesException, FacultyDoesNotHaveGroupsException,
            GroupDoesNotHaveStudentException {
        university.getFaculties().get(0).getGroup("OST1").setRandomStudents(new Student(), 20);
        university.getFaculties().get(0).getGroup("OST2").setRandomStudents(new Student(), 20);
        university.getFaculties().get(0).getGroup("OST3").setRandomStudents(new Student(), 20);
        university.getFaculties().get(1).getGroup("ChTEF1").setRandomStudents(new Student(), 20);
        university.getFaculties().get(1).getGroup("ChTEF2").setRandomStudents(new Student(), 20);
        university.getFaculties().get(1).getGroup("ChTEF3").setRandomStudents(new Student(), 20);
        university.getFaculties().get(2).getGroup("FoPT1").setRandomStudents(new Student(), 20);
        university.getFaculties().get(2).getGroup("FoPT2").setRandomStudents(new Student(), 20);
        university.getFaculties().get(2).getGroup("FoPT3").setRandomStudents(new Student(), 20);
        university.getFaculties().get(3).getGroup("FF1").setRandomStudents(new Student(), 20);
        university.getFaculties().get(3).getGroup("FF2").setRandomStudents(new Student(), 20);
        university.getFaculties().get(3).getGroup("FF3").setRandomStudents(new Student(), 20);

    }

    @Override
    protected void setScores() throws ScoresMustBeInRangeException, FacultyDoesNotHaveGroupsException,
            StudentDoesNotHaveSubjectException, GroupDoesNotHaveStudentException, UniversityDoesNotHaveFacultiesException {
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        int gradesCount = (int) (Math.random() * 4);
                        for (int i = 0; i < gradesCount; i++) {
                            student.setScore(subject, (int) ((Math.random() * 10) + 1));
                        }
                    }
                }
            }
        }
    }
}
