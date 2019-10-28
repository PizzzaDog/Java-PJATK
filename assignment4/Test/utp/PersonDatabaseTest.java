package utp;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class PersonDatabaseTest {

    @Test
    void sortedByFirstName() {
        System.out.println("Sort by first name");
        PersonDatabase a = new PersonDatabase();
        a.sortedByFirstName();
        System.out.println(a.toString());
    }
    @Test
    void sortedByBirthdate() {
        System.out.println("sortedByBirthdate");
        PersonDatabase a = new PersonDatabase();
        a.sortedByBirthdate();
        System.out.println(a.toString());
    }

    @Test
    void sortedBySurnameFirstNameAndBirthdate() {
        System.out.println("sortedBySurnameFirstNameAndBirthdate");
        PersonDatabase a = new PersonDatabase();
        a.sortedBySurnameFirstNameAndBirthdate();
        System.out.println(a.toString());
    }

    @Test
    void bornOnDay(){
        System.out.println("Sort by first name");
        PersonDatabase a = new PersonDatabase();
        try {
            System.out.println(a.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12")).toString());
        } catch(ParseException e) {
            System.out.println(e);
        }
    }
}