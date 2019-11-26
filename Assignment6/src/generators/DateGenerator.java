package generators;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {

    public static Random random = new Random();
    public static final int RANGE = 50;
    public static final int START_YEAR = Calendar.getInstance().get(Calendar.YEAR) - RANGE;

    public static Date genDate(String type){
        int year = START_YEAR + random.nextInt(50);
        if (type.equals("hire")){
            year += 25;
        }
        int month = random.nextInt(12) + 1;
        int day = 1 + random.nextInt(31) + 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}