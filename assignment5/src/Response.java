public class Response extends Message {

    public int result;
    public Priority pr;

    public Response(int a, int b, Requestor requestor, Priority pr, int id) {
        super(requestor);
        this.pr = pr;
        result =addTwoNumbers(a,b);
        System.out.println(result + " id "+ id);
    }

    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public Priority getPr(){
        return pr;
    }
}
