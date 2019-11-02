import java.util.PriorityQueue;

public class Requestor implements Runnable {
    public static PriorityQueue<Request> queueRequest = new PriorityQueue();
    public PriorityQueue<Response> queueResponse = new PriorityQueue<>();

    public void addToQueue(Request r) {
        queueRequest.add(r);
    }

    @Override
    public void run() {
        while(true) {
            addToQueue(new Request(this));
        }
    }
}