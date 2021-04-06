package java_error_exceptions.util;

import java_error_exceptions.entity.*;
import java_error_exceptions.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityUtil extends Calculations {

    private static Student searchStudentById(University university, long studentId) throws UniversityDoesNotHaveFacultiesException,
            GroupDoesNotHaveStudentException, FacultyDoesNotHaveGroupsException, NoStudentWithIdException {
        Student student;
        for (Faculty faculty : university.getFaculties()) {
            if ((student = FacultyUtil.searchStudent(faculty, studentId)) != null) {
                return student;
            }
        }
        throw new NoStudentWithIdException("Student with id " + studentId + " not listed");
    }

    public static Double getAverageScoreOfFaculty(University university, String facultyName, Subject subject)
            throws FacultyDoesNotHaveGroupsException, StudentDoesNotHaveSubjectException, GroupDoesNotHaveStudentException,
            UniversityDoesNotHaveFacultiesException, NoFacultyWithNameException {
        Faculty facultyByName;
        Optional<Faculty> optionalFaculty = university.getFaculties().stream().
                filter(faculty -> faculty.getFacultyName().equals(facultyName)).findFirst();
        if (optionalFaculty.isPresent()) {
            facultyByName = optionalFaculty.get();
        } else {
            throw new NoFacultyWithNameException("Faculty with such name doesn`t exist " + facultyName);
        }
        return FacultyUtil.getAverageScoreBySubject(facultyByName, subject);
    }

    private static Group searchGroupByName(University university, String groupName) throws
            UniversityDoesNotHaveFacultiesException, FacultyDoesNotHaveGroupsException {
        for (Faculty faculty : university.getFaculties()) {
            if (FacultyUtil.hasGroup(faculty, groupName)) {
                return faculty.getGroup(groupName);
            }
        }
        return null;
    }

    public static Double getAverageScoreOfGroup(University university, String groupName, Subject subject)
            throws GroupDoesNotHaveStudentException, StudentDoesNotHaveSubjectException,
            UniversityDoesNotHaveFacultiesException, FacultyDoesNotHaveGroupsException {
        Group group;
        Double averageGrade = 0.0;

        if ((group = searchGroupByName(university, groupName)) != null) {
            averageGrade = GroupUtil.getAverageScoreBySubject(group, subject);
        }
        return averageGrade;
    }

    public static List<Student> getStudentsOfUniversity(University university) throws FacultyDoesNotHaveGroupsException,
            GroupDoesNotHaveStudentException, UniversityDoesNotHaveFacultiesException {
        ArrayList<Student> students = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            students.addAll(FacultyUtil.getStudentsOfFaculty(faculty));
        }
        return students;
    }

    public static Double getAverageScoreOfUniversity(University university, Subject subject)
            throws GroupDoesNotHaveStudentException, StudentDoesNotHaveSubjectException,
            FacultyDoesNotHaveGroupsException, UniversityDoesNotHaveFacultiesException {
        return averageSubjectScore(getStudentsOfUniversity(university), subject);
    }

    public static void getStudentList(University university) throws UniversityDoesNotHaveFacultiesException,
            FacultyDoesNotHaveGroupsException, GroupDoesNotHaveStudentException {
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    System.out.println(student.getName() + " " + student.getSecondName() + " "
                            + student.getStudentId() + " "
                            + student.getScores().getSubjectScore());

                }
            }
        }
    }

}
