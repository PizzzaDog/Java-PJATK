import java.util.Random;

public class Request extends Message {

    public int value1;
    public int value2;
    public int low = 10;
    public int high = 100;

    public Request(Requestor r) {
        super(r);
        Random rand = new Random();
        value1 = rand.nextInt(high - low) + low;
        value2 = rand.nextInt(high - low) + low;
    }
}
