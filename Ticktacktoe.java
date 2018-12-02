import java.util.Scanner;
public class Ticktacktoe{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = 0b0_0000_0000_0_0000_0000;// fist 1-9 bits - null or filled 
        int p;                             // 10-18: 0 - 0, 1 - x
        boolean okay= true;
        int count = 0;
        int x = 0; 
        while(okay){
            for( int k = 0; k < 5; k++){ //print grid 
                if(k == 0 || k == 2 || k == 4) {
                    for( int y = 0; y < 5; y++){
                        if(y == 0 || y == 2 || y == 4) {
                            if((a & (1 << x)) != 0 ) {
                                if((a & (1 << (x+9))) !=0){
                                    System.out.print("x");
                                } else {
                                    System.out.print("0");
                                }
                            }
                            System.out.print(" ");//logic
                        } else {
                            System.out.print(" | ");
                            x++;
                        }
                    }     
                    System.out.println();
                } else {
                    System.out.print("----------");
                    System.out.println();
                }
            }
            p = scan.nextInt();
            if(count % 2 == 0){
                a += 1 << (p-1);
                a += 1 << (p+9);
            } else {
                a += 1 << (p-1);
            }
                
        count++;    
        if(count == 8){
            okay = false;
        } 
    }
    }
}

    
