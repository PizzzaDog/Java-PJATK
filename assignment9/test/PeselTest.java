import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.reflect.InvocationTargetException;


import static org.junit.jupiter.api.Assertions.*;

class PeselTest {

    @Test
    void validation() {
        Method method;
        try {
            method = Pesel.class.getDeclaredMethod("validation", String.class);
            method.setAccessible(true);
            Boolean result1 = (Boolean) method.invoke("","20233143600");
            Boolean result2 = (Boolean) method.invoke("", "4405140135");
           assertTrue(result1);
            assertFalse(result2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getDate() {
        Method method;
        Date exp = null;
        try {
            method = Pesel.class.getDeclaredMethod("getDate", String.class);
            method.setAccessible(true);
            exp = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-31");
            Date dateResult = (Date) method.invoke("","20233143600");
            assertEquals(exp, dateResult);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getSex() {
        Method method;
        try {
            method = Pesel.class.getDeclaredMethod("getSex", String.class);
            method.setAccessible(true);
            Sex result1 = (Sex) method.invoke("","20233143600");
            Sex result2 = (Sex) method.invoke("","20233143610");
            assertEquals(Sex.FEMALE, result1);
            assertEquals(Sex.MALE, result2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}