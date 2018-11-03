import java.util.Scanner;
import javax.swing.JOptionPane;
public class Divisors{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int pr=2;
        for(int i = 2; i<n; i++){

            if(n % i == 0){
                System.out.println(i);
            }
            else pr++;
        }
        if(pr==n){
            System.out.println("The number is prime");
        }
        scan.close();
        
    }
}