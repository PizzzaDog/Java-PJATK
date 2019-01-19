import java.io.*;

import frt.Fruit;

public class FruitMain {
    public static void main(String[]args){
        Fruit a = new Fruit("Watermellon", 153859);
        Fruit b = new Fruit("Apple", 6);
        try {  
            FileOutputStream f = new FileOutputStream("/Users/alice/Coding/Java/new1file.txt");
            String aName = a.getName();
            String bName = b.getName();
            String aData =  "" +a.getNumber();
            String bData = ""+b.getNumber();
            f.write((aName+" ").getBytes());
            //f.write((aData+" ").getBytes());
            f.write((bName+" ").getBytes());
            //f.write(bData.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

        try{
            FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/new1file.txt");// path
            int wrt = fis.read();
            String n ="";
            while(wrt!= -1){
                n+=(char)wrt;
                //System.out.println((char)wrt);
                wrt = fis.read();
            }
            System.out.println(n);
     } catch (FileNotFoundException ex){
         System.out.println(ex);
     }catch(IOException ex){
         System.out.println(ex);
     }
    }
} 