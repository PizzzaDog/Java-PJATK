package utp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

    public static BufferedReader reader;
    private static final Pattern FULL = Pattern.compile("([a-zA-Z]+) ([a-zA-Z]+) (\\d{4}-\\d{2}-\\d{2})");

    public static List<Person> parse(File file) {
        List<Person> people = new ArrayList<>();
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            Matcher fullMatch;
            while((line = reader.readLine())!= null) {
                fullMatch = FULL.matcher(line);
                if(fullMatch.matches()){
                    people.add(new Person(fullMatch.group(1), fullMatch.group(2), parseDate(fullMatch.group(3))));
                }

            }
        } catch(IOException e) {
            System.out.println(e);
        }

        return people;
    }

    public static Date parseDate(String input) {
        Date d = null;
        try {
             d = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return d;
    }

}