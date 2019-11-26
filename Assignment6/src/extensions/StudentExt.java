package extensions;

import classes.Nationality;
import classes.Person;
import classes.Student;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class StudentExt {

    public static List<Student> _studentsList = new ArrayList<>();
    public static void addToPersonHashSet(Student e) {
        if(!_studentsList.contains(e)) {
            _studentsList.add(e);
        }
        //sortStudentList();
    }

    public static void sortStudentList() {
        List<Student> temp = new ArrayList<>(_studentsList);
        Collator coll = Collator.getInstance(new Locale("pl","PL"));
        Collections.sort(temp, coll);
    }

    public static List<Student> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Student> p = new ArrayList<>(_studentsList);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public static void sortByLocale(Nationality nationality) {
        List<Student> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }
}
