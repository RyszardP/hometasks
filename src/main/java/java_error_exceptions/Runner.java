package java_error_exceptions;

import java_error_exceptions.entity.Faculty;
import java_error_exceptions.entity.Student;
import java_error_exceptions.entity.Subject;
import java_error_exceptions.entity.University;
import java_error_exceptions.exceptions.*;
import java_error_exceptions.init.Initializer;
import java_error_exceptions.init.UniversityInitializer;
import java_error_exceptions.util.StudentUtil;
import java_error_exceptions.util.UniversityUtil;

import java.util.EnumSet;
import java.util.Scanner;


public class Runner {

    private static void getAverageScoreOfStudent(University university) throws StudentDoesNotHaveSubjectException, GroupDoesNotHaveStudentException, FacultyDoesNotHaveGroupsException, UniversityDoesNotHaveFacultiesException {

        Student student = UniversityUtil.getStudentsOfUniversity(university).get(1);
        System.out.println("Average student score" + student.getName() + " " + student.getSecondName() +
                "(ID " + student.getStudentId() + ")");
        System.out.println(StudentUtil.getAverageScore(student));
    }

    public static void getAverageScoresOfFaculties(University university) throws FacultyDoesNotHaveGroupsException,
            StudentDoesNotHaveSubjectException, UniversityDoesNotHaveFacultiesException,
            GroupDoesNotHaveStudentException, NoFacultyWithNameException {
        System.out.println("Average counts in faculties: ");
        System.out.println("Organic Substances Technology Faculty " +
                UniversityUtil.getAverageScoreOfFaculty(university,
                        "Organic Substances Technology Faculty", Subject.MATHEMATICS));
        System.out.println("Chemical Technology and Engineering Faculty " +
                UniversityUtil.getAverageScoreOfFaculty(university,
                        "Chemical Technology and Engineering Faculty", Subject.MATHEMATICS));
        System.out.println("Faculty of Print Technology and Media Communications " +
                UniversityUtil.getAverageScoreOfFaculty(university,
                        "Faculty of Print Technology and Media Communications", Subject.MATHEMATICS));
        System.out.println("Forestry Faculty " +
                UniversityUtil.getAverageScoreOfFaculty(university, "Forestry Faculty", Subject.MATHEMATICS));
    }

    public static void getAverageScoreOfGroups(University university) throws FacultyDoesNotHaveGroupsException,
            StudentDoesNotHaveSubjectException, UniversityDoesNotHaveFacultiesException,
            GroupDoesNotHaveStudentException, NoFacultyWithNameException {
        System.out.println("Average count of groups by subject " + Subject.MATHEMATICS);
        System.out.println("OST1 " + UniversityUtil.getAverageScoreOfGroup(university, "OST1", Subject.MATHEMATICS));
        System.out.println("OST2 " + UniversityUtil.getAverageScoreOfGroup(university, "OST2", Subject.MATHEMATICS));
        System.out.println("OST3 " + UniversityUtil.getAverageScoreOfGroup(university, "OST3", Subject.MATHEMATICS));
        System.out.println("ChTEF1 " + UniversityUtil.getAverageScoreOfGroup(university, "ChTEF1", Subject.MATHEMATICS));
        System.out.println("ChTEF2 " + UniversityUtil.getAverageScoreOfGroup(university, "ChTEF2", Subject.MATHEMATICS));
        System.out.println("ChTEF3 " + UniversityUtil.getAverageScoreOfGroup(university, "ChTEF3", Subject.MATHEMATICS));
        System.out.println("FoPT1 " + UniversityUtil.getAverageScoreOfGroup(university, "FoPT1", Subject.MATHEMATICS));
        System.out.println("FoPT2 " + UniversityUtil.getAverageScoreOfGroup(university, "FoPT2", Subject.MATHEMATICS));
        System.out.println("FoPT3 " + UniversityUtil.getAverageScoreOfGroup(university, "FoPT3", Subject.MATHEMATICS));
        System.out.println("FF1 " + UniversityUtil.getAverageScoreOfGroup(university, "FF1", Subject.MATHEMATICS));
        System.out.println("FF2 " + UniversityUtil.getAverageScoreOfGroup(university, "FF2", Subject.MATHEMATICS));
        System.out.println("FF3 " + UniversityUtil.getAverageScoreOfGroup(university, "FF3", Subject.MATHEMATICS));
    }

