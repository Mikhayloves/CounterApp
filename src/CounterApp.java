import java.util.Scanner;

public class CounterApp {
    private Counter counter;
    private StorageCounter storageCounter;

    public CounterApp() {
        storageCounter = new StorageCounter("counter.dat");
        counter = storageCounter.load();
        System.out.printf("Счетчик загружен, значение %d%n", counter.getValue());
    }

    public void launchCounter() {
        System.out.println("/inc - увеличиваем счетчик\n" +
                "/stop - завершить программу\n" +
                "/reset - обнуление счетчика\n" +
                "Введите команду:\n");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String enter = sc.nextLine();
            switch (enter) {
                case "/inc":
                    counter.incCounter();
                    System.out.printf("Новое сотояние счетчика: %d%n", counter.getValue());
                    break;
                case "/stop":
                    storageCounter.save(counter);
                    System.out.printf("Текущее состояние счетчика: %d%n", counter.getValue());
                    System.out.println("Завершаю работу");
                    return;
                case "/reset":
                    counter.resetCounter();
                    System.out.printf("Счетчик обнулился и равен %d%n", counter.getValue());
                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }
}
