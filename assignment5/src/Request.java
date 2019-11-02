import java.util.Random;

public class Request extends Message {

    public int value1;
    public int value2;
    Priority pr;
    private final int low = 0;
    private final int high = 100;

    public Request(Requestor r) {
        super(r);
        pr = Priority.genValue();
        Random rand = new Random();
        value1 = rand.nextInt(high - low) + low;
        value2 = rand.nextInt(high - low) + low;
    }
}
