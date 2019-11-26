package classes;

import extensions.StudentGroupExt;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StudentGroup {

    private  Group _group;
    private final List<Student> _studentsList;

    public StudentGroup(Group name, List<Student> studentsList ) {
        _group = name;
        _studentsList = studentsList;
        StudentGroupExt.addToGroupList(this);
    }

    public Group getName() {
        return _group;
    }

    public List<Student> getStudentsList() {
        return _studentsList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return _group == that._group &&
                Objects.equals(_studentsList, that._studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_group, _studentsList);
    }
}
