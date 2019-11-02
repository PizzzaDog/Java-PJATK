public class Message {
    public Priority pr;
    public Requestor requestor;

    Message(Requestor r){
        pr = Priority.genValue();
        this.requestor = r;
    }

}
