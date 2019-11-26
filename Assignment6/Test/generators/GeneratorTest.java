package generators;

import extensions.StudentExt;
import extensions.TeacherExt;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void generateStudent() {
        for (int i = 0; i < 100; i++) {
            Generator.generateStudent();
        }
        assertEquals(100,  StudentExt._studentsList.size());
    }

    @Test
    public void generateTeachers(){
        for (int i = 0; i < 10; i++) {
            Generator.generateTeacher();
        }
        assertEquals(10, TeacherExt._teachersList.size());
    }

    @Test
    void generateDepartment() {
    }

    @Test
    void generateStudentGroup() {
    }

    @Test
    void generateSubject() {
    }
}