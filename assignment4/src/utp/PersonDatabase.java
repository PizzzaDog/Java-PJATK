package utp;

import Comporators.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
    private List<Person> tmp;
    Map<Date,List<Person>> map = null;
    public PersonDatabase() {
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
    }

    // assignment 8 - factory method based on deserialization
    public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception {
        PersonDatabase database = new PersonDatabase();
        List<Person> desList = new ArrayList<>();

        Person p = Person.deserialize(input);
        while (p != null) {
            desList.add(p);
            p = Person.deserialize(input);
        }
        database.setList(desList);
        return database;
    }

    public List<Person> getList() {
        return tmp;
    }

    private void setList(List<Person> tmp) {
        this.tmp = tmp;
    }

    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {
        try {
            tmp.forEach(e -> {
                        try {
                            e.serialize(output);
                        } catch (Assignment08Exception ex) {
                            ex.printStackTrace();
                        }
                    });
        } catch (Throwable exception) {
            throw new Assignment08Exception(exception.getMessage(), exception.getCause());
        }
    }

    public List<Person> sortedByFirstName() {
        Collections.sort(tmp, new FirstNameComparator());
        return tmp;
    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        Collections.sort(tmp, Comparator.naturalOrder());
        return tmp;
    }

    public List<Person> sortedByBirthdate() {
        Collections.sort(tmp, new BirthdateComparator());
        return tmp;
    }

    public List<Person> bornOnDay(Date date) {
        createMap(tmp);
        return map.get(date);
    }

    public Map<Date, List<Person>> createMap(List<Person> people) {
       return map = people.stream().collect(Collectors.groupingBy(Person::get_birthdate,Collectors.toList()));
    }

    @Override
    public String toString(){
        return Arrays.toString(tmp.toArray());
    }
}