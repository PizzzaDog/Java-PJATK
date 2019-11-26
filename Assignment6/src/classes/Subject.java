package classes;

import extensions.SubjectExt;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Subject {

    private SubjectEnum _name;
    private Department _supervisingDep;
    private Teacher _lecturer;
    private List<Student> _students;

    public Subject(SubjectEnum name, Department supervisingDepartment, Teacher lecturer, List<Student> studentList) {
        _name = name;
        _supervisingDep = supervisingDepartment;
        _lecturer = lecturer;
        _students = studentList;
        SubjectExt.addToSubjectList(this);
    }

    public SubjectEnum getName() {
        return _name;
    }

    public Department get_supervisingDep() {
        return _supervisingDep;
    }

    public Teacher get_lecturer() {
        return _lecturer;
    }

    public List<Student> get_students() {
        return _students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(_name, subject._name) &&
                Objects.equals(_supervisingDep, subject._supervisingDep) &&
                Objects.equals(_lecturer, subject._lecturer) &&
                Objects.equals(_students, subject._students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name, _supervisingDep, _lecturer, _students);
    }
}
