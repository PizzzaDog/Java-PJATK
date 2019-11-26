package classes;

import java.util.Random;

public enum Group {
    _11,
    _12,
    _13,
    _14,
    _15,
    _16,
    _17,
    _18,
    _19,
    _20;

    public static Group genValue() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
