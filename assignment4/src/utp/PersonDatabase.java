package utp;

import Comporators.*;
import java.io.File;
import java.util.*;

public final class PersonDatabase {
    public List<Person> tmp;
    Map<Date,Person> m = null;


    public List<Person> sortedByFirstName() {
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
        Collections.sort(tmp, new FirstNameComparator());
        return tmp;
    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
        Collections.sort(tmp, Comparator.naturalOrder());
        return tmp;
    }

    public List<Person> sortedByBirthdate() {
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
        Collections.sort(tmp, new BirthdateComparator());
        return tmp;
    }

    public List<Person> bornOnDay(Date date) {
        List<Person> t = new ArrayList<>();
        tmp = InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt"));
        Map<Date, Person> m = createMap(tmp);
                m.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(date))
                .forEach(e -> t.add(e.getValue()));
        return t;
    }

    public Map<Date, Person> createMap(List<Person> tmp) {
        m = new HashMap<>();
        for (Person p: tmp) {
            m.put(p.get_birthdate(), p);
        }
        return m;
    }

    @Override
    public String toString(){
        return Arrays.toString(tmp.toArray());
    }
}