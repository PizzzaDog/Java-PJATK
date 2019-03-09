public class Person {
    
    private String name;
    private Car cars;

    public Person(String name) {
        this.name = name;
        cars = null;
    }

    public Person buys(String make, int price){
        if(cars == null){
            cars = new Car(make, price);
        }else {
            Car tmp = cars;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
                tmp.getNext();
            }
            
        }
        
        return this;
    }

    public String getName(){
        return name;
    }

    public void showCars() {
        this.cars.showCars();
    }

    public void showCarsRev() {

    }

    public int getTotalPrice() {
        int tot = 0;
        while(cars.getNext() != null){
            tot += cars.getPrice();
            cars = cars.getNext();
        }
        return tot;

    }

    public boolean hasCar(String make) {
        boolean has = false;
        while(cars.getNext() != null){
            if(cars.getMake().equals(make)){
                has = true;
            }
        }
        return has;
    }

    public Car mostExpensive() {
        Car most = cars;
        
        while(cars.getNext() != null){
            if (cars.getNext().getPrice() > cars.getPrice()){
                most = cars.getNext();
            }       

            cars = cars.getNext();
        }
        return most;
    }

    
}