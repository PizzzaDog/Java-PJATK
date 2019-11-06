import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Requester implements Runnable {

    public static PriorityBlockingQueue<Request> queueRequest = new PriorityBlockingQueue<>(5,new Comparator<Request>() {
        @Override
         public int compare(Request o1, Request o2) {
            if(o1 == null) {
                return 1;
            }else if(o2 == null){
                return -1;
            }
            return o1.getPr().compareTo(o2.getPr());
        }
    }
    );

    public PriorityBlockingQueue<Response> queueResponse = new PriorityBlockingQueue<>(10,Comparator.comparing(Response::getPr, Comparator.naturalOrder()));


    public void getFromQueue() {
            queueResponse.poll();
    }

    public boolean checkIsEmpty() {
        return queueResponse.isEmpty();
    }

    @Override
    public void run() {
        while(true) {
            queueRequest.add(new Request(this));
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