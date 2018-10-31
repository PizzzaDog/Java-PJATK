public class Arr_random_select{
    public static void main (String[] args){
        int[] arr = {};
        int i;
        int n=1;
        for (i = 0; i < 10; i++) {
            arr[i] = n;
            n++;
            System.out.println(arr[i]);
        }
        int s1 = (int)(Math.random()*arr.length);
        int s2 = (int)(Math.random()*arr.length);
        int temp = arr[s1];
        arr[s1]= arr[s2];
        arr[s2]=temp;

    }
}