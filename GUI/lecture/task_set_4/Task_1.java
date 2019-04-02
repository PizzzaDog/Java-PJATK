import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;
class Person{
    private String name;
    private int yearOfBirth;
    public Person(String n, int y) {
        name = n;
        yearOfBirth = y;
    }
    public static boolean findInColl(Collection<Person> coll, String name, int year){
        Person tmp = new Person(name, year);
        return coll.contains(tmp);
    }
    @Override 
    public String toString(){
        return "name: " + name + " yearOfBirth: " + yearOfBirth;
    }

   @Override 
   public boolean equals(Object other){
       if(other == null || getClass()!= other.getClass()) {
           return false;
       }
       Person p = (Person)other;
        return yearOfBirth==p.yearOfBirth && name.equals(p.name);
       }
}

public class Task_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int y;
        String tmp;
        int count = 0;
        ArrayList<Person> list= new ArrayList<Person>();
        while(!name.equals("end")){
            //TODO: ecxeption
            tmp = scan.next();

            for(int i = 0; i < tmp.length(); i++){
                if(!Character.isDigit(tmp.charAt(i))){
                    count++;
                }
            }

            if (count != 0){
                throw new NumberFormatException(); 
            }else {
                y =  Integer.parseInt(tmp);
            }
            
            list.add(new Person(name, y));
            name = scan.next();
        }
        
        for (Person a : list) {
            System.out.println(a);
        }

        System.out.println(Person.findInColl(list, "alice", 2000));
    }

}