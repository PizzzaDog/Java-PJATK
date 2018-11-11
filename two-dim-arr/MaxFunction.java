public class MaxFunction{
    public static void main(String[] args){
        int[][] arr = { {1,3}, {3,4,5,8}, {6,8}, {1,9,6} };
        int res;
        res = FindLargest(arr[][]);
        System.out.println(res);
    }

    public static int FindLargest (int []){
        int [] brr =new int [arr.length];
        int max = arr[0][0];
        int i=0;
        int b=0;
        for (i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[k].length; k++) {
                    if(arr[i][k]>=max){
                        max = arr[i][k];
                    }
            }
                brr[b] = (max);
                System.out.println(brr[b]);
                b++;

            max = 0;

        }
        for (int c=0; c< brr.length; c++){
           val+= " "+brr[c];
        }
        return val;
    }
}