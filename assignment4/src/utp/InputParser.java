package utp;

import java.io.*;
import java.util.List;

public final class InputParser {

    // 1. Use regular expresssions (Pattern) for validating input data

    //
    // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"

    public static List<Person> parse(File file) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("file"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e ) {
            System.out.println
        }
        return null;
    }
}