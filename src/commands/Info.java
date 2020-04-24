package commands;

import managers.CollectionManager;
import managers.IOManager;

import java.time.format.DateTimeFormatter;

/**
 * Класс, описывающий конкретную реализацию команды info.
 *
 * @author Базанов Евгений
 */
public class Info extends Command {
    public Info(CollectionManager manager, IOManager ioManager) {
        super("info",
                "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        io.result.println("Тип коллекции: " + manager.getCollection().getClass());
        io.result.println("Время инициализации коллекции: " + manager.getDateTime().format(DateTimeFormatter.ISO_DATE_TIME));
        io.result.println("Количество элементов: " + manager.getSize());
    }
}