package extensions;

import classes.Nationality;
import classes.Person;
import classes.Teacher;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class TeacherExt {
    public static ArrayList<Teacher> _teachersList = new ArrayList<>();

    public static void addToPersonHashSet(Teacher e) {
        if(!_teachersList.contains(e)) {
            _teachersList.add(e);
        }
       // sortHashSet();
    }

    public static void sortTeacherList() {
        Collator coll = Collator.getInstance(new Locale("pl","PL"));
        Collections.sort(_teachersList, coll);
    }

    public static List<Teacher> filterByLocale(Nationality nationality) {
        Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Teacher> p = new ArrayList<>(_teachersList);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public void sortByLocale(Nationality nationality) {
        List<Teacher> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }
}
