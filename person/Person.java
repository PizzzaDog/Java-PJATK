package person;
public class Person{
    private String name;
    private int year;

    public Person(String name,int year ){
        this.name = name;
        this.year = year;
    }

    public Person(String name){
        this(name, 1900);
    }

    public String getName(){
        return name;
    }

    public int getBirthYear(){
        return year;
    }

    public boolean isFemale(){
        if (name.charAt(name.length() - 1) == 'a') {
            return true;
        }
        else return false;
    }

    public static Person getOlder(Person a, Person b){
        int c = a.getBirthYear();
        int h = b.getBirthYear();
        if(c < h){
            return a;
        } else {
            return b;
        }
    }

    public static Person getOldest(Person[] arr){
        Person max = null; 
        for( int i = 0; i < arr.length - 1; i++){
            if(arr[i].getBirthYear() > arr[i+1].getBirthYear()){
                max = arr[i+1];
            } 
        }
        return max;
    }

    public static Person getYoungestFemale(Person[] arr) {
        Person min = null;
        boolean wom = false;
        for(Person i : arr){
            if(i.isFemale()){
                if(min == null){
                    min = i;
                }
                min = (i.getBirthYear() <= min.getBirthYear())? min : i;
                wom = true;
            }
        } 

        if(wom){
            return min;
        } else {
            return null;
        } 
    }
       @Override
       public String toString() {
           return name + " " + year;
       }
    }


