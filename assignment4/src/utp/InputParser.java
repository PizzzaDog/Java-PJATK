package utp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class InputParser {

    // 1. Use regular expresssions (Pattern) for validating input data

    //
    // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"

    public static BufferedReader reader;
    public static List<Person> people = new ArrayList<>();
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]*$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");


    public static List<Person> parse(File file) {
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));

            while((line = reader.readLine())!= null) {
                String[] arr = line.split(" ");
                if(NAME_PATTERN.matcher(arr[0]).matches()
                        && NAME_PATTERN.matcher(arr[1]).matches()
                        && DATE_PATTERN.matcher(arr[2]).matches()) {
                    addPerson(arr[0],arr[1], parseDate(arr[2]));
                }
            }
        } catch(IOException e) {
            System.out.println(e);
        }

        return people;
    }

    public static void addPerson(String name, String surname, Date dateOfBirths) {
        people.add(new Person(name, surname, dateOfBirths));
    }

    public static Date parseDate(String input) {
        Date d = null;
        try {
             d = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        }catch (ParseException e) {
            System.out.println(e);
        }
        return d;
    }

}