import carpkg.*;
import personpkg.*;
public class CarPerson{
    public static void main(String[] args) {
        Car c1 = new Car("m1", 2000);
        Car c2 = new Car("m2", 3000);
        Person p1 = new Person("alice", c1);
        Person p2 = new Person("alice1", c2);
        Person[] prs = {p1,p2};

        System.out.println(Person.getCars(prs));
        System.out.println(Person.expensiveCars(prs, 2500));
    }
}