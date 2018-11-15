import java.util.Random;

public class Array_put {
    public static void main(String[] args) {
        Random rand = new Random();
        int ran1 = rand.nextInt(); 
        int[] arr = new int[ran1];
        int i;

        for (i = 0; i < arr.length; i++) {
            int ran2 = rand.nextInt(); 
            arr[i] = ran2;
            System.out.println(arr[i]);
        }

    }
}