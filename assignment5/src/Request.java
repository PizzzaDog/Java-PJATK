import java.util.Random;

public class Request extends Message {
    private final int LOW = 0;
    private final int HIGH = 100;
    private Random rand = new Random();
    private int value1;
    private int value2;
    private static int count = 1;
    private int id;
    private Priority pr;


    public Request(Requestor r) {
        super(r);
        pr = Priority.genValue();
        value1 = genValue();
        value2 = genValue();
        setId();
        System.out.println(pr +" "+value1+" " + value2 + " " + id);
    }

    synchronized public void setId() {
        id = count;
        count++;
    }

    public int genValue(){
        return rand.nextInt(HIGH - LOW) + LOW;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getId() {
        return id;
    }

    public Priority getPr() {
        return pr;
    }
}
