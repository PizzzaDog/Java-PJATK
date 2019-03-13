import java.lang.Math;
public class Square implements Comparable<Square> {
    private static int counter = 1; 
    private int length;
    private int number;

    public Square(int l){
        length = l;
        number = counter;
        counter++;
    }

    public double getArea(){
        return Math.pow(length, 2);
    }


    @Override
    public int compareTo(Square s) {
        double diff = getArea() - s.getArea();
        if (diff < 0) {
            return -1;
        }else if (diff > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override 
    public String toString() {
        return "("+ number + "): "+ getArea();
    }
}