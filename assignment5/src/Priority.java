import java.util.Random;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority genValue() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}



