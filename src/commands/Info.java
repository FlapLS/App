package commands;

import managers.CollectionManager;
import managers.IOManager;

import java.time.format.DateTimeFormatter;

/**
 * Класс, описывающий конкретную реализацию команды info.
 *
 * @author Базанов Евгений.
 */
public class Info extends Command {
    public Info(CollectionManager manager, IOManager ioManager) {
        super("info",
                "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)",
                "",
                0,
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        io.getResult().println("Тип коллекции: " + manager.getCollection().getClass());
        io.getResult().println("Время инициализации коллекции: " + manager.getCreationTime().format(DateTimeFormatter.ISO_DATE_TIME));
        io.getResult().println("Количество элементов: " + manager.getSize());
    }
}