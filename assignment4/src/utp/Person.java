package utp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Date;

public class Person implements Comparable<Person> {

    private final String _firstName;
    private final String _surname;
    private final Date _birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        _firstName = firstName;
        _surname = surname;
        _birthdate = birthdate;
    }

    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {
        try {
            output.writeUTF(get_firstName());
            output.writeUTF(get_surname());
            output.writeLong(get_birthdate().getTime());
        } catch (Throwable exception) {
            throw new Assignment08Exception(exception.getMessage(), exception.getCause());
        }
    }

    public static Person deserialize(DataInputStream input) throws Assignment08Exception {
        String name;
        String surname;
        long g;
        try {
            if(input.available() > 0) {
                name = input.readUTF();
                surname = input.readUTF();
                g = input.readLong();
            } else {
                return null;
            }
        } catch (Throwable exception) {
            throw new Assignment08Exception(exception.getMessage(), exception.getCause());
        }
        return new Person(name,surname,new Date(g));
    }


    public String get_firstName() {
        return _firstName;
    }

    public String get_surname() {
        return _surname;
    }

    public Date get_birthdate() {
        return _birthdate;
    }

    @Override
    public int compareTo(Person otherPerson) {
       if(_surname.compareTo(otherPerson.get_surname()) > 0 ) {
            return 1;
       } else if (_surname.compareTo(otherPerson.get_surname()) < 0) {
           return -1;
       } else if (_firstName.compareTo(otherPerson.get_firstName()) > 0) {
           return 1;
       } else if (_firstName.compareTo(otherPerson.get_firstName()) < 0) {
            return -1;
       } else if (_birthdate.compareTo(otherPerson.get_birthdate()) > 0) {
           return 1;
       } else if (_birthdate.compareTo(otherPerson.get_birthdate()) < 0) {
           return -1;
       }
       return 0;
    }

    @Override
    public String toString(){
        return _firstName + " " + _surname + " " +_birthdate;
    }
}