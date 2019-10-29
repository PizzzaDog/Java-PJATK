package utp;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class PersonDatabaseTest {
    PersonDatabase p = new PersonDatabase();

    @Test
    void sortedByFirstName() {
        System.out.println("Sort by first name");
        p.sortedByFirstName();
        System.out.println(p.toString());
    }
    @Test
    void sortedByBirthdate() {
        System.out.println("sortedByBirthdate");
        p.sortedByBirthdate();
        System.out.println(p.toString());
    }

    @Test
    void sortedBySurnameFirstNameAndBirthdate() {
        System.out.println("sortedBySurnameFirstNameAndBirthdate");
        p.sortedBySurnameFirstNameAndBirthdate();
        System.out.println(p.toString());
    }

    @Test
    void bornOnDay(){
        System.out.println("born on day");
        try {
            System.out.println(p.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12")).toString());
        } catch(ParseException e) {
            System.out.println(e);
        }
    }
}