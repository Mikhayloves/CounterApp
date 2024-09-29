import java.io.Serializable;

public class Counter implements Serializable {

    private int value;

    public int getValue() {
        return value;
    }

    public void incCounter() {
        value++;
    }

    public void resetCounter() {
        value = 0;
    }
}