    public static void getAverageScoreOfUniversity(University university) throws FacultyDoesNotHaveGroupsException,
            StudentDoesNotHaveSubjectException, UniversityDoesNotHaveFacultiesException,
            GroupDoesNotHaveStudentException, NoFacultyWithNameException {
        System.out.println("Average score in university by subject " + Subject.MATHEMATICS);
        System.out.println(UniversityUtil.getAverageScoreOfUniversity(university, Subject.MATHEMATICS));
    }


    private static void getExceptions(University university) throws FacultyDoesNotHaveGroupsException,
            StudentDoesNotHaveSubjectException, UniversityDoesNotHaveFacultiesException,
            GroupDoesNotHaveStudentException, NoFacultyWithNameException, ScoresMustBeInRangeException {
        System.out.println("set situation with exception, (1 - 5)");
        Scanner scanner = new Scanner(System.in);
        int exceptionNumber = scanner.nextInt();
        switch (exceptionNumber) {
            case 1:
                System.out.println("Faculty doesn`t exist in university");
                University universityWithoutFaculties = new University();
                System.out.println(UniversityUtil.getStudentsOfUniversity(universityWithoutFaculties));
                break;
            case 2:
                System.out.println("Group doesn`t exist in faculty");
                String facultyWithoutGroups = "Military";
                university.setFaculty(new Faculty(facultyWithoutGroups));
                System.out.println(UniversityUtil.getAverageScoreOfFaculty(university, facultyWithoutGroups,
                        Subject.MATHEMATICS));
                break;
            case 3:
                System.out.println("The group is empty");
                String groupWithoutStudents = "B002";
                university.getFaculties().get(0).setGroup(groupWithoutStudents);
                System.out.println(UniversityUtil.getAverageScoreOfGroup(university, groupWithoutStudents, Subject.MATHEMATICS));
                break;
            case 4:
                System.out.println("Student must have at least one subject");
                Student studentWithoutSubjects = new Student("Jane", "Hopstader", EnumSet.noneOf(Subject.class));
                university.getFaculties().get(2).getGroup("FoPT1").setStudent(studentWithoutSubjects);
                System.out.println(StudentUtil.getAverageScore(studentWithoutSubjects));
                break;
            case 5:
                int incorrectScore = 25;
                System.out.println("Try to input score out of range");
                Student studentWithScoreOutOfRange = UniversityUtil.getStudentsOfUniversity(university).get(5);
                studentWithScoreOutOfRange.setScore(Subject.ELECTRICAL_ENGINEERING, incorrectScore);
                System.out.println(studentWithScoreOutOfRange);
                break;

            default:
                System.out.println("the number is wrong!");
                break;
        }
    }

    public static void main(String[] args) {
        UniversityInitializer universityInitializer = new Initializer();

        try {
            University university = universityInitializer.initializeUniversity();

            getAverageScoreOfStudent(university);
            getAverageScoresOfFaculties(university);
            getAverageScoreOfUniversity(university);
            getAverageScoreOfGroups(university);
            UniversityUtil.getStudentList(university);

            getExceptions(university);

        } catch (FacultyDoesNotHaveGroupsException | StudentDoesNotHaveSubjectException |
                UniversityDoesNotHaveFacultiesException | GroupDoesNotHaveStudentException |
                ScoresMustBeInRangeException | NoFacultyWithNameException e) {
            e.printStackTrace();
        }


    }


}
