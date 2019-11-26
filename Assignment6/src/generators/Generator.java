package generators;

import classes.*;
import extensions.DepartmentExt;
import extensions.StudentExt;
import extensions.TeacherExt;

import java.util.*;

public class Generator {

    public static int _studentID = 1;
    public static Random rand;
    public static int depCount = 0;
    public static int groupCount = 0;
    public static int subjectCount = 0;

    public static Student generateStudent(){
        Date dateOfBirth = DateGenerator.genDate("birth");
        Nationality nationality = Nationality.genValue();
        int studentId = _studentID;
        _studentID++;
        String firstName = NameGenerator.genName(nationality);
        String lastName = NameGenerator.genLastName(nationality);
        Student student = new Student(firstName, lastName, dateOfBirth, nationality, PeselGenerator.generatePesel(dateOfBirth),studentId);
        return student;
    }

    public static Teacher generateTeacher(){
        Date dateOfBirth = DateGenerator.genDate("birth");
        Nationality nationality = Nationality.genValue();
        String firstName = NameGenerator.genName(nationality);
        String lastName = NameGenerator.genLastName(nationality);
        Date hireDate = DateGenerator.genDate("hire");
        Degree degree = Degree.genValue();
        Teacher teacher = new Teacher(firstName, lastName, dateOfBirth, nationality, hireDate, degree, PeselGenerator.generatePesel(dateOfBirth));
        return teacher;
    }

    public static Department generateDepartment() {
        Dep name = Dep.values()[depCount];
        depCount++;
        int n = 3;
        Teacher[] teachers = new Teacher[n];
        for (int i = 0; i < n; i++) {
            teachers[i] = generateTeacher();
        }
        List<Teacher> list = Arrays.asList(teachers);
        Department department = new Department(name, list);
        return department;
    }

    public static StudentGroup generateStudentGroup() {
        Group studentGroupName = Group.values()[groupCount];
        groupCount++;
        int n = rand.nextInt((10 - 8) + 1) + 8;
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = generateStudent();
        }
        List<Student> list = Arrays.asList(students);
        StudentGroup studentGroup = new StudentGroup(studentGroupName,list);
        return studentGroup;
    }

    public static Subject generateSubject() {
        Department dep = DepartmentExt._depList.get(rand.nextInt(DepartmentExt._depList.size()));
        Teacher teacher = TeacherExt._teachersList.get(rand.nextInt(TeacherExt._teachersList.size()));
        SubjectEnum subjectName = SubjectEnum.values()[subjectCount];
        subjectCount++;
        int n = 10;
        Student[] students = new Student[10];
        List<Student> tmp = new ArrayList<>(StudentExt._studentsList);
        for (int i = 0; i < n; i++) {
            students[i] = tmp.get(rand.nextInt(StudentExt._studentsList.size()));
        }
        List<Student> studentsSubject = Arrays.asList(students);
        Subject subject = new Subject(subjectName, dep, teacher, studentsSubject);
        return subject;
    }

}
