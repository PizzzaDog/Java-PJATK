package utp;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonDatabaseTest {

    @Test
    void sortedByFirstName() {
        PersonDatabase a = new PersonDatabase();
        a.sortedByFirstName();
        System.out.println(a.toString());
    }
    @Test
    void sortedByBirthdate() {
        PersonDatabase a = new PersonDatabase();
        a.sortedByBirthdate();
        System.out.println(a.toString());
    }

    @Test
    void sortedBySurnameFirstNameAndBirthdate() {
        PersonDatabase a = new PersonDatabase();
        a.sortedBySurnameFirstNameAndBirthdate();
        System.out.println(a.toString());
    }

    @Test
    void bornOnDay(){
        PersonDatabase a = new PersonDatabase();
        try {
            System.out.println(a.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12")).toString());
        } catch(ParseException e) {
            System.out.println(e);
        }

        //System.out.println(a.bornOnDay(new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-12")));
    }
}