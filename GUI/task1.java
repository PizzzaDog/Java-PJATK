/**
 * task1
 */
public interface Call {
    public abstract boolean can_call();
    void call();
}
/**
 * task1
 */
public interface Text{
    String can_text = "Can text";
    void text();
}
/**
 * task1
 */
public interface Internet {
    String has_internet = "Has internet";
    void internet();
}
/**
 * task1
 */
public interface Games {
    String has_games = "Has games";
    void games();
}

public class Land_line implements Call{
    @Override
    public boolean can_call() {
        return true;
    }
    @Override
    public void call() {
        System.out.println("Calling grandma");
    }
}