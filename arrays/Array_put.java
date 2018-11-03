public class Array_put {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int i;

        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*arr.length);
            System.out.println(arr[i]);
        }
    }
}