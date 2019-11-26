package extensions;

import classes.Nationality;
import classes.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class PersonExt {

    public static List<Person> _personList = new ArrayList<>();

    public static void addPersonToList(Person p) {
        if(!_personList.contains(p)){
           _personList.add(p);
        }
       //sortPersonList();
    }

    public static void sortPersonList() {
        Collator coll = Collator.getInstance(new Locale("PL"));
        Collections.sort(_personList, coll);
    }

    public static List<Person> filterByLocale(Nationality nationality) {
        //Locale temp = new Locale(nationality.get_locale().getLanguage());
        List<Person> p = new ArrayList<>(_personList);
        return p
                .stream()
                .filter(e -> e.get_nationality().get_locale() == nationality.get_locale())
                .collect(Collectors.toList());
    }

    public static void sortByLocale(Nationality nationality) {
        List<Person> filtered = filterByLocale(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.get_locale().getLanguage(), nationality.get_locale().getCountry()));
        Collections.sort(filtered,coll);
    }

}
