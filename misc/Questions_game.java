import java.util.Scanner;

public class Questions_game {
    public static void main(String[] args) {
        Scanner sсan = new Scanner(System.in);
        String letter = " ";
        double max = 1000000;
        double mid = max / 2;
        double min = 1;
        int tr = 0;
        while (!(letter.equals("y"))) {
            System.out.println(" Is this n " + mid + "?");
            tr++;
            letter = scan.next();
            if (letter.equals("s")) {
                min = mid;
            } else if (letter.equals("b")) {
                max = mid;
            }
            mid = (min + max) / 2;
        }
        System.out.println("Number that you think of is " + mid + ". Number of trials: " + tr);
    }
}
