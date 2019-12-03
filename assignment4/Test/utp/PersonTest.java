package utp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


class PersonTest {

    @Test
    void serializeAndDeserialize() {
        Person p;
        Person p1;

        try {
            p = new Person("Alice", "Lashuk", new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12"));
            p.serialize(new DataOutputStream(new FileOutputStream(new File("test.txt"))));
            p1 = Person.deserialize(new DataInputStream(new FileInputStream(new File("test.txt"))));
            Assertions.assertEquals(p.get_firstName(), p1.get_firstName());
            Assertions.assertEquals(p.get_surname(), p1.get_surname());
            Assertions.assertEquals(p.get_birthdate(), p1.get_birthdate());
        } catch (Assignment08Exception e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}