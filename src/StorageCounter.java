import java.io.*;

public class StorageCounter {
    private final String filename;
    private Counter counter = new Counter();


    public StorageCounter(String filename) {
        this.filename = filename;
    }

    public Counter load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            counter = (Counter) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка счетчик не загрузил");
        }
        return counter;
    }

    public void save(Counter counter) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(counter);
            System.out.println("Счетчик сохранился");
        } catch (IOException e) {
            System.out.println("Счетчик не сохранился");
        }
    }
}
