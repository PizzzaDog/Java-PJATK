import java.io.*;
public class Display{

    public static void main(String[] args){
       try{
           FileInputStream fis = new FileInputStream("/Users/alice/Coding/Java/Text.txt");// path
           int wrt = fis.read();
           while(wrt!= -1){
               System.out.println((char)wrt);
               wrt = fis.read();
           }
    } catch (FileNotFoundException ex){
        System.out.println(ex);
    }catch(IOException ex){
        System.out.println(ex);
    }
}
}