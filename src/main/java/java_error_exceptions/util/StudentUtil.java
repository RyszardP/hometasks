package java_error_exceptions.util;

import java_error_exceptions.entity.Student;
import java_error_exceptions.entity.Subject;
import java_error_exceptions.exceptions.StudentDoesNotHaveSubjectException;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class StudentUtil extends Calculations {

    public static List<Integer> getScoresBySubject(Student student, Subject subject) {
        return student.getScores().getSubjectScore().get(subject);
    }

    public static double getAverageBySubject(Student student, Subject subject) throws StudentDoesNotHaveSubjectException {
        LinkedList<Student> studentList = new LinkedList<>();
        studentList.add(student);
        return averageSubjectScore(studentList, subject);
    }

    public static EnumMap<Subject, Double> getAverageScore(Student student) throws StudentDoesNotHaveSubjectException {
        EnumMap<Subject, Double> averageScores = new EnumMap<>(Subject.class);

        for(Subject subject : student.getSubjects()){
            averageScores.put(subject,getAverageBySubject(student, subject));
        }
        return averageScores;
    }
}
