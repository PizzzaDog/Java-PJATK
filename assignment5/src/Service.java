public class Service implements Runnable {

    public void getRequest() {
       Request req = getFromQueue();
       proceedRequest(req.getValue1(), req.getValue2(), req.requestor, req.getPr(), req.getId());
   }

   public void proceedRequest(int a, int b, Requestor requestor, Priority priority, int id) {
       addToResponseQueue(new Response(a, b, requestor, priority,id ), requestor);
   }

   synchronized public void addToResponseQueue(Response response, Requestor requestor) {
        requestor.queueResponse.add(response);
   }

   synchronized public Request getFromQueue() {
       return Requestor.queueRequest.poll();
   }

   synchronized public boolean checkIsReqEmpty() {
        return Requestor.queueRequest.isEmpty();
   }

    @Override
    public void run() {
       while (true) {
           while (checkIsReqEmpty()){
               try{
                   Thread.sleep(2000);
               } catch(Exception e) {
                   System.out.println(e);
               }

           }
           getRequest();
       }
    }
}
