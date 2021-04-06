package java_error_exceptions.entity;

import java_error_exceptions.exceptions.ScoresMustBeInRangeException;
import java_error_exceptions.util.RandomNames;

import java.util.*;

public class Student {
    private static long studentsCount = 0;

    private String name;
    private String secondName;
    private long studentId;
    private EnumSet<Subject> subjects;
    private Score scores;

    public Student() {
    }


    public Student(String name, String secondName, EnumSet<Subject> subjects) {
        this.name = name;
        this.secondName = secondName;
        this.subjects = subjects;
        scores = new Score();
        studentId = studentsCount;
        studentsCount++;
    }

    public class Score {
        private final EnumMap<Subject, List<Integer>> subjectScore = new EnumMap<>(Subject.class);

        public Score() {
            for (Subject subject : subjects) {
                subjectScore.put(subject, new ArrayList<>());
            }
        }

        public EnumMap<Subject, List<Integer>> getSubjectScore() {
            return subjectScore;
        }


        private void setSubject(Subject subject) {
            if (subjects.contains(subject)) {
                subjectScore.put(subject, new ArrayList<>());
            }
        }

        private void setScore(Subject subject, int score)
                throws ScoresMustBeInRangeException {
            if ((score >= 0) && (score <= 10)) {
                List<Integer> grades = subjectScore.get(subject);
                grades.add(score);
                subjectScore.put(subject, grades);
            } else {
                throw new ScoresMustBeInRangeException("Score " + score + " invalid value");
            }
        }

        @Override
        public String toString() {
            return subjectScore.toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }


    public EnumSet<Subject> getSubjects() {
        return subjects;
    }

    public void setSubject(Subject subject) {
        subjects.add(subject);
        scores.setSubject(subject);
    }

    public void setScore(Subject subject, int score) throws ScoresMustBeInRangeException{
        if (!getSubjects().contains(subject)) {
            setSubject(subject);
        }
        scores.setScore(subject, score);
    }

    public Score getScores() {
        return scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    public static Student createStudent() {
        return new Student(RandomNames.getRandomName(), RandomNames.getRandomSecondName(),
                EnumSet.of(Subject.getRandomSubject(), Subject.getRandomSubject(), Subject.getRandomSubject()));
    }

}
