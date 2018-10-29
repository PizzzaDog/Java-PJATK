import java.util.Scanner;

public class Largest_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int curDig = 0;
        int maxVal = 0;
        int max = 0;
        int lastN = 0;
        int maxLast = 0;
        while (n != 0) {
            while (n >= 10) {
                curDig = n % 10;
                max = max + curDig;
                n = (n - curDig) / 10;
            }
                 maxLast = max + n;
            if (maxLast > maxVal) {
                maxVal = maxLast;
            }
            n = sc.nextInt();
        }
        System.out.println("Max sum of digits was " + maxVal + "for ");

        sc.close();
    }
}