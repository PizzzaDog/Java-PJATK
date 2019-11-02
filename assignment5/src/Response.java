public class Response extends Message {

    public int result;
    public Priority pr;

    public Response(int a, int b, Requestor requestor, Priority pr) {
        super(requestor);
        this.pr = pr;
        result = a + b;
    }
}
