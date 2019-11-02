public class Service implements Runnable {

   //TO:DO overrride run
   public void getRequest() {
       Request req = Requestor.queueRequest.poll();
       proceedRequest(req.value1, req.value2, req.requestor, req.pr);
   }

   public void proceedRequest(int a, int b, Requestor requestor, Priority priority) {
       requestor.addToQueue(new Response(), requestor);
   }

   public void addToResponseQueue(Response response, Requestor requestor) {

   }

}
