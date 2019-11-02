public class Service implements Runnable {
    
   public void getRequest() {
       Request req = Requestor.queueRequest.poll();
       proceedRequest(req.value1, req.value2, req.requestor, req.pr);
   }

   public void proceedRequest(int a, int b, Requestor requestor, Priority priority) {
       addToResponseQueue(new Response(a, b, requestor, priority), requestor);
   }

   public void addToResponseQueue(Response response, Requestor requestor) {
        requestor.queueResponse.add(response);
   }

    @Override
    public void run() {
       while (true) {
           getRequest();
       }
    }

}
