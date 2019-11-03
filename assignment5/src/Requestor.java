
import java.util.Comparator;
import java.util.PriorityQueue;

public class Requestor implements Runnable {

    public static PriorityQueue<Request> queueRequest = new PriorityQueue<>(new Comparator<Request>() {
        @Override
         public int compare(Request o1, Request o2) {
            return o1.getPr().compareTo(o2.getPr());
        }
    }
    );

    //(Response r1, Response hr2) -> r1.pr.compareTo(hr2.pr)

    public PriorityQueue<Response> queueResponse = new PriorityQueue<>(Comparator.comparing(Response::getPr, Comparator.naturalOrder()));


    synchronized public void addToQueue(Request r) {
        queueRequest.add(r);
    }

    synchronized public void getFromQueue() {
        queueResponse.poll();
    }

    synchronized public boolean checkIsEmpty() {
        return queueResponse.isEmpty();
    }

    @Override
    public void run() {
        while(true) {
            addToQueue(new Request(this));
            while(checkIsEmpty()) {
                try {
                    Thread.sleep(2000);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
            getFromQueue();
        }
    }
}