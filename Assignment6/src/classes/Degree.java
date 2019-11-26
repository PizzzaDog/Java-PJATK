package classes;

import java.util.Random;

public enum Degree {
    Bachelor,
    Engineer,
    Master,
    Doctor,
    Habilitation;

    public static Degree genValue() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
