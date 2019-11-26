package generators;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PeselGenerator {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
    public static Random rand = new Random();

    public static String generatePesel(Date date){
        String datePart = dateFormat.format(date);
        String randPart = String.valueOf(rand.nextInt((9999 - 1000) + 1) + 1000);
        String withoutLast = datePart + randPart;
        int[] num = new int[withoutLast.length()];

        for (int i = 0; i < withoutLast.length(); i++ ){
            num[i] = Integer.parseInt(String.valueOf(withoutLast.charAt(i)));
        }

        int lastDig = num[0] + num[1] * 3 + num[2] * 7 + num[3] * 9 + num[4] + num[5] *3 + num[6] * 7+ num[7] * 9 + num[8] + num[9] * 3;
        int last;
        if (lastDig % 10 == 0 ) {
            last = 0;
        } else {
            last = 10 - (lastDig % 10);
        }

        String strPesel = datePart + randPart + last;
        return strPesel;
    }

}
