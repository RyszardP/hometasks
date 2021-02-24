package java_error_exceptions.entity;

import java_error_exceptions.exceptions.FacultyDoesNotHaveGroupsException;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
    private String FacultyName;
    private final Set<Group> groups;

    public Faculty(String facultyName) {
        FacultyName = facultyName;
        groups = new TreeSet<>();
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public Set<Group> getGroups() throws FacultyDoesNotHaveGroupsException {
        if(groups.isEmpty()){
            throw new FacultyDoesNotHaveGroupsException("The faculty" + getFacultyName() + " is empty");
        }
        return groups;
    }

    public void setGroup(String groupName) {
        groups.add(new Group(groupName));
    }

    public Group getGroup(String groupName) throws FacultyDoesNotHaveGroupsException {
        Optional<Group> optionalGroup = getGroups().stream().
                filter(group -> group.getGroupName().equals(groupName)).findFirst();
        return optionalGroup.orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return FacultyName.equals(faculty.FacultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FacultyName);
    }

    @Override
    public String toString() {
        return "Faculty{" + "FacultyName='" + FacultyName + '\'' +
                '}';
    }
}
