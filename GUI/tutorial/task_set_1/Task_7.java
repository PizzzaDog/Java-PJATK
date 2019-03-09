import java.util.Scanner;

import java.io.*;
public class Task_7 {
    public static void main(String[] args) {
        File file = null;
        FileWriter f = null;
        Scanner scan = null;
        try {
            file = new File("/Users/alice/Coding/Java/GUI/tutorial/task_set_1/A.txt");
            f = new FileWriter("out.txt");
            scan = new Scanner(file);
        } catch (Exception e) {
            System.out.println(e);
        }
        boolean x = true;
        while(x){
            if (scan.hasNextInt() && scan.hasNextInt()){
                try {
                    f.write(scan.nextInt()+scan.nextInt());
                    f.write("test string");
                } catch(IOException e) {
                    System.out.println(e);
                }
                //System.out.println(a+b);

            }else if (scan.hasNextDouble() || scan.hasNextDouble()){
                try {
                    f.write(Double.toString(scan.nextDouble()+scan.nextDouble()));
                } catch(IOException e) {
                    System.out.println(e);
                }
                //System.out.println(c+d);
            }else {
                x = false;
            }
        }


       /* try{
            FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/GUI/tutorial/task_set_1/B.txt");// path
            int wrt = fis.read();
            String a ="";
            while(wrt!= -1){
                a+=(char)wrt;
                //System.out.println((char)wrt);
                wrt = fis.read();
            }
            System.out.println(a);
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
*/
    }

    }
