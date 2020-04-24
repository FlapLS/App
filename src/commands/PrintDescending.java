package commands;

import managers.CollectionManager;
import managers.IOManager;

import java.util.Comparator;

/**
 * Класс описывающий конкретную реализацию команды print descending.
 *
 * @author Базанов Евгений
 */
public class PrintDescending extends Command {
    public PrintDescending(CollectionManager manager, IOManager ioManager) {
        super("print_descending",
                "вывести элементы коллекции в порядке убывания",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        manager.getCollection().getMarines().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(io.result::println);
    }
}