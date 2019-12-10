import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pesel {

    private static boolean validation(String pesel) {
        int peselLen = pesel.length();
        if(peselLen != 11) {
            return false;
        }

        int[] num = new int[peselLen];

        for (int i = 0; i < peselLen; i++) {
            num[i] = Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
        int check;
        int lastDig = num[0] + num[1] * 3 + num[2] * 7 + num[3] * 9 + num[4] + num[5] * 3 + num[6] * 7 + num[7] * 9 + num[8] + num[9] * 3;
        if (lastDig % 10 == 0 ) {
            check = 0;
        } else {
            check = 10 - (lastDig % 10);
        }
        return check == num[10];
    }

    private static Date getDate(String pesel) {
        String fullDate = pesel.substring(0,6);
        String year = fullDate.substring(0,2);
        int fullYear = 0;
        int day = Integer.parseInt(fullDate.substring(4,6));
        int monthValue = Integer.parseInt(fullDate.substring(2,4));
        int month = 0;
        if(monthValue <= 12) {
            fullYear = Integer.parseInt("19" + year);
            month = monthValue;
        } else if(monthValue <= 32) {
            fullYear = Integer.parseInt("20" + year);
            month = monthValue - 20;
        } else if(monthValue <= 52) {
            fullYear = Integer.parseInt("21" + year);
            month = monthValue - 40;
        } else if(monthValue <= 72) {
            fullYear = Integer.parseInt("22" + year);
            month = monthValue - 60;
        } else if(monthValue <= 92) {
            fullYear = Integer.parseInt("18" + year);
            month = monthValue - 80;
        }

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(fullYear, month, day);
//        return calendar.getTime();
        Date d = null;
        try {
             d = new SimpleDateFormat("yyyy-MM-dd").parse(fullYear+"-"+(month+1)+"-"+day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    private static Sex getSex(String pesel) {
        int sexValue = Integer.parseInt(pesel.substring(9,10));
        if(sexValue % 2 == 0){
            return Sex.FEMALE;
        } else {
            return Sex.MALE;
        }
    }
}
