package java_error_exceptions.util;

import java_error_exceptions.entity.Student;
import java_error_exceptions.entity.Subject;

import java.util.List;


public class Calculations {

    public static double averageSubjectScore(List<Student> students, Subject subject)  {
        Double averageScore = 0.0;
        int scoreCount = 0;
        for (Student student : students) {
            if(student.getSubjects().contains(subject)){
                List<Integer> grades = StudentUtil.getScoresBySubject(student, subject);
                for (Integer score : grades) {
                    averageScore += score;
                    scoreCount++;
                }
            }
        }
        averageScore = (scoreCount != 0) ? averageScore / scoreCount : averageScore;
        return averageScore;

    }


}
