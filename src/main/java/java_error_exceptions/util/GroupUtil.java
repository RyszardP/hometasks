package java_error_exceptions.util;

import java_error_exceptions.entity.Group;
import java_error_exceptions.entity.Student;
import java_error_exceptions.entity.Subject;
import java_error_exceptions.exceptions.GroupDoesNotHaveStudentException;

import java.util.Optional;

public class GroupUtil extends Calculations {

    public static boolean hasStudent(Group group, long studentId) throws GroupDoesNotHaveStudentException {
        return  group.getStudents().stream().anyMatch(student -> student.getStudentId() == studentId);
    }

    public static Student searchStudent(Group group, long studentId) throws GroupDoesNotHaveStudentException {
        Optional<Student> optionalStudent = group.getStudents().stream().
                filter(student -> student.getStudentId() == studentId)
                .findFirst();
        return optionalStudent.orElse(null);
    }

    public static Double getAverageScoreBySubject(Group group, Subject subject)
            throws GroupDoesNotHaveStudentException {
        return averageSubjectScore(group.getStudents(),subject);
    }
}
