package generators;

import classes.Nationality;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class NameGenerator {

    private static String[] polishNames = getFromFile("tmp/PolishNames.txt");
    private static String[] polishSurnames = getFromFile("tmp/PolishSurnames.txt");

    public static String genName(Nationality n) {
        int num = genNumber();
        String name="";
        switch (n){
            case POLISH:
                name = polishNames[num];
                break;
//            case SLOVAK:
//                break;
//            case INDIAN:
//                break;
//            case BRITISH:
//            case LATVIAN:
//                break;
//            case JAPANESE:
//                break;
//            case UKRANIAN:
//                break;
//            case LITHUANIAN:
//                break;
//            case VIETNAMESE:
//                break;
//            case BELARUSSIAN:
//                break;
        }
        return name;
    }

    public static String genLastName(Nationality n) {
        int num = genNumber();
        String surname="";
        switch (n){
            case POLISH:
                surname = polishSurnames[num];
                break;
            case SLOVAK:
                break;
            case INDIAN:
                break;
            case BRITISH:
            case LATVIAN:
                break;
            case JAPANESE:
                break;
            case UKRANIAN:
                break;
            case LITHUANIAN:
                break;
            case VIETNAMESE:
                break;
            case BELARUSSIAN:
                break;
        }

        return surname;
    }


    public static int genNumber() {
        Random rand = new Random();
        return rand.nextInt(40);
    }

    public static String[] getFromFile(String path) {
        File file= new File(path);
        String[] arr = new String[40];
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp = reader.readLine();
            while(tmp !=null) {
                arr[index] = tmp;
                index++;
                tmp = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println();
        }

        return arr;
    }
}
