import java.util.Scanner;
import java.util.ArrayList;
class Person{
    private String name;
    private int yearOfBirth;
    public Person(String n, int y) {
        name = n;
        yearOfBirth = y;
    }
    public static boolean findInColl(Collection<Person> coll, String name, int year){
        coll.contains()
    }
    @Override 
    public String toString(){
        return "name: " + name + " yearOfBirth: " + yearOfBirth;
    }
}

public class Task_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int y;
        ArrayList<Person> list= new ArrayList<Person>();
        while(!name.equals("end")){
            //TODO: ecxeption
            y =  Integer.parseInt(scan.next());
            list.add(new Person(name, y));
            name = scan.next();
        }
        
        for (Person a : list) {
            System.out.println(a);
        }
    }

}